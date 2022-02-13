package sdet27.GenericUtility;

import io.restassured.response.Response;

/**
 * this class will contains generic methods specific to rest assured
 * @author DELL
 *
 */
public class RestAssuredUtility {
	
	
	public String getjSONData(Response resp, String jsonPath) {
		String jsonData = resp.jsonPath().get(jsonPath);
		return jsonData;
	}

}
