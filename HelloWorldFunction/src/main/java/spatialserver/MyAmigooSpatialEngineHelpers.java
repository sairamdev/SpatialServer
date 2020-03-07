package spatialserver;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MyAmigooSpatialEngineHelpers {
	public static MongoClient connectToMongoDB(String mongoDBURI) {

		MongoClient mongoClient = MongoClients.create(mongoDBURI);
		return mongoClient;

	}

	public static MongoDatabase getMongoDatabase(MongoClient mongoClient, String mongoDBName) {
		MongoDatabase mongoDatabase = mongoClient.getDatabase(mongoDBName);
		return mongoDatabase;

	}

	public static MongoCollection<Document> getMongoCollection(MongoDatabase mongoDatabase, String mongoDBCollName) {
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(mongoDBCollName);
		return mongoCollection;

	}
}
