package Utilities;

//import pureconfig.ConfigReader;

import java.io.*;
import java.util.Properties;


public class load_Resources {
    public static String load_Properties(String locator)
    {
        Properties prop = new Properties();
        String propertyFileName = "locators.properties";

        try    (InputStream inputStream = load_Resources.class.getClassLoader().getResourceAsStream(propertyFileName ) )
        {
            if (inputStream != null)
            {
                prop.load(inputStream);
            } else
            {
                System.out.println("Property file not found: " + propertyFileName);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error loading properties file: " + e.getMessage());
        }

        return prop.getProperty(locator);
    }
}


