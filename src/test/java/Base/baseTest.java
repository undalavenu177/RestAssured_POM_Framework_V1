package Base;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import utilities.configreader;

public class baseTest {
    @BeforeClass
	public void setup() {
		  RestAssured.baseURI =
	                configreader.value("base.URI");
	}

}
