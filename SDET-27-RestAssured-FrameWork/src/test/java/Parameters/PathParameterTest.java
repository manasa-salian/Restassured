package Parameters;

import org.testng.annotations.Test;

import  static io.restassured.RestAssured.*;

public class PathParameterTest {
	@Test
	public void PathParameterTest() {
		String proId="TY_PROJ_002";
		given()
		  .pathParam("ProjectId", proId)
		.when()
		  .put("http://localhost:8084/projects/{ProjectId}")
		.then()
		   .log().all();
	}

}
