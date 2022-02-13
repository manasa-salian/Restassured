package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidationTest {
	@Test
	public void verify() {
		String expectedProj="aak";
		Response response = when()
				.get("http://localhost:8084/projects");
	List<String> res=response.jsonPath().get("projectName");
	boolean flag=false;
	for(String pNames:res) {
		
			if(pNames.equals(res)) {
				flag=true;
			}
		
			
		}
	response.then()
	        .assertThat()
	        .contentType(ContentType.JSON)
	        .log().all();
	Assert.assertEquals(flag, true);
	}
		
	}


