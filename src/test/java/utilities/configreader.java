package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configreader {

    static Properties p = new Properties();

    static {

        try {

            InputStream input =
                    configreader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException(
                    "config.properties file not found"
                );
            }

            p.load(input);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String value(String key) {

        return p.getProperty(key);
    }
}
