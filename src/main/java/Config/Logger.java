package Config;

import org.joda.time.DateTime;
import org.testng.Reporter;

public class Logger {
    private static final String INFO_STYLE = "\u001B[34m";
    private static final String DEBUG_STYLE = "\u001B[36m";
    private static final String WARN_STYLE = "\u001B[33m";
    private static final String ERROR_STYLE = "\u001B[31m";
    private static final String TITLE_STYE = "\u001B[37m";

    /**
     * The variables defined to format the logs
     */
    private static final String DATEPATTERN = "MM-dd-yyyy HH:mm:ss";
    private static final String LOGTEMPLATE = "[%s %s] %s";

    private static void print(String style, String level, String message) {
        String logMessage = String.format(style + LOGTEMPLATE, level, DateTime.now().toString(DATEPATTERN), message);
        Reporter.log(logMessage, true);
    }

    /**
     * Printing message in INFO level
     * @param message
     */
    public static void printInfo(String message) { print(INFO_STYLE, "INFO", message); }

    /**
     * Printing message in DEBUG level
     * @param message
     */
    public static void printDebug(String message) {
        print(DEBUG_STYLE, "DEBUG", message);
    }

    /**
     * Printing message in WARNING level
     * @param message
     */
    public static void printWarning(String message) {
        print(WARN_STYLE, "WARN", message);
    }

    /**
     * Printing message in ERROR level
     * @param message
     */
    public static void printError(String message) {
        print(ERROR_STYLE, "ERROR", message);
    }

    /**
     * Printing Test start message
     * @param message
     */
    public static void printTitle(String message) { print(TITLE_STYE, "TEST", message); }
}
