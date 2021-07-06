import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestBase {
    AppiumDriver driver;
    public AndroidTouchAction touchAction;

    public  void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","9");
        caps.setCapability("deviceName","afcfe42c");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appActivity","com.swaglabsmobileapp.MainActivity");
        caps.setCapability("appPackage","com.swaglabsmobileapp");

        driver =  new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);

    }

    // Method for scrolling down
    public void scrollDown(AppiumDriver appiumDriver)
    {
        Dimension dimension = appiumDriver.manage().window().getSize();
        int scrollStart = (int)(dimension.getHeight() * 0.8);
        int scrollEnd = (int)(dimension.getHeight() * 0.1);

        touchAction = new AndroidTouchAction(appiumDriver)
                .press(PointOption.point(0,scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .moveTo(PointOption.point(0,scrollEnd))
                .release()
                .perform();
    }

    @AfterTest
    public  void tearDown()
    {
        if(null !=driver)
        {
            driver.quit();
        }

    }
}
