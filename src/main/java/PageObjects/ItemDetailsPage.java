package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.interactions.touch.TouchActions;

public class ItemDetailsPage extends PageBase{
    public ItemDetailsPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(accessibility = "test-ADD TO CART")
    MobileElement addToCartBtn;
    @AndroidFindBy(accessibility = "test-BACK TO PRODUCTS")
    MobileElement backToProductsBtn;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-Description\"])[1]/android.widget.TextView[1]")
    MobileElement itemName;

    public void clickOnBackToProducts()
    {
        click(backToProductsBtn);
    }
    public void clickOnAddToCart()
    {
        click(addToCartBtn);
    }
    public String getItemName()
    {
        return  getInnerText(itemName);
    }
}
