package Payload;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;

import com.jayway.jsonpath.JsonPath;

import Utils.Routes;

public class Payloads {

	public static Map<String,Object>payload_Authentiction(String userName,String password) {
		Map<String,Object>dataAuth=new HashMap<>();
			dataAuth.put("userName", userName);
		dataAuth.put("password", password);
		return dataAuth;
		
	}
	
				@DataProvider
				public  Object[][] datafornegative() throws IOException {
					Object[][] obj=new Object[0][0];
			
			       String jsonData=FileUtils.readFileToString(new File(Routes.NegativeAuthjson),"UTF-8");
			        
			        System.out.println("jsondata+ "+jsonData);
			        List<Map<String,Object>>Data=JsonPath.read(jsonData,"$");
			        System.out.println("Data"+Data);
			        obj=new Object[Data.size()][1];
			        for(int i=0;i<Data.size();i++) {
			        	obj[i][0]=Data.get(i);
			        	System.out.println("obj"+obj);
			        }
					return obj;
			        
			}

	
}