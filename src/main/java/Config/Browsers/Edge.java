package Config.Browsers;

import Config.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.List;
import java.util.Map;

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
        EdgeOptions edgeOptions = new EdgeOptions();
        if (isHeadless()) {
            edgeOptions.setCapability("ms:edgeOptions", Map.of("args", List.of("--headless", "--inprivate")));
        }
        WebDriverManager.edgedriver().setup();
        setDriver(new EdgeDriver(edgeOptions));
        getDriver().manage().window().maximize();

        return getDriver();
    }
}
