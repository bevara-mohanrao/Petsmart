package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;


//Created this userEndPoints.java file for Create read  update and delete operations methods to create

public class UserEndPoints2 {
	
	
     static ResourceBundle getURL()
    {
    	
    	    ResourceBundle routes =  ResourceBundle.getBundle("ORroutes");
			return routes;
    }
	
	
	      public static  Response createUser(User payload)
	      {	  
	    	       
	    	String  petuser_posturl =  getURL().getString("petuser_posturl");
 	    Response response=given()  
	    	  .contentType(ContentType.JSON)
	    	  .accept(ContentType.JSON)
	    	  .body(payload)
	    	  
	    	  .when()
	    	  .post(petuser_posturl);
	    
	         return response;
	      }
	      
	      public static Response getUser(String userName)
	      {
	    	String  petuser_geturl =  getURL().getString("petuser_geturl");
	    	Response response=given()
	    	       
	    	        .pathParam("username", userName)
	    	        
	    	       .when()
	    	          .get(petuser_geturl);
	    	       
	    	        return response;    
	      }
	       
	      public static  Response updateUser(String userName, User payload)
	      {	  
	    	  
	    	String  petuser_updateurl =  getURL().getString("petuser_updateurl");
	    	   
	    Response response=given()  
	    	  .contentType(ContentType.JSON)
	    	  .accept(ContentType.JSON)
	    	  .pathParam("username", userName)
	    	  .body(payload)
	    	  .when()
	    	  .put(petuser_updateurl);
	    
	         return response;
	      }

	      public static Response deleteUser(String userName)
	      {
		    String  petuser_deleteurl =  getURL().getString("petuser_deleteurl");
	    	Response response=given()
	    	       
	    	        .pathParam("username", userName)
	    	        
	    	       .when()
	    	          .get(petuser_deleteurl);
	    	       
	    	        return response;    
	      }
	       
	      
	
}
