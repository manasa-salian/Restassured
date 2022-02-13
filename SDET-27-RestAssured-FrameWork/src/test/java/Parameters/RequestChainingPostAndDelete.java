package Parameters;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

import  static io.restassured.RestAssured.*;

import java.util.Random;

public class RequestChainingPostAndDelete {
	@Test
	public void Chaining() {
		
		
		Random ran=new Random();
		int randomnum=ran.nextInt(300);
		
		
		
	JSONObject obj=new JSONObject();
	obj.put("createdBy", "mansa");
	obj.put("projectName", "testyan2020"+randomnum);
	obj.put("status", "Created");
	obj.put("teamSize", 20);
	 
	 Response response = given()
			 .body(obj)
			 .contentType(ContentType.JSON)
			 
			 .when()
			   .post("http://localhost:8084/addProject");
	 
	 String proId=response.jsonPath().get("ProjectId");
	 given().pathParam("ProjectId", proId)
	 
	 .then() 
	   .statusCode(204).contentType(ContentType.JSON)
	   .log().all();
			   
			 	  
	
	
	}

}
