package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log
{
    private static Logger logger = LogManager.getLogger(Log.class.getName());

    public static void info(String message) {
        logger.info(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void fatal(String message) {
        logger.fatal(message);
    }

    public static void trace(String message) {
        logger.trace(message);
    }

    // Method to start a test case log
    public static void startTestCase(String sTestCaseName){
        logger.info("****************************************************************************************");
        logger.info("****************************************************************************************");
        logger.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$");
        logger.info("****************************************************************************************");
        logger.info("****************************************************************************************");
    }

    // Method to end a test case log
    public static void endTestCase(String sTestCaseName){
        logger.info("$$$$$$$$$$$$$$$$$$$$$                 "+"-E---N---D-                 $$$$$$$$$$$$$$$$$$$$$");
        logger.info("X");
        logger.info("X");
        logger.info("X");
        logger.info("X");
    }
}
