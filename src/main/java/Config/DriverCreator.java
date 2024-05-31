package Config;

import Config.Browsers.Chrome;
import Config.Browsers.Edge;
import Config.Browsers.Firefox;
import Config.Browsers.Safari;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.remote.BrowserType.*;

public class DriverCreator extends MyDriver {
    private WebDriver driver;

    public DriverCreator(String browser, boolean headless) {
        setBrowser(browser);
        createWebDriverInstance(browser, headless);
    }

    private WebDriver createWebDriverInstance(String browser, boolean headless) {

        switch (browser) {
            case CHROME -> driver = new Chrome(headless).getBrowser();
            case FIREFOX -> driver = new Firefox(false).getBrowser();
            case SAFARI -> driver = new Safari(false).getBrowser();
            case EDGE -> driver = new Edge(false).getBrowser();
            default -> Logger.printError("The browser name is not defined");
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
