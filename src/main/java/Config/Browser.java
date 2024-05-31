package Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.logging.Level;

public abstract class Browser {
    private WebDriver driver;

    public abstract WebDriver getBrowser();

    /**
     * This method sets the logging preferences for the webdriver
     * @return
     */
    public LoggingPreferences getLoggingPreferences() {
        LoggingPreferences preferences = new LoggingPreferences();

        preferences.enable(LogType.BROWSER, Level.OFF);
        preferences.enable(LogType.CLIENT, Level.OFF);
        preferences.enable(LogType.DRIVER, Level.OFF);
        preferences.enable(LogType.PROFILER, Level.OFF);
        preferences.enable(LogType.SERVER, Level.OFF);

        return preferences;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
