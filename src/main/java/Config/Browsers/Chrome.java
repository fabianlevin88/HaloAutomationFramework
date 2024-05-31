package Config.Browsers;

import Config.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome extends Browser {



    public Chrome(boolean headless) {
        super(headless);
    }

    /**
     * This method creates an instance of a Google Chrome driver using the webdriver manager library and returns it
     * @return a chromedriver instance
     */
    @Override
    public WebDriver getBrowser() {
        ChromeOptions chrome_options = new ChromeOptions();
        chrome_options.addArguments("--no-sandbox");
        chrome_options.addArguments("--incognito");
        chrome_options.addArguments("--disable-logging");
        chrome_options.addArguments("--output=/dev/null");
        chrome_options.addArguments("--window-size=1920,1080");
        if (isHeadless()) {
            chrome_options.setHeadless(true);
        }
        WebDriverManager.chromedriver().browserVersion("125.0.6422.113").setup();
        setDriver(new ChromeDriver(chrome_options));
        getDriver().manage().window().maximize();

        return getDriver();
    }
}
