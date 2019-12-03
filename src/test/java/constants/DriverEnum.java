package constants;

import configurations.AndroidSetup;
import configurations.IOSSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum DriverEnum {
    CHROME{
        @Override
        public WebDriver create() throws Exception{
            System.setProperty(ConstantsEnum.CHROME_DRIVER_NAME, ConstantsEnum.CHROME_DRIVER_LOCATION);
            return new ChromeDriver();
        }
    },
    FIREFOX{
        @Override
        public WebDriver create() throws Exception{
            //Capabilities if any
            return new FirefoxDriver();
        }
    },
    ANDROID{
        @Override
        public WebDriver create() throws Exception{
            return AndroidSetup.prepareAndroidForAppium();
        }
    },
    IOS{
        @Override
        public WebDriver create() throws Exception{
            return IOSSetup.prepareIOSForAppium();
        }
    };

    public abstract WebDriver create() throws Exception;
}


