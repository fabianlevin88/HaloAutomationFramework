package Config.Browsers;

import Config.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Safari extends Browser {

    /**
     * This method creates an instance of a Safari driver
     * @return a safaridriver instance
     */
    @Override
    public WebDriver getBrowser() {
        setDriver(new SafariDriver());
        getDriver().manage().window().maximize();

        return getDriver();
    }
}
