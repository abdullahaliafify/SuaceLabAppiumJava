package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    AppiumDriver driver;
    public static final long Wait = 10;

    public PageBase(AppiumDriver appiumDriver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver),this);
        driver = appiumDriver;
    }

    public void waitForVisibility(MobileElement element)
    {
        WebDriverWait wait =  new WebDriverWait(driver,Wait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clear(MobileElement element)
    {
        waitForVisibility(element);
        element.clear();
    }

    public void sendText(MobileElement element, String text)
    {
        waitForVisibility(element);
        element.sendKeys(text);
    }
    public void click(MobileElement element)
    {
        waitForVisibility(element);
        element.click();
    }

    public String getInnerText(MobileElement element)
    {
        waitForVisibility(element);
        return  element.getText();
    }
}
