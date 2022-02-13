package practiceCRUDwithBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateTest {
	@Test
	public void update() {
	Random r=new Random();
	int randomNumber=r.nextInt(500);
	
	JSONObject jObj=new JSONObject();//jason simple dependency
	jObj.put("created", "manasa");
	jObj.put("projectName", "Testyantra"+randomNumber);
	jObj.put("status", "Created");
	jObj.put("teamSize", 3500);	
	
	given() 
	    .body(jObj)
	    .contentType(ContentType.JSON)
	.when()
	    .put("http://localhost:8084/projects/TY_PROJ_002")
	    
	 .then()
	     .assertThat().contentType(ContentType.JSON)
	     .statusCode(200)
	     .log().all();

}
}
