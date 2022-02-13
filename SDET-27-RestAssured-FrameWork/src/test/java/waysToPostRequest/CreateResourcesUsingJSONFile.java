package waysToPostRequest;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateResourcesUsingJSONFile {
	@Test
	
	public void create() {
		File fp=new File("./resources.json");
	given() 
		.body(fp)
		.contentType(ContentType.JSON)
 .when()
	  .post("http://localhost:8084/addProject")
	 
.then()
      .assertThat().statusCode(201)
      .contentType(ContentType.JSON)
      .log().all();
	  
	
		
	}

}
