package restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Api_test2 {
	@Test
	public void testpost() {
		
		JSONObject request=new JSONObject();
		   request.put("name","Dolly");
		   request.put("job", "Doctor");
			System.out.println(request.toJSONString());
			
			baseURI="https://reqres.in/api";
			
			given().
			  //header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
			when().
			  post("/users").
			then().
			  statusCode(201)
			  .log().all();

		
	}

}



