package Mypackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_BasicAPI_GET {
	
	@SuppressWarnings("unused")
	@Test
	void weather_Code()
	{
		//Basic URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		//Request Object created
		RequestSpecification httprequest =RestAssured.given();
		
		//Response Object
		Response httpresponse=httprequest.request(Method.GET,"/Chennai");
		
		//Print responsebody
		String responseBody = httpresponse.getBody().asString();
		
		//Print Status Code
		int StatusCode= httpresponse.getStatusCode();
		System.out.println("The Staus code is " + StatusCode);
		Assert.assertEquals(StatusCode, 200);
		
		//Print Status Line
		String Statusline = httpresponse.getStatusLine();
		System.out.println("The Status line is " + Statusline);
		Assert.assertEquals(Statusline, "HTTP/1.1 200 OK");

	}
	

}
