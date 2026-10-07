package Pages;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import utilities.configreader;

public class crossloanpay {
	public static Response crossloanpayment(String payload) {
		 Response response =
	                given()
	                    .contentType("application/json")
	                    .body(payload)
	                    .header("Authorization", "Bearer " + Login.token)

	                .when()
	                    .post(
	                        configreader
	                        .value("Crossloanpay.endpoint")
	                    );
		return response;
	}

}
