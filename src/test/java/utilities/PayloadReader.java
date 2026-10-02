package utilities;

import java.nio.file.Files;
import java.nio.file.Paths;

public class PayloadReader {
	   public static String getPayload(String fileName) {

	        try {

	            String path =
	                    "src/test/resources/Testdat/"
	                    + fileName;

	            return Files.readString(Paths.get(path));

	        } catch (Exception e) {

	            e.printStackTrace();

	            return null;
	        }
	    }
}
