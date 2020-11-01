package test_VideoGameDB;


import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class VideoGameAPITesting {

	@Test(priority = 1)
	public void getAllVideoGameDetails()
	{
		given()
		.when()
			.get("http://localhost:8080/app/videogames")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	
	@Test(priority = 2)
	public void postNewVideoGameDetails()
	{
		HashMap<String,String> data=new HashMap<String, String>();
		data.put("id", "11");
		data.put("name", "Game1");
		data.put("releaseDate", "2020-11-01T07:46:37.399Z");
		data.put("reviewScore", "4");
		data.put("category", "Education");
		data.put("rating", "Universal");
		
		
		Response res=
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:8080/app/videogames")
		.then()
			.statusCode(200)
			.log().all()
			.extract().response();
		
		String response_body=res.asString();
		
		Assert.assertTrue(response_body.contains("Record Added Successfully"), "Record Added Successfully");
		Assert.assertEquals(response_body.contains("Record Added Successfully"), true);
	}
	
	
	
}
