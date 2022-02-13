package waysToPostRequest;

import static  io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateResourceUsingJasonObject {
@Test
public void create() {
	Random r=new Random();
	int random=r.nextInt(200);
	
	JSONObject jObj=new JSONObject();
	jObj.put("createdBy", "manasa salian123");
	jObj.put("projectName", "TestYantra"+random);
	jObj.put("staus", "Created");
	jObj.put("teamSize",20);
	
	given()
	   .body(jObj)
	   .contentType(ContentType.JSON)
	
	.when()
	   .post("http://localhost:8084/addProject")
	 .then()
	    .assertThat().statusCode(201)
	    .contentType(ContentType.JSON)
	    .log().all();

}
}
