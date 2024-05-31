package Config;

import org.openqa.selenium.WebDriver;

public abstract class MyDriver {

    private static String browser;
    private static MyDriver myDriver;

    /**
     * This method is used to close the driver sessions
     */
    public abstract void closeDriver();

    public abstract WebDriver getDriver();

    public static String getBrowser() {
        return browser;
    }

    public static void setBrowser(String browser) {
        MyDriver.browser = browser;
    }

    public static MyDriver getMyDriver() {
        return myDriver;
    }

    public static void setMyDriver(MyDriver myDriver) {
        MyDriver.myDriver = myDriver;
    }
}
