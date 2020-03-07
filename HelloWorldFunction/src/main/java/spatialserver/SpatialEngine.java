package spatialserver;

import java.util.ArrayList;

import org.bson.Document;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;


/**
 * Lambda function that simply prints "Hello World" if the input String is not provided,
 * otherwise, print "Hello " with the provided input String.
 */
public class SpatialEngine implements RequestHandler<ServerlessInput, ServerlessOutput> {

	@Override
	public ServerlessOutput handleRequest(ServerlessInput input, Context context) {
		// TODO Auto-generated method stub
		//Test3 output1 = new Test3("hello new lambda");
		Gson gson = new Gson();
		//SpatialQuery spatialQuery= new SpatialQuery();
		IncidentLocation incidentLocation=gson.fromJson(input.getBody(),IncidentLocation.class);
		incidentLocation.getIncidentLatitude();
		ArrayList<Document> respVehicles= new ArrayList<>();
		respVehicles=SpatialQuery.getResponderVehiclesAt(incidentLocation.getIncidentLongitude(), incidentLocation.getIncidentLatitude(), incidentLocation.getMaxQueryDistance(), incidentLocation.getMinQueryDistance());
		ServerlessOutput output = new ServerlessOutput();
		output.setBody(gson.toJson(gson.toJson(respVehicles)));
		return output;
	}
   
  
}