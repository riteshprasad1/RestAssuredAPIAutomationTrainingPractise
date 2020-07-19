package test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PathScenario {
	
	
	@Test
	public void PathScenario() throws FileNotFoundException {
		
		
		
		given()
		
		.header("content-type","application/json")
		
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.get()
		.then().log().all()
		.root("data[0]")
		.body("id", equalTo(1));
		
	}
	
	@Test
	public void rootPath() throws FileNotFoundException {
		
		RestAssured.rootPath="data[0]";
		
		given()
		
		.header("content-type","application/json")
		
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.get()
		.then().log().all()
		.body("id", equalTo(1));
		
	}
	@Test
	public void jsonPath() throws FileNotFoundException {
		
		RestAssured.rootPath="data[0]";
		
		String str =given()
		
		.header("content-type","application/json")
		.when()
		.get("https://reqres.in/api/users?page=2").body().toString();
		JsonPath jp = new JsonPath(str);
		System.out.println(jp.get("data[0]"));
		
		
	}
	
	@Test
	public void PreparedSpecifications() throws FileNotFoundException {
		
		RequestSpecBuilder rsb = new RequestSpecBuilder();
		rsb.addHeader("content-type", "application/json");
		
		rsb.setBaseUri("https://reqres.in");
		rsb.addQueryParam("page", "2");
		RequestSpecification reqSec = rsb.build();
		
		given()
		.spec(reqSec)
		.when()
		.get("/api/users?page=2")
		.then()
		.assertThat()
		.statusCode(200);
	
		
		
	}
	
	
}