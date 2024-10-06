package Payload;

import org.testng.Assert;

import com.jayway.jsonpath.JsonPath;

import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Assertions {
	public static void authassertions(Response response) {
		
		Boolean value =JsonPath.read(response.body().asString(), "$");
		System.out.println("value is "+value);
		Assert.assertEquals(value, true);
		System.out.println("assertion is vlidated");
	
}
	public static void tokenAssertions(Response response) {
		
		/*
		 * String resbody=response.body().asPrettyString(); String
		 * status=JsonPath.read(resbody,"$.status"); String result =
		 * response.jsonPath().
		 * getString("find { it.result == 'User authorized successfully.'}.result");
		 * System.out.println("kkjggj"+result);
		 */
		 String token = response.jsonPath().getString("token");
	        String expires = response.jsonPath().getString("expires");
	        System.out.println(token);
	        System.out.println(expires);
	        String status = response.jsonPath().getString("status");
	        String result = response.jsonPath().getString("result");
	Assert.assertEquals(status, "Success");
	Assert.assertEquals(result, "User authorized successfully.");

	}
	
	
	
}