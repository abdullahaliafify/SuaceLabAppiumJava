package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;

import java.util.List;

public class CheckoutOverviewPage extends PageBase{
    public CheckoutOverviewPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(accessibility = "test-CANCEL")
    MobileElement cancelBtn;
    @AndroidFindBy(accessibility = "test-FINISH")
    MobileElement finishBtn;
//    @AndroidFindBy(accessibility = "")
//    MobileElement itemName;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.CHAIN)
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Amount']")
    List<MobileElement> quantityItems;

    public void clickOnCancel()
    {
        click(cancelBtn);
    }
    public  void clickOnFinish()
    {
        click(finishBtn);
    }
    public int getItemsCount()
    {
        return  quantityItems.size();
    }
//   // public String getItemName()
//    {
//        return  getInnerText(itemName);
//    }
}
