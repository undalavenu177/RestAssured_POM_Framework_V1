package Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listener.ExtentReportListener;
import Base.baseTest;
import Pages.AccounTransfer;
import Pages.LoanPayment;
import Pages.Login;
import io.restassured.response.Response;
import utilities.PayloadReader;
@Listeners (ExtentReportListener.class)
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
	        System.out.println("Executing Login API");
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

		        int statusCode = response.statusCode();

			       // Validate status code
			       if (statusCode == 200) {

			           System.out.println("Test Passed - VerifyAcTransfer successful");
			           Assert.assertEquals(statusCode, 200);

			       } 
			       else if (statusCode == 401) {

			           System.out.println("Token was expired/missing");
			           Assert.assertEquals(statusCode, 200);

			       } 
			       else if (statusCode == 500) {

			           System.out.println("Server error");
			           Assert.assertEquals(statusCode, 200);

			       } 
			       else if (statusCode == 400) {

			           System.out.println("Invalid Parameter");
			           Assert.assertEquals(statusCode, 200);

			       } 
			       else {

			           System.out.println("Unexpected status code: " + statusCode);
			           Assert.fail("Unexpected status code: " + statusCode);
			       }
		    
		        // Print response
		        System.out.println(
		                response.asPrettyString()
		        );
	   }
	   @Test(priority=3)
	   public void M2mTransfer() {
		      String payload =
		                PayloadReader.getPayload("M2mTransfer.json");

		        // Create POM object
		      Pages.M2mTransfer AC =
		                new Pages.M2mTransfer();

		        // Call login API
		        Response response =
		        		Pages.M2mTransfer.M2mTransfers(payload);

		        // Validate status code
		        int statusCode = response.statusCode();

			       // Validate status code
			       if (statusCode == 200) {

			           System.out.println("Test Passed - M2mTransfer successful");
			           Assert.assertEquals(statusCode, 200);

			       } 
			       else if (statusCode == 401) {

			           System.out.println("Token was expired/missing");
			           Assert.assertEquals(statusCode, 200);

			       } 
			       else if (statusCode == 500) {

			           System.out.println("Server error");
			           Assert.assertEquals(statusCode, 200);

			       } 
			       else if (statusCode == 400) {

			           System.out.println("Invalid Parameter");
			           Assert.assertEquals(statusCode, 200);

			       } 
			       else {

			           System.out.println("Unexpected status code: " + statusCode);
			           Assert.fail("Unexpected status code: " + statusCode);
			       }

			     
		        // Print response
		        System.out.println(
		                response.asPrettyString()
		        );
	   }
	   @Test(priority = 4)
	   public void Loanpayment() {

	       String payload =
	               PayloadReader.getPayload("LPPayment.json");

	       // Create POM object
	       LoanPayment AC = new LoanPayment();

	       // Call Loan Payment API
	       Response response =
	               LoanPayment.LpTransfer(payload);

	       // Get actual status code
	       int statusCode = response.statusCode();

	       // Validate status code
	       if (statusCode == 200) {

	           System.out.println("Test Passed - Loan Payment successful");
	           Assert.assertEquals(statusCode, 200);

	       } 
	       else if (statusCode == 401) {

	           System.out.println("Token was expired/missing");
	           Assert.assertEquals(statusCode, 200);

	       } 
	       else if (statusCode == 500) {

	           System.out.println("Server error");
	           Assert.assertEquals(statusCode, 200);

	       } 
	       else if (statusCode == 400) {

	           System.out.println("Invalid Parameter");
	           Assert.assertEquals(statusCode, 200);

	       } 
	       else {

	           System.out.println("Unexpected status code: " + statusCode);
	           Assert.fail("Unexpected status code: " + statusCode);
	       }

	       // Print response
	       System.out.println(response.asPrettyString());
	   }

}
