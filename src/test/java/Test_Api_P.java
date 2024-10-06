	import java.util.Map;
	
	import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
	
	import com.jayway.jsonpath.JsonPath;
	
	import Payload.Assertions;
	import Payload.Payloads;
	import Utils.RestUtils;
	import Utils.Routes;
	import io.restassured.RestAssured;
	import io.restassured.filter.log.RequestLoggingFilter;
	import io.restassured.filter.log.ResponseLoggingFilter;
	import io.restassured.response.Response;
	
	
	public class Test_Api_P extends preconnditions{
	
		@BeforeClass
		public void init() {
			setup();
		}
		
		@Test
		public void Authencation() {
		
			Map<String, Object>	dataAuthentication = Payloads.payload_Authentiction("geethaaug","Geetha@22");
	Response response=	RestAssured.given().spec(requestspc).body(dataAuthentication)
			.when().post(Routes.POST_AUTH)
			.then().statusCode(200).log().all().extract().response();
		Assertions.authassertions(response);
		}
		
		@Test
		public void Tokengenetaion() {
	
			Map<String, Object>	dataAuthentication = Payloads.payload_Authentiction("geethaaug","Geetha@22");
	Response response=	RestAssured.given().spec(requestspc).body(dataAuthentication)
			.when().post(Routes.token)
			.then().statusCode(200).log().all().extract().response();
	Assertions.tokenAssertions(response);
		}
		@Test
		public void Getall() {
			int limit = 1; 
	        int offset = 4;
	        String url=Routes.getBooksUrl(limit, offset);
	       System.out.println("PAGNATIONURL " +  url);
	
	Response response=	RestAssured.given().spec(requestspc)
	         
			.when().get(url)
			.then().statusCode(200).extract().response();
	
	String res=response.getBody().asString();
	
	String titile=JsonPath.read(res,"$.books[5].title");
	System.out.println(titile);
		
	}
	
	@Test(retryAnalyzer=Utils.RetryAnalyzer.class)
	public void Filter() {
		
	Response response=	RestAssured.given().spec(requestspc)
	         .filter(new RestUtils())//* added header used filter functionality
			.when().get(Routes.getall)
			.then().statusCode(200).extract().response();
	
	String res=response.getBody().asString();
	
	String titile=JsonPath.read(res,"$.books[5].title");
	System.out.println(titile);
		
	}
	@Test
	public void LogrequestusinFilter() {
		
	Response response=	RestAssured.
			
			given().spec(requestspc)
	         .filter(new RestUtils())
	
	
			.when().get(Routes.getall) // Asserts status code separately

.then().statusCode(200).extract().response();
	
	
	String res=response.getBody().asString();
	
	String titile=JsonPath.read(res,"$.books[5].title");
	
	
	System.out.println(titile);
		
	String contentType = response.getHeader("ContentType");	
	System.out.println("Content-Type: " + contentType);
	}
	
	}
	
	
	
	
