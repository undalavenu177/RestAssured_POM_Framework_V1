package Pages;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import utilities.configreader;

public class Unrestrictedtrasnfer {
	public static Response croAcTransfer(String payload) {
		 Response response =
	                given()
	                    .contentType("application/json")
	                    .body(payload)
	                    .header("Authorization", "Bearer " + Login.token)

	                .when()
	                    .post(
	                        configreader
	                        .value("unrestricted.transfer.endpoint")
	                    );
		return response;
	}

}
