package configurations;

import constants.ConstantsEnum;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSSetup {

    public static IOSDriver prepareIOSForAppium() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConstantsEnum.IPHONE_EMULATOR_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM, ConstantsEnum.IOS_PLATFORM_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConstantsEnum.IOS_PLATFORM_VERSION);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability("useNewWDA", false);

        IOSDriver d = new IOSDriver<>(new URL(ConstantsEnum.INITIAL_URL), capabilities);

        return d;
    }
}
