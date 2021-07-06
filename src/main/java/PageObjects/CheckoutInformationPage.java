package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CheckoutInformationPage extends PageBase{
    public CheckoutInformationPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: INFORMATION']")
    MobileElement pageTitle;
    @AndroidFindBy(accessibility = "test-First Name")
    MobileElement inputFirstName;
    @AndroidFindBy(accessibility = "test-Last Name")
    MobileElement inputLastName;
    @AndroidFindBy(accessibility = "test-Zip/Postal Code")
    MobileElement inputPostalCode;
    @AndroidFindBy(accessibility = "test-CANCEL")
    MobileElement cancelBtn;
    @AndroidFindBy(accessibility = "test-CONTINUE")
    MobileElement continueBtn;


    public String getPageTitle()
    {
        return getInnerText(pageTitle);
    }

    public void enterFirstName(String text)
    {
        clear(inputFirstName);
        sendText(inputFirstName,text);
    }
    public void enterLastName(String text)
    {
        clear(inputLastName);
        sendText(inputLastName,text);
    }
    public void enterPostalCode(String code)
    {
        clear(inputPostalCode);
        sendText(inputPostalCode,code);
    }
    public void clickOnCancel()
    {
        clear(cancelBtn);
    }
    public void clickOnContinue()
    {
        click(continueBtn);
    }


}
