package Parameters;

import  static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

public class RequestChaining {
	@Test
	public void Chaining() {
		Response response = when()
				.get("http://localhost:8084/projects");
		String proId= response.jsonPath().get("[5].ProjectId");
		System.out.println(proId);
		
		given()
		   .pathParam("ProjectId", proId)
		   
		.when()   
		   .delete("http://localhost:8084/projects/{ProjectId}")
		   
		 .then()
		    .assertThat().statusCode(201)
		    .log().all();
		
				
	}

}
