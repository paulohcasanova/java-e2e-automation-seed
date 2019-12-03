package configurations;

import constants.ConstantsEnum;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class AndroidSetup {

    public static AndroidDriver prepareAndroidForAppium() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConstantsEnum.ANDROID_EMULATOR_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM, ConstantsEnum.ANDROID_PLATFORM_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConstantsEnum.ANDROID_PLATFORM_VERSION);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("avd", ConstantsEnum.ANDROID_DEVICE_NAME);
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("session-override" , true);

        AndroidDriver d = new AndroidDriver<>(new URL(ConstantsEnum.INITIAL_URL), capabilities);

        return d;
    }
}
