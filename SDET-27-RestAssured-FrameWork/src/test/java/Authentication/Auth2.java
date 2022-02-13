package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Auth2 {

	@Test
	public void auths() {
		Response response=given()
				.formParams("client_id","SDET27-2022")
				.formParams("client_secret", "40236cd8a765d7d75782b613b0f7a196")
				.formParams("grant_type", "client_credentials")
				.formParams("redirect_uri","https://example.com")
	
			.when()
			   .post("http://coop.apps.symfonycasts.com/token");
		    
		String token=response.jsonPath().get("access_token");
		
		given()
		    .auth().oauth2(token)
		    .pathParam("USER_ID","2787")
		  
		.when()
		      .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		 .then()
		       .log().all();	
				
		
	}
	
	
}
