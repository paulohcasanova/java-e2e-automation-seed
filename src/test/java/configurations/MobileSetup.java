package configurations;

import constants.ConstantsEnum;
import constants.DriverEnum;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import static constants.ConstantsEnum.CHROME_DRIVER_LOCATION;
import static constants.DriverEnum.ANDROID;

public class MobileSetup {

    private DriverEnum testType;
    private AppiumDriverLocalService server;

    public MobileSetup(DriverEnum testType){
        this.testType = testType;
    }
    private DesiredCapabilities setCapabilities(){
        DesiredCapabilities serverCapabilities = new DesiredCapabilities();
        serverCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        serverCapabilities.setCapability("session-override" , true);

        if(testType.equals(ANDROID)){
            serverCapabilities.setCapability("chromedriverExecutable" , CHROME_DRIVER_LOCATION);
        }

        return serverCapabilities;
    }
    public void startServer(){
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withCapabilities(setCapabilities())
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .usingPort(ConstantsEnum.PORT_NUMBER).withIPAddress(ConstantsEnum.PARENT_URL);
        server = builder.build();
        server.start();
    }
    public void stopServer(){
        server.stop();
    }
}
