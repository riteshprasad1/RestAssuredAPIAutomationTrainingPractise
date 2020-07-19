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

public class PostTest {
	
	@Test
	public void getListOfUsers() {
		given()
		.header("content-type","application/json")
		.body("{\r\n" + 
				"    \"name\": \"RiteshPrasad\",\r\n" + 
				"    \"job\": \"QA\"\r\n" + 
				"}")
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.post()
		.then().log().all();
	}
	
	@Test
	public void getListOfUsersUsingFileRead() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("C:\\Users\\prasad_rt\\eclipse-workspace\\APIAutomation\\src\\test\\resources\\createPayload.txt");
		given()
		.header("content-type","application/json")
		.body(fis)
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.post()
		.then().log().all();
	}
	
	@Test
	public void postBodyUsingJsonObject() throws FileNotFoundException {
		JSONObject jo = new JSONObject();
		jo.put("name", "Ritesh");
		jo.put("job","QA");
		given()
		.header("content-type","application/json")
		.body(jo.toString())
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.post()
		.then().log().all();
	}
	
	
	
}