package Authentication;

import org.testng.annotations.Test;

import  static io.restassured.RestAssured.*;

public class BearerTokenTest {
	@Test
	public void Authentication () {
		given()
		 .auth().oauth2("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")	
		 
		.when()
		   .get("https://github.com/settings/tokens")
		.then()
		   .assertThat().statusCode(200)
		   .log().all();
		
	}

}
