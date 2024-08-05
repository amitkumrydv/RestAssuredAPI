package com.api.test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

/*
given()
-----> content type, set cookies, add auth, add param, set header info etc....



when()
-----> get, post, put, delete



then()
------> validate status code, extract response, extract header cookies & response body.....


*/
public class RestassuredApiTesting {
	
	
	int id;
	
	@Test (priority = 1)
	void getUsers() {
		
		given()
		
		.when()
		  .get("https://reqres.in/api/user?page=2")
		  
		
		.then()
		   .statusCode(200)
		   .body("page", equalTo(2))
		   .log().all();
		
		
		
	}
	
	
	@Test (priority = 2)
	void createUer() {
		
		
		HashMap data = new HashMap();
		
		data.put("name", "morpheus");
		data.put("job","leader");
		
		
		
		given()
		
		 .contentType("application/json")
		 .body(data)
		
		 .when()
		 
		  .get("https://reqres.in/api/users")
		  
		 
		 
		 .then()
		
		  .statusCode(200)
		  //.body("page", equalTo(2))
		  .log().all();
		
	}
	
	
	
	@Test (priority = 3)
	void createUerforUpdate() {
		
		
		HashMap data = new HashMap();
		
		data.put("name", "morpheus");
		data.put("job","leader");
		
		
		
		id=given()
		
		 .contentType("application/json")
		 .body(data)
		
		 .when()
		 
		  .get("https://reqres.in/api/users")
		  .jsonPath().getInt("id");
		 
		 
//		 .then()
//		
//		  .statusCode(200)
//		  //.body("page", equalTo(2))
//		  .log().all();
//		
	}
	
	
	
	
	
	
	@Test (priority = 4, dependsOnMethods = {"createUerforUpdate"})
	void updateUer() {
		
		
		HashMap data = new HashMap();
		
		data.put("name", "morpheus");
		data.put("job","leader");
		
		
		
	   given()
		
		 .contentType("application/json")
		 .body(data)
		
		 .when()
		 
		  .put("https://reqres.in/api/users"+id)
		
		  
		 .then()
		  .statusCode(200)
		  .log().all();
		 
		  
	
	
	}
	
	
	
	@Test
	void deleteUser() {
		
		
		given()
		
		
		 .when()
		  .delete("https://reqres.in/api/users"+id)
		 
		 
		 
		 .then()
		   .statusCode(204)
		   .log().all();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
