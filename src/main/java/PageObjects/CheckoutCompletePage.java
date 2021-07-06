package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CheckoutCompletePage extends PageBase {
    public CheckoutCompletePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='THANK YOU FOR YOU ORDER']")
    MobileElement completeMessage;
    @AndroidFindBy(accessibility = "test - BACK HOME")
    MobileElement backToHomeBtn;

    public void clickBackToHome()
    {
        click(backToHomeBtn);
    }

    public String getCompleteCheckoutMessage()
    {
        return getInnerText(completeMessage);
    }
}
