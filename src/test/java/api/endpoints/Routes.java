package api.endpoints;


/*  Create User endpoint :   https://petstore.swagger.io/v2/user
 *   get user endpoint:        https://petstore.swagger.io/v2 /user/{username}
 *   update user endpoint:  https://petstore.swagger.io/v2/user/{username}
   Delete user endpoint: https://petstore.swagger.io/v2//user/{username}   */


public class Routes {
	 
	 
	 public static String base_url= "https://petstore.swagger.io/v2";
	 
	 public static String   petuser_posturl = base_url +"/user";
	 public static String   petuser_geturl = base_url +"/user/{username}";
	 public static String petuser_updateurl = base_url +"/user/{username}";
	 public static String petuser_deleteurl = base_url +"/user/{username}";
	 
	 

}
