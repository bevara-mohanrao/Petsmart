package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class userTest {

	Faker faker;
	User userPayload;

	@BeforeClass
	public void setupData()
	{
		   
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setUsername(faker.name().username());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.internet().password());
		
	}
	
	@Test(priority=1)
	public void  testPostUser() {
		
		
	Response	response=  UserEndPoints.createUser(userPayload);
		  response.then().log().all();
		
         Assert.assertEquals(response.getStatusCode(), 200);		
	}
		
	@Test(priority=2)
	public void testgetUserByName() {
		
		
		 Response response = UserEndPoints.getUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		response.then().log().all();	
	}
	
	@Test(priority=3)
	public void testUpdateUserByName() {

		//update the data using payload.
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		
		
         Response response= UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
             response.then().log().all();
             
             Assert.assertEquals(response.getStatusCode(), 200);
             
             //Response to retrieve after update the username details
             
             Response responseafterupdate = UserEndPoints.getUser(this.userPayload.getUsername());
     		Assert.assertEquals(response.getStatusCode(),200);
     		responseafterupdate.then().log().all();		
	}
	
	@Test(priority=4)
	public void testDeleteUserByName() {
		
		
		Response response =UserEndPoints.deleteUser(this.userPayload.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
}
