package responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class VerifyResponseTimeHamcrest {
	@Test
	public void verify() {
	when()
		
        .get("http://localhost:8084/projects")
    .then()
      .assertThat().time(Matchers.lessThan(5000L),TimeUnit.SECONDS)
      .log().all();
	}
       
	

}
