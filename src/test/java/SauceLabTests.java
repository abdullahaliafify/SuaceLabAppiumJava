import PageObjects.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilits.JsonReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SauceLabTests extends TestBase{

LoginPage loginPage;
ProductsPage productsPage;
ItemDetailsPage itemDetailsPage;
HeaderBarPage headerBarPage;
YourCartPage yourCartPage;
CheckoutInformationPage checkoutInformationPage;
CheckoutOverviewPage checkoutOverviewPage;
CheckoutCompletePage checkoutCompletePage;

 @DataProvider(name = "full data")
 public Object[][] passFullData() throws IOException, ParseException {
  String filePath = System.getProperty("user.dir")+"\\data\\TestData.json";
  return JsonReader.getJsonData(
          filePath,"Tasks Data",5);
 }

 @Test(priority = 1,dataProvider = "full data")
 public void Verify_User_Can_Not_Login_Without_UserName(String Username,String Password,String Firstname,String Lastname,String PostalCode) throws MalformedURLException {
  setup();
  loginPage = new LoginPage(driver);
  loginPage.clearUsername();
  loginPage.enterPassword(Password);
  loginPage.clickLogin();
  Assert.assertEquals(loginPage.getWarningMessage(),"Username is required");
  tearDown();
 }

 @Test(priority = 2,dataProvider = "full data")
public void Verify_User_Can_Not_Login_Without_Password(String Username,String Password,String Firstname,String Lastname,String PostalCode) throws MalformedURLException {
  setup();
 loginPage = new LoginPage(driver);
 loginPage.clearPassword();
 loginPage.enterUsername(Username);
 loginPage.clickLogin();
 Assert.assertEquals(loginPage.getWarningMessage(),"Password is required");
 tearDown();
}

@Test(priority = 3,dataProvider = "full data")
public void Verify_User_Able_To_Login_Successfully(String Username,String Password,String Firstname,String Lastname,String PostalCode) throws MalformedURLException {
 setup();
  loginPage = new LoginPage(driver);
 loginPage.clearUsername();
 loginPage.clearPassword();
 loginPage.enterUsername(Username);
 loginPage.enterPassword(Password);
 loginPage.clickLogin();
 productsPage = new ProductsPage(driver);
 Assert.assertEquals(productsPage.getScreenTitle(),"PRODUCTS");
 tearDown();
}

@Test(priority = 4,dataProvider = "full data")
public void Verify_User_Able_To_Add_Items_To_The_Cart_And_Do_Successfully_Checkout(String Username,String Password,String Firstname,String Lastname,String PostalCode) throws MalformedURLException, InterruptedException {
setup();
 // login to the app
 loginPage = new LoginPage(driver);
 loginPage.clearUsername();
 loginPage.clearPassword();
 loginPage.enterUsername(Username);
 loginPage.enterPassword(Password);
 loginPage.clickLogin();
 productsPage = new ProductsPage(driver);
 Assert.assertEquals(productsPage.getScreenTitle(),"PRODUCTS");
 // adding products to the cart
 int productsCount = productsPage.getProductsListCount();
 for (int i = 0; i < productsPage.getProductsListCount();i++)
 {
  productsPage.clickOnRequestedProduct(i);
  Thread.sleep(5000);
  scrollDown(driver);
  itemDetailsPage = new ItemDetailsPage(driver);
  itemDetailsPage.clickOnAddToCart();
  itemDetailsPage.clickOnBackToProducts();
 }

// productsPage.clickOnFirstProduct();
// itemDetailsPage = new ItemDetailsPage(driver);
// itemDetailsPage.clickOnAddToCart();
// itemDetailsPage.clickOnBackToProducts();
// productsPage.clickOnSecondProduct();

// itemDetailsPage.clickOnAddToCart();
// itemDetailsPage.clickOnBackToProducts();

 // assert on quantity for added products
 headerBarPage =  new HeaderBarPage(driver);
 headerBarPage.clickOnCartIcon();

 yourCartPage = new YourCartPage(driver);
 Assert.assertEquals(yourCartPage.getItemsCount(),productsCount);
// entering user details
 Thread.sleep(5000);
 scrollDown(driver);
 yourCartPage.clickOnCheckout();

 checkoutInformationPage = new CheckoutInformationPage(driver);
 checkoutInformationPage.enterFirstName(Firstname);
 checkoutInformationPage.enterLastName(Lastname);
 checkoutInformationPage.enterPostalCode(PostalCode);
 checkoutInformationPage.clickOnContinue();
// last assert on items quantity
 checkoutOverviewPage = new CheckoutOverviewPage(driver);
 Assert.assertEquals(checkoutOverviewPage.getItemsCount(),productsCount);
 Thread.sleep(5000);
 scrollDown(driver);
 checkoutOverviewPage.clickOnFinish();
// assert payment done
 checkoutCompletePage = new CheckoutCompletePage(driver);
 Assert.assertEquals(checkoutCompletePage.getCompleteCheckoutMessage(),"THANK YOU FOR YOU ORDER");
tearDown();
}

@Test(priority = 5,dataProvider = "full data")
public void Verify_User_Able_To_Add_And_Delete_Items_To_The_Cart(String Username,String Password,String Firstname,String Lastname,String PostalCode) throws MalformedURLException, InterruptedException {
setup();
 // login to the app
 loginPage = new LoginPage(driver);
 loginPage.enterUsername(Username);
 loginPage.enterPassword(Password);
 loginPage.clickLogin();
 productsPage = new ProductsPage(driver);
 Assert.assertEquals(productsPage.getScreenTitle(),"PRODUCTS");
// adding products to the cart
 int productsCount = productsPage.getProductsListCount();
 for (int i = 0; i < productsPage.getProductsListCount();i++)
 {
  productsPage.clickOnRequestedProduct(i);
  Thread.sleep(5000);
  scrollDown(driver);
  itemDetailsPage = new ItemDetailsPage(driver);
  itemDetailsPage.clickOnAddToCart();
  itemDetailsPage.clickOnBackToProducts();
 }
// productsPage.clickOnFirstProduct();
// itemDetailsPage = new ItemDetailsPage(driver);
// itemDetailsPage.clickOnAddToCart();
// itemDetailsPage.clickOnBackToProducts();
// productsPage.clickOnSecondProduct();
// itemDetailsPage.clickOnAddToCart();
// itemDetailsPage.clickOnBackToProducts();

// assert on quantity for added products
 headerBarPage =  new HeaderBarPage(driver);
 headerBarPage.clickOnCartIcon();
 yourCartPage = new YourCartPage(driver);
 Assert.assertEquals(yourCartPage.getItemsCount(),productsCount);
// assert on quantity after deleting products
 yourCartPage.clickOnRemoveFromTheCart();
 Assert.assertEquals(yourCartPage.getItemsCount(),productsCount -1);
tearDown();
}


}
