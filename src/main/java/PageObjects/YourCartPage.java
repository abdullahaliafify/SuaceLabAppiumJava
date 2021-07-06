package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;

import java.util.List;

public class YourCartPage extends PageBase{
    public YourCartPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(accessibility = "test-REMOVE")
    MobileElement removeBtn;
    @AndroidFindBy(accessibility = "test-CONTINUE SHOPPING")
    MobileElement continueShoppingBtn;
//    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(\"+\"new UiSelector().text(\\\"1\\\"))")
//    List<MobileElement> quantityItems;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.CHAIN)
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-Amount\"])")
    List<MobileElement> quantityItems;
    @AndroidFindBy(accessibility = "test-CHECKOUT")
    MobileElement checkoutBtn;


    public void clickOnRemoveFromTheCart()
    {
        click(removeBtn);
    }
    public void clickOnContinueShopping()
    {
        click(continueShoppingBtn);
    }
    public void clickOnCheckout()
    {
        click(checkoutBtn);
    }
    public int getItemsCount()
    {
        return quantityItems.size();
    }

}
