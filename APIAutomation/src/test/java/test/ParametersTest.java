package test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParametersTest {

	
//	int usernumber =2;
//	int userNumberValue =2;
	
	@Test(dataProvider = "Data")
	public void getListOfUsers(int usernumber, int userNumberValue ) {// with query parameter ..it will append at the end
		given()
		.param("page",2)
		.get("https://reqres.in/api/users")
		.then().log().all();
	}
	
	@Test(dataProvider = "Data")
	public void getSingleUser(int usernumber, int userNumberValue) {// with path parameter .
		given()
		.pathParam("usernumber", userNumberValue)
		.when()
			
		.get("https://reqres.in/api/users/{usernumber}")
		.then().log().all();
	}
	
	@DataProvider(name="Data")
	public Object[][] getPageNumberUserNumber()
	{
		return new Object[][] {
			{1,2},
			{2,3},
			{3,4}
			
		};
		
	}
	
}
