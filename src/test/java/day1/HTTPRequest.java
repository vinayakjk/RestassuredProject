package day1;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.*;

/*
 	Given()
 		prerequisites like headers,parameters,keys,etc
 	.When()
 		execute GET,POST,PUT,DELETE http requests.

 	.Then()
 		validate the response codes,response body,etc

 */
public class HTTPRequest {

	//Test case to GET the data of user

	@Test (priority = 2,enabled = true)
	public void getUsersData()
	{
		given()
		.when().get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200).body("page",equalTo(2))
		.log().all();
	}

	//Test case to create user
	
	@Test (priority = 1, enabled = false)
	public void creatUsers()
	{
		HashMap data=new HashMap();
		data.put("name", "Vinayak");
		data.put("job", "QA-Lead");
		
		given()
		.when()
		.contentType("application/JSON")
		.body(data)
		
		.then()
		.statusCode(201)
		.log().all();
		
	}



}
