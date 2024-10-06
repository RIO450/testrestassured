package Utils;

public class Routes {

public static String  Baseuri="https://bookstore.toolsqa.com";
public static	String POST_AUTH="/Account/v1/Authorized";
public static String File="C:\\Users\\Lenovo\\eclipse-workspace\\com.wiproRestAassured\\DataFiles";
public static final String NegativeAuthjson= File+"\\Payload_NegativeData_Auth.json";
public static String token="/Account/v1/GenerateToken";
public static String getall="/BookStore/v1/Books";






public static String getBooksUrl(int limit, int offset) {
    return Baseuri + getall +"?limit=" + limit + "&offset=" + offset;
    
}
}
