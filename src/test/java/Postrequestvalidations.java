import static org.hamcrest.Matchers.*;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;	

public class Postrequestvalidations {
	
	public static  ResponseSpecification  resspe;
	public static  ResponseSpecification resposnesetup() {
		 return resspe=new ResponseSpecBuilder()
			.expectStatusCode(404)
			.expectContentType("application/json")
			.expectBody("message",equalTo("User not found!"))
			.expectBody("code",equalTo("1207"))
		.build();
}
	
}