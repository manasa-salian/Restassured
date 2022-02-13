package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParametersTest {
	@Test
	public void multipleParams() {
		
	given()
		.pathParam("username", "manasa-salian")
		.queryParam("sort", "created")
		.queryParam("per_page", "100")
		
	.when()
	   .get("https://api.github.com/users/{username}/repos")
	.then()
	   .assertThat().statusCode(200)
	   .log().all();
	}

}
