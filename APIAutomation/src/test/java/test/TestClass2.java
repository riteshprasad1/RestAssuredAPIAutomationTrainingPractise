package test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestClass2 {
	
	@Test
	public void getListOfUsers() {
		given()
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.get()
		.then().statusCode(200);
	}
	
	@Test
	public void getListOfUsers1() {
		given()
		.contentType(ContentType.JSON)
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.get()
		.then().statusCode(200);
	}
	
	@Test
	public void getListOfUsers2() {
		Response response=given()
		.contentType(ContentType.JSON)
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.get();
		
		System.out.println(response.asString());
		
	}
	
	@Test
	public void getListOfUsers3() {
		given()
		.contentType(ContentType.JSON)
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.get().then().body("page", equalTo(1));
		
		/*
		 * JsonPath jp=new JsonPath(responseInString); jp.get("page");
		 */	
	}

	@Test
	public void hamcresttest1() {
		given()
		.contentType(ContentType.JSON)
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.get()
		.then()
		.assertThat()
		.body("data[2].email", containsString("emma.wong@reqres.in"));
		
		/*
		 * JsonPath jp=new JsonPath(responseInString); jp.get("page");
		 */	
	}
	@Test
	public void validateReponseHeader() {
		given()
		.contentType(ContentType.JSON)
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.get()
		.then()
		.assertThat()
		.header("server", equalTo("cloudflare"));
		
		/*
		 * JsonPath jp=new JsonPath(responseInString); jp.get("page");
		 */	
	}


}