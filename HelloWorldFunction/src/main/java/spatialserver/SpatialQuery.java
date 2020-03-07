package spatialserver;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;

public class SpatialQuery {

	private static MongoClient mongoClient;
	private static MongoDatabase mongoDatabase;
	private static MongoCollection<Document> mongoCollection;

	public static void initMongoDB() {
		if (mongoClient == null && mongoDatabase == null && mongoCollection == null) {
			mongoClient = MyAmigooSpatialEngineHelpers.connectToMongoDB(Constants.mongoDBURI);
			mongoDatabase = MyAmigooSpatialEngineHelpers.getMongoDatabase(mongoClient, Constants.mongoDBQueryDatabase);
			mongoCollection = MyAmigooSpatialEngineHelpers.getMongoCollection(mongoDatabase,
					Constants.mongoDBSpatialCollection);
		} else {
			return;
		}
	}

	public static ArrayList<Document> getResponderVehiclesAt(double longitude, double latitude, double maxDistance,
			double minDistance) {

		initMongoDB();
		System.out.println("getResponderVehiclesAt");
		Point refPoint = new Point(new Position(longitude, latitude));
		ArrayList<Document> responderVehicles = new ArrayList<>();
		FindIterable<Document> spatialResults;
		spatialResults = mongoCollection
				.find(Filters.near(Constants.spaitlIndexForResponderVehicle, refPoint, maxDistance, minDistance));

		if (spatialResults.first() == null) {
			System.out.println("Nothing Found");
			Document doc = new Document();
			doc.append("result", "NotFound");
			responderVehicles.add(doc);
		}

		for (Document doc : spatialResults) {
			doc.size();
			responderVehicles.add(doc);
			//System.out.println(doc.get("responderID"));
		}
		return responderVehicles;
	}

	/*public static void main(String args[]) {
		System.out.println(getResponderVehiclesAt(12.3, 1.6, 2, 1).toString());
	}*/

}
