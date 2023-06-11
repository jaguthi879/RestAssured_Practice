package RestAssuredPractice2;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class PetStore {
	
	@Test(priority=0)
	public void getmethod() {
		
		given().header("Content-Type","application/json").accept(ContentType.JSON).
		
		when().get("https://petstore.swagger.io/v2/store/order/2").
		
	then().log().all().statusCode(200);
	}
	
	@Test(priority=1)
	public void postmethod() {
		HashMap data= new HashMap();
		data.put("id", "0");
		data.put("petId", "0");
		data.put("quantity", "0");
		data.put("shipDate", "2023-02-02T14:37:28.794Z");
		data.put("status", "placed");
		data.put("complete", "true");
		
	String response=given().header("Content-Type","application/json").accept(ContentType.JSON).
		
		when().post("https://petstore.swagger.io/v2/store/order").
		
	   then().log().body().extract().response().asString();
	System.out.println(response);
	
	//Assert.assertArrayEquals(null, null);
	
	}
	@Test(priority=2)
	public void getmethod1() {
		given().header("Content-Type","application/json").accept(ContentType.JSON).
		when().get("https://petstore.swagger.io/v2/store/inventory")
		.then().log().body().and().assertThat().statusCode(200);
	}
		
	}

