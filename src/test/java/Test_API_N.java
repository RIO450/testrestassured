import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Payload.Payloads;
import Utils.Routes;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_API_N {
	
	 @BeforeClass
	    public void init() {
		 preconnditions.setup(); // Initialize RequestSpecification
		 Postrequestvalidations.resposnesetup();
	    }
	
	@Test(dataProvider= "datafornegative",dataProviderClass=Payloads.class)
	public void Authentication_N(Map<String,Object>userdata) {
		String userName=(String)userdata.get("userName");
		String Password=(String)userdata.get("password");
	
		Response response=	RestAssured.given().spec(preconnditions.requestspc)
			
				.body(userdata)
				.when().post(Routes.POST_AUTH).
			then().spec(Postrequestvalidations.resposnesetup())
				.log().all().extract().response();
	System.out.println(response);
	}
	
	
}


