package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends  PageBase{
    public ProductsPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    String index;

//    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]")
//    MobileElement firstProductItem;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])[2]")
    MobileElement secondProductItem;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])[3]")
    MobileElement thirdProductItem;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    MobileElement pageTitle;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.CHAIN)
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])")
    List<MobileElement> ProductsList;


    //public void clickOnFirstProduct() {click(ProductsList.get(0));}

//    public void clickOnSecondProduct()
//    {
//        click(secondProductItem);
//    }
    public void clickOnRequestedProduct(int item) {click(ProductsList.get(item));}
    public String getScreenTitle(){ return getInnerText(pageTitle);}
    public int getProductsListCount(){return ProductsList.size();}

}
