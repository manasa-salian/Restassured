package com.RMGYantraTests;

import PojoLibrary.PojoClass;
import  static io.restassured.RestAssured.*;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import sdet27.GenericUtility.BaseAPIClass;
import sdet27.GenericUtility.EndPoints;

public class UpdatingResourcesAndVerifyInDatabase extends BaseAPIClass {
	@Test
	//String projectId = "TY_PROJ_1004";
	
	public void updateResourceAndVerify() throws Throwable {
		//String projectId = "TY_PROJ_1004";
		PojoClass pLib=new PojoClass("mansa", "Loreal", "Created", 1000);
		
		
		
		Response resp= given()
				.body(pLib)
				.contentType(ContentType.JSON)
				
		.when()
		    .put(EndPoints.updateProjects);
		    
		  String expData = rLib.getjSONData(resp,"projectID");
		 Reporter.log(expData+" data updated"+true);
		 
		 String query="select * from projects;";
		 String actData = dLib.executeQueryAndGetData(query, 1, expData);
		 Reporter.log(actData,true);
		 
		 Assert.assertEquals(expData, actData);
		 Reporter.log("data updated sucessful",true);
		    
		}
		    
				
				

	}
	

