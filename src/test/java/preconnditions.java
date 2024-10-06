import io.restassured.specification.RequestSpecification;
import Utils.Routes;
import io.restassured.builder.RequestSpecBuilder;


public class preconnditions {
	
	public  static RequestSpecification requestspc;
	public static void setup() {
		
		requestspc = new RequestSpecBuilder()
.setBaseUri(Routes.Baseuri)
.addHeader("Content-Type","application/json")
.build();
		
	}

}	
