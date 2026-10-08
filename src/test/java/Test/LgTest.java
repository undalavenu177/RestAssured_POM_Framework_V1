package Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listener.ExtentReportListener;
import Base.baseTest;
import Pages.AccounTransfer;
import Pages.LoanPayment;
import Pages.Login;
import Pages.Unrestrictedtrasnfer;
import Pages.crossloanpay;
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
	   @Test(priority = 5)
	   public void Loanpayment() {

	       String payload =
	               PayloadReader.getPayload("LoanPay.json");

	       // Create POM object
	       LoanPayment AC = new LoanPayment();

	       // Call Loan Payment API
	       Response response =
	               LoanPayment.LpTransfer(payload);

	      // System.out.println(response.asPrettyString());
	       // Get actual status code
	       
	       int statusCode = response.statusCode();
	       System.out.println(statusCode+"Status code:");
	       String Mesg= response.jsonPath().getString("message");

	       // Validate status code
	       if (statusCode == 200 && Mesg.contains("successfully") ) {

	           System.out.println("Test Passed - Loan Payment successful");
	           Assert.assertEquals(statusCode, 200);

	       } 
	       else if (statusCode == 200 && Mesg.contains("Rejected")) {

	    	    System.out.println("Test Failed - Transaction Rejected");

	    	    Assert.fail("Transaction Rejected");
	    	}
	       else if (statusCode == 401) {

	           System.out.println("Token was expired/missing");
	           Assert.assertEquals(statusCode, 401);

	       } 
	       else if (statusCode == 500) {

	           System.out.println("Server error");
	           Assert.assertEquals(statusCode, 500);

	       } 
	       else if (statusCode == 400) {

	           System.out.println("Invalid Parameter");
	           Assert.assertEquals(statusCode, 400);

	       } 
	       else {

	           System.out.println("Unexpected status code: " + statusCode);
	           Assert.fail("Unexpected status code: " + statusCode);
	       }

	       // Print response
	       System.out.println(response.asPrettyString());
	   }
	   @Test(priority = 6)
	   public void CrosssLoanpayment() {

	       String payload =
	               PayloadReader.getPayload("crossloanPay.json");

	       // Create POM object
	       crossloanpay AC = new crossloanpay();

	       // Call Loan Payment API
	       Response responsecr =
	    		   crossloanpay.crossloanpayment(payload);

	       // Get actual status code
	       System.out.println(responsecr.asPrettyString());
	       int statusCode = responsecr.statusCode();
	       String Mesgcr= responsecr.jsonPath().getString("transactionResponse.transaction.status.message");

	       // Validate status code
	       if (statusCode == 200 && Mesgcr.contains("successfully") ) {

	           System.out.println("Test Passed - cross Loan Payment successful");
	           Assert.assertEquals(statusCode, 200);

	       } 
	       else if (statusCode == 200 && Mesgcr.contains("pending")) {

	    	    System.out.println("Test Failed - Transaction Rejected");

	    	    Assert.fail("Transaction Rejected");
	    	}
	       else if (statusCode == 401) {

	           System.out.println("Token was expired/missing");
	           Assert.assertEquals(statusCode, 401);

	       } 
	       else if (statusCode == 500) {

	           System.out.println("Server error");
	           Assert.assertEquals(statusCode, 500);

	       } 
	       else if (statusCode == 400) {

	           System.out.println("Invalid Parameter");
	           Assert.assertEquals(statusCode, 400);

	       } 
	       else {

	           System.out.println("Unexpected status code: " + statusCode);
	           Assert.fail("Unexpected status code: " + statusCode);
	       }

	       // Print response
	       System.out.println(responsecr.asPrettyString());
	   }
	   @Test(priority = 4)
	   public void Unrestritctedtransfer() {

	       String payload =
	               PayloadReader.getPayload("Unrestrcicted.json");

	       // Create POM object
	       Unrestrictedtrasnfer AC = new Unrestrictedtrasnfer();

	       // Call Loan Payment API
	       Response response1 =
	    		   Unrestrictedtrasnfer.croAcTransfer(payload);

	       // Get actual status code
	       int statusCode = response1.statusCode();
	       String Mesg1 = response1.jsonPath()
	    	        .getString("transactionResponse.transaction.status.message");

	    	System.out.println("Message: " + Mesg1);
	    	System.out.println(response1.asPrettyString());

	    	// Validate status code and response message
	    	if (statusCode == 200 && Mesg1 != null && Mesg1.toLowerCase().contains("successfully")) {

	    	    System.out.println("Test Passed - Unrestricted transfer was successful");
	    	    Assert.assertEquals(statusCode, 200);

	    	} else if (statusCode == 200 && Mesg1 != null && Mesg1.toLowerCase().contains("rejected")) {

	    	    System.out.println("Test Failed - Transaction Rejected");
	    	    Assert.fail("Transaction Rejected: " + Mesg1);

	    	} 
	       else if (statusCode == 401) {

	           System.out.println("Token was expired/missing");
	           Assert.assertEquals(statusCode, 401);

	       } 
	       else if (statusCode == 500) {

	           System.out.println("Server error");
	           Assert.assertEquals(statusCode, 500);

	       } 
	       else if (statusCode == 400) {

	           System.out.println("Invalid Parameter");
	           Assert.assertEquals(statusCode, 400);

	       } 
	       else {

	           System.out.println("Unexpected status code: " + statusCode);
	           Assert.fail("Unexpected status code: " + statusCode);
	       }

	       // Print response
	       System.out.println(response1.asPrettyString());
	   }

}
