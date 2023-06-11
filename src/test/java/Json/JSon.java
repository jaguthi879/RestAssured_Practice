package Json;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class JSon {
	@Test(dataProvider ="BooksData")
	public void Dynamson(String isbn, String aisle)
	{
	RestAssured.baseURI= "http://216.10.245.166";
	String response =given().header("Content-Type","application/json").body(Payload.addbook(isbn,aisle)).
	when().post("/Library/Addbook.php").then().log().all().assertThat().statusCode(200).extract().response().asString();
	System.out.println(baseURI);System.out.println("response"+response);
	JsonPath js = new JsonPath(response);
	String id = js.getString("ID");System.out.println(id);
	}
	@DataProvider(name="BooksData")
	public Object[][] getData() {return new Object[][] {
		{"anxgdhh","246343"},{"cyeghdj","47253"},{"gjksgw","223946"}};
		}
}
