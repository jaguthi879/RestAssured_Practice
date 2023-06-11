package restassured;


import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Tests_api {	
	@Test
		public void get() {
		
			baseURI="http://reqres.in/";
			given().get("api/users?page=2").
			then().statusCode(200).log().all();
			}
}