package practiceCRUDwithBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateResource {
	@Test
	
	public void createResource() {
		Random ran=new Random();
		int randomnum=ran.nextInt(300);
		
		JSONObject jObj=new JSONObject();

		jObj.put("created", "manasa salian12");
		jObj.put("projectName", "Testyantra"+randomnum);
		jObj.put("status", "Created");
		jObj.put("teamSize", 3500);	
		
		//configure base URI
		baseURI="http://localhost";
		port=8084;
				
		
		given() 
		  .body(jObj)
		  .contentType(ContentType.JSON)
		.when()  
		   .post("addProject")
		.then()
		   .assertThat().statusCode(201)
		   .contentType(ContentType.JSON)
		   .log().all();
		
	}

}
