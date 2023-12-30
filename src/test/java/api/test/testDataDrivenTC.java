package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.dataProviders;
import io.restassured.response.Response;

public class testDataDrivenTC {

	
	@Test(priority=1, dataProvider ="Data", dataProviderClass = dataProviders.class)
	public void testPostUser(String userid, String uname, String fname, String lname, String email, String pass, String ph)
	{
		
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userid));
		userPayload.setUsername(uname);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pass);
		userPayload.setPhone(ph);
		
		
		Response	response=  UserEndPoints.createUser(userPayload);
		//  response.then().log().all();
		
       Assert.assertEquals(response.getStatusCode(), 200);		
	}
	
}
