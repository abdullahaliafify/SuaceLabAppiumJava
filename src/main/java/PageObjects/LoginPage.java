package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends PageBase {
    public LoginPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    MobileElement inputUsername;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    MobileElement inputPassword;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    MobileElement loginBtn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    MobileElement WarnMessage;

    // Methods definitions
    public void enterUsername(String text)
    {
        clear(inputUsername);
        sendText(inputUsername,text);
    }

    public void clearUsername()
    {
        clear(inputUsername);

    }

    public void enterPassword(String text)
    {
        clear(inputPassword);
        sendText(inputPassword,text);
    }
    public void clearPassword()
    {
        clear(inputPassword);

    }
    public void clickLogin()
    {
        click(loginBtn);
    }
    public String getWarningMessage()
    {
        return  getInnerText(WarnMessage);
    }


}
