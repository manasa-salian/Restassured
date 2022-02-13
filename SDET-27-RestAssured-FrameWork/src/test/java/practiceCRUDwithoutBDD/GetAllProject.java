package practiceCRUDwithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProject {
	@Test
	public void getallProjects() 
	{
		//Step 1
		int expstatus =200;
		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		//Step 2
		System.out.println(resp.prettyPeek());
		int actStatus = resp.getStatusCode();
		Assert.assertEquals(expstatus, actStatus);
	}
}


