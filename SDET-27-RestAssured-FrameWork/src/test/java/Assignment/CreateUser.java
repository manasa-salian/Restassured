package Assignment;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUser {
@Test

public void createProject() {


	
	
		JSONObject obj=new JSONObject();
		obj.put("designation", "SDET");
		obj.put("dob", "25/05/1999");
		obj.put("email", "nithesh@gmail.com");
		obj.put("empName", "nithesh");
		obj.put("experience", 15);
		obj.put("mobileNo", "hdfc");
		obj.put("role", "ROLE_ADMIN");
		obj.put("username", "nithesh");
		
		given()
		  .body(obj)
		  .contentType(ContentType.JSON)
		  
		.when()  
		   .post("http://localhost:8084/employees")
		   
		.then()
		    .assertThat().contentType(ContentType.JSON)
		    .statusCode(201)
		    .log().all();
}
		
		
}
