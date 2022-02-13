package waysToPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static  io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateResourceUsingHashMap {
	@Test
	public void create() {
		HashMap map=new HashMap();
		
		map.put("createdBy","manasa");
		map.put("projectName", "TestYanra1");
		map.put("status", "Created");
		map.put("teamSize", 50);
		
		given()
		  .body(map)
		  .contentType(ContentType.JSON)
		.when()
		   .post("http://localhost:8084/addProject")
		 .then()
		    .assertThat().statusCode(201)
		    .contentType(ContentType.JSON)
		    .log().all();
		
		
		
	}

}
