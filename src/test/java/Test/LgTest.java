package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.baseTest;
import Pages.AccounTransfer;
import Pages.Login;
import io.restassured.response.Response;
import utilities.PayloadReader;

public class LgTest extends baseTest{
	   @Test(priority=1)
	    public void verifyLogin() {

	        // Read payload from test data
	        String payload =
	                PayloadReader.getPayload("login.json");

	        // Create POM object
	        Login loginPage =
	                new Login();

	        // Call login API
	        Response response =
	                loginPage.login(payload);

	        // Validate status code
	        Assert.assertEquals(
	                response.statusCode(),
	                200
	        );

	        // Print response
	        System.out.println(
	                response.asPrettyString()
	        );
	    }
	   @Test(priority=2)
	   public void VerifyAcTransfer() {
		      String payload =
		                PayloadReader.getPayload("AccTransfer.json");

		        // Create POM object
		      AccounTransfer AC =
		                new AccounTransfer();

		        // Call login API
		        Response response =
		        		AccounTransfer.AcTransfer(payload);

		        // Validate status code
		        Assert.assertEquals(
		                response.statusCode(),
		                200
		        );

		        // Print response
		        System.out.println(
		                response.asPrettyString()
		        );
	   }

}
