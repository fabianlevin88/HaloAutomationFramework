package Config;

import Config.Browsers.Chrome;
import Config.Browsers.Edge;
import Config.Browsers.Firefox;
import Config.Browsers.Safari;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.remote.BrowserType.*;

public class DriverCreator extends MyDriver {
    private WebDriver driver;

    public DriverCreator(String browser) {
        setBrowser(browser);
        createWebDriverInstance(browser);
    }

    private WebDriver createWebDriverInstance(String browser) {

        switch (browser) {
            case CHROME:
                driver = new Chrome().getBrowser();
                break;
            case FIREFOX:
                driver = new Firefox().getBrowser();
                break;
            case SAFARI:
                driver = new Safari().getBrowser();
                break;
            case EDGE:
                driver = new Edge().getBrowser();
                break;
            default:
                Logger.printError("The browser name is not defined");
                driver = null;
                break;
        }
        return driver;
    }

    /**
     * This method closes the instance created of the webDriver
     */
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            Logger.printDebug("Web driver instance closed");
        }
    }

    /**
     * This method returns the instance created of the webDriver
     * @return
     */
    @Override
    public WebDriver getDriver() { return driver; }
}
