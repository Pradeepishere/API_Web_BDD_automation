package Utilities;

//import pureconfig.ConfigReader;

import java.io.*;
import java.util.Properties;


public class load_Resources {
    public static String load_Locator_Properties(String locator) {
        Properties prop = new Properties();
        String propertyFileName = "resources/Properties_files/locators.properties";

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

    public static String get_Excel_Property_name(String text) {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/java/resources/Properties_files/excel.properties"))
        {
            if (fis != null) {
                prop.load(fis);
            }
            else {
                System.out.println("Excel_Properties file not found: ");
            }
        }catch (IOException e)
        {
            System.out.println("Error loading properties file: " + e.getMessage());
        }
        return prop.getProperty(text);
    }
}


