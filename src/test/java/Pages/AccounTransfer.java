package Pages;
import io.restassured.response.Response;
import utilities.configreader;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listener.MyListener;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
@Listeners(MyListener.class)
public class AccounTransfer {

	public static Response AcTransfer(String payload) {
		 Response response =
	                given()
	                    .contentType("application/json")
	                    .body(payload)
	                    .header("Authorization", "Bearer " + Login.token)

	                .when()
	                    .post(
	                        configreader
	                        .value("account.transfer.endpoint")
	                    );
		return response;
	}
}
