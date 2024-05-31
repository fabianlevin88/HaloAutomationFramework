package Config.Browsers;

import Config.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge extends Browser {

    public Edge(boolean headless) {
        super(headless);
    }

    /**
     * This method creates an instance of a Microsoft Edge driver using the webdriver manager library and returns it
     * @return a edgedriver instance
     */
    @Override
    public WebDriver getBrowser() {
        WebDriverManager.edgedriver().setup();
        setDriver(new EdgeDriver());
        getDriver().manage().window().maximize();

        return getDriver();
    }
}
