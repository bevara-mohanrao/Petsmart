package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import api.payload.User;
import  io.restassured.response.Response;
import io.restassured.http.ContentType;


//Created this userEndPoints.java file for Create read  update and delete operations methods to create

public class UserEndPoints {
	
	
	      public static  Response createUser(User payload)
	      {	  
	    Response response=given()  
	    	  .contentType(ContentType.JSON)
	    	  .accept(ContentType.JSON)
	    	  .body(payload)
	    	  
	    	  .when()
	    	  .post(Routes.petuser_posturl);
	    
	         return response;
	      }
	      
	      public static Response getUser(String userName)
	      {
	    	  
	    	Response response=given()
	    	       
	    	        .pathParam("username", userName)
	    	        
	    	       .when()
	    	          .get(Routes.petuser_geturl);
	    	       
	    	        return response;    
	      }
	       
	      public static  Response updateUser(String userName, User payload)
	      {	  
	    Response response=given()  
	    	  .contentType(ContentType.JSON)
	    	  .accept(ContentType.JSON)
	    	  .pathParam("username", userName)
	    	  .body(payload)
	    	 
	    	  
	    	  .when()
	    	  .put(Routes.petuser_updateurl);
	    
	         return response;
	      }

	      public static Response deleteUser(String userName)
	      {
	    	  
	    	Response response=given()
	    	       
	    	        .pathParam("username", userName)
	    	        
	    	       .when()
	    	          .get(Routes.petuser_deleteurl);
	    	       
	    	        return response;    
	      }
	       
	      
	
}
