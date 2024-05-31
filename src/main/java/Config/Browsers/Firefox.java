package Config.Browsers;

import Config.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Firefox extends Browser {
    private DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

    /**
     * This method creates an instance of a Mozilla Firefox driver using the webdriver manager library and returns it
     * @return a firefoxdriver instance
     */
    @Override
    public WebDriver getBrowser() {
        desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, getLoggingPreferences());
        System.setProperty("webdriver.firefox.logfile", "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        setDriver(new FirefoxDriver());
        getDriver().manage().window().maximize();

        return getDriver();
    }
}