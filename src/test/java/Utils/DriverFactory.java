package Utils;

import configurations.AndroidSetup;
import configurations.IOSSetup;
import constants.ConstantsEnum;
import constants.DriverEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver createWebDriver(DriverEnum dType) throws Exception {
        switch (dType){
            case ANDROID:
                return AndroidSetup.prepareAndroidForAppium();
            case IOS:
                return IOSSetup.prepareIOSForAppium();
            case CHROME:
                //Capabilities if any
                System.setProperty(ConstantsEnum.CHROME_DRIVER_NAME, ConstantsEnum.CHROME_DRIVER_LOCATION);
                return new ChromeDriver();
            case FIREFOX:
                //Capabilities if any
                return new FirefoxDriver();
            default:
                throw new Exception("No such Driver found.");
        }
    }
}

