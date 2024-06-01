package pages;

import Config.CustomActions;
import Config.MyDriver;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;

@SuppressWarnings("ALL")
public abstract class BasePage {
    private static ArrayList tabs;
    private static FluentWait wait;
    private static MyDriver driver;
    long timeout = 30;
    long interval = 3;
    public static CustomActions customActions;

    /**
     * This method will relate the page instance and the webdriver instance using the Page factory.
     * Creates the Fluent wait and sets the timeout to 20 seconds.
     * @param pDriver the MyDriver instance (it can be a webdriver or an appiumDriver)
     */
    public BasePage(MyDriver pDriver) {
        PageFactory.initElements(pDriver.getDriver(), this);
        wait = new FluentWait(pDriver.getDriver())
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(interval))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ElementClickInterceptedException.class);
        driver = pDriver;
        JavascriptExecutor executor = (JavascriptExecutor) driver.getDriver();
        customActions = new CustomActions(driver.getDriver());
    }

    public static MyDriver getDriver() {
        return driver;
    }

    public static FluentWait getWait() { return wait; }

    public long getInterval() {
        return interval;
    }
}
