package bookStoreAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class GetBookDetails {

	@Test
	public void getBookDetails()
	{
		given()
		
		.when()
			.get("https://demoqa.com/BookStore/v1/Books")
		.then()
			.statusCode(200)
			.header("content-type","application/json; charset=utf-8");
		
		
	}
	
	
	
	
	
	
}
