package com.github.danilo1337.util;

import java.util.logging.Logger;

public class LoggerUtils {
	
    private static final Logger logger = Logger.getLogger(Object.class.getName());

    public static void info(String message) {
        logger.info(message);
    }

    public static void warn(String message) {
        logger.warning(message);
    }
//
//    public static void error(String message) {
//        logger.warning(message);
//    }
//
//    public static void error(String message, Throwable throwable) {
//        logger.warning(message, throwable);
//    }
}
