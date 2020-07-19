package test;

import static io.restassured.RestAssured.given;


import org.testng.annotations.Test;

public class ParametersTest2 {

	
//	int usernumber =2;
//	int userNumberValue =2;
	
	@Test
	public void getListOfUserswithQueryParameter() {// with query parameter ..it will append at the end
		int i =given()
		.get("https://reqres.in/api/users")
		.then()
		.extract()
		.path("data[0].id");
		
		System.out.println(i);
		given()
		.pathParam("paramName", i)
		.get("https://reqres.in/api/users/{paramName}")
		.then()
		.log()
		.all();
		
	}
	
	
}
