package test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LogBasedOnSituations {
	
	
	
	@Test
	public void requestLogging() throws FileNotFoundException {
		JSONObject jo = new JSONObject();
		jo.put("name", "Ritesh");
		jo.put("job","QA");
		
		
	//	FileInputStream fis = new FileInputStream("C:\\Users\\prasad_rt\\eclipse-workspace\\APIAutomation\\src\\test\\resources\\createPayload.txt");
		given()
		//After given we are using log
		.log().body()
		.header("content-type","application/json")
		.body(jo.toString())
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.post()
		.then().assertThat().statusCode(201);
	}
	
	
	@Test
	public void logWhenError() throws FileNotFoundException {
		JSONObject jo = new JSONObject();
		jo.put("name", "Ritesh");
		jo.put("job","QA");
		
		
	//	FileInputStream fis = new FileInputStream("C:\\Users\\prasad_rt\\eclipse-workspace\\APIAutomation\\src\\test\\resources\\createPayload.txt");
		given()
		//After given we are using log
		.log().body()
		.header("content-type","application/json")
		.body(jo.toString())
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.post()
		.then().log().ifValidationFails()
		.assertThat().statusCode(201);  
	}
	
	
}