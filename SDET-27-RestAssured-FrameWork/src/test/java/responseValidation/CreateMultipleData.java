package responseValidation;

//import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;

//import org.testng.annotations.Test;

public class CreateMultipleData{

@Test(dataProvider ="getData")

public void create(String createdBy, String projectName, String status, int teamSize) {

	PojoClass pojo=new PojoClass(createdBy, projectName, status, teamSize);
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
@DataProvider
public Object[][] getData() {
	Object[][] objArray=new Object[2][4];
	objArray[0][0]="Manasa";
	objArray[0][1]="Manasa Project type";
	objArray[0][2]="completed";
	objArray[0][3]=200;
	
	objArray[1][0]="salian";
	objArray[1][1]="salian Project type";
	objArray[1][2]="completed";
	objArray[1][3]=20;
	
	return objArray;

}
}