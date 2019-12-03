package configurations;

import constants.DriverEnum;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    public DriverEnum testType;
    private MobileSetup mobileSetup;

    public TestBase(DriverEnum type){
        this.testType = type;
        this.mobileSetup = new MobileSetup(testType);
    }
    @BeforeMethod
    public void setup() throws Exception {
        if(testType == DriverEnum.ANDROID || testType == DriverEnum.IOS){
            mobileSetup.startServer();
        }

//        driver = DriverFactory.createWebDriver(testType);
        driver = testType.create();

        if(testType != DriverEnum.ANDROID && testType != DriverEnum.IOS){
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
        driver = null;
        if(testType == DriverEnum.ANDROID || testType == DriverEnum.IOS){
            mobileSetup.stopServer();
        }
    }
}


