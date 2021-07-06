package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HeaderBarPage extends PageBase{
    public HeaderBarPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(accessibility = "test-Cart")
    MobileElement shoppingCartIcon;
    @AndroidFindBy(accessibility = "test-Menu")
    MobileElement menuIcon;

    public void clickOnCartIcon()
    {
        click(shoppingCartIcon);
    }
    public void clickOnMenuIcon()
    {
        click(menuIcon);
    }
}
