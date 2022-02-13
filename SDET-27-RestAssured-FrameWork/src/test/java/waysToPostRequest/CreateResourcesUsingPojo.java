package waysToPostRequest;

import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;

import  static io.restassured.RestAssured.*;

public class CreateResourcesUsingPojo {
	
@Test

public void create() {
	
PojoClass pojo=new PojoClass("manasa","sdet 27 rest assured project","completed",300);
	
given()
   .body(pojo)
   .contentType(ContentType.JSON)
.when()
   .post("http://localhost:8084/addProject")

.then()
   .assertThat().statusCode(201)
   .contentType(ContentType.JSON)
   .log().all();

   
}
	

}
