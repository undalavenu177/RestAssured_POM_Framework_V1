package Pages;

import io.restassured.response.Response;
import utilities.configreader;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Login {
	public static String token;
    public Response login(String payload) {

        Response response =
                given()
                    .contentType("application/json")
                    .body(payload)
                    

                .when()
                    .post(
                        configreader
                        .value("login.endpoint")
                    );
        
        response.then()
        .statusCode(200);

        token = response.jsonPath().getString("access_token");

        return response;
    }

}
