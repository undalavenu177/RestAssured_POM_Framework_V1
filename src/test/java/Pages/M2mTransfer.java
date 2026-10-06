package Pages;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import utilities.configreader;

public class M2mTransfer {

	public static Response M2mTransfers(String payload) {
		 Response response =
	                given()
	                    .contentType("application/json")
	                    .body(payload)
	                    .header("Authorization", "Bearer " + Login.token)

	                .when()
	                    .post(
	                        configreader
	                        .value("m2mtransfer.endpoint")
	                    );
		return response;
	}

}
