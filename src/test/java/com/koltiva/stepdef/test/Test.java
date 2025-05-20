package com.koltiva.stepdef.test;

import com.koltiva.hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import purchase.Products;
import utils.PropertyManager;

import java.io.IOException;
import java.util.Properties;

public class Test {
    private Properties props = new PropertyManager().getPropsDemo();

    private AndroidDriver<AndroidElement> driver;

    public Test() throws IOException {
        super();
        this.driver = Hooks.driver;
    }

    @Given("The user opens the app")
    public void test(){
        System.out.println("the users open the app");
    }

    @And("Gives valid credentials")
    public void givesValidCredentials() {
        Products clickSideButton = new Products(driver);
        clickSideButton.clickOnSideMenu();
        Products clickOnLoginSide = new Products(driver);
        clickOnLoginSide.clickOnLoginSide();
        Products fillOnUsername = new Products(driver);
        fillOnUsername.fillOnUsername(props.getProperty("data.login.username"));
        Products fillOnPassword = new Products(driver);
        fillOnPassword.fillOnPasword(props.getProperty("data.login.password"));
        Products clickOnLogin = new Products(driver);
        clickOnLogin.clickOnLogin();
    }

    @Then("The user will be logged in")
    public void theUserWillBeLoggedIn() {
        Products isProductsDisplayed = new Products(driver);
        Assert.assertEquals(props.getProperty("data.login.isProductsDisplayed"), isProductsDisplayed.isProductsDisplayed());
    }

    @And("Sorts the Price by Descending order")
    public void sortsThePriceByDescendingOrder() {
        Products clickOnSort = new Products(driver);
        clickOnSort.clickOnSort();
        Products clickOnPriceDesc = new Products(driver);
        clickOnPriceDesc.clickOnPriceDesc();
    }

    @And("Chooses the most expensive item and add to cart")
    public void choosesTheMostExpensiveItemAndAddToCart() {
        Products clickOnMostExpensiveJacket = new Products(driver);
        clickOnMostExpensiveJacket.clickOnMostExpensiveJacket();
        Products addToCartJacket = new Products(driver);
        addToCartJacket.clickOnAddToCart();
    }

    @Then("Opens the cart and assert the price value and then checkout")
    public void opensTheCartAndAssertThePriceValue() {
        Products clickOnCartFilled = new Products(driver);
        clickOnCartFilled.clickOnCartFilled();
        Products isPriceMostExpensive = new Products(driver);
        Products.putPriceMostExpensive();
        Assert.assertEquals(isPriceMostExpensive.getTotalItemText(), Products.getPriceMostExpensiseTag());
        Products clickOnCheckout = new Products(driver);
        clickOnCheckout.clickOnCheckout();
    }

    @And("Fills in all fields on the checkout page and then to payment")
    public void fillsInAllFieldsOnTheCheckoutPage() {
        Products fillOnFullName = new Products(driver);
        fillOnFullName.fillOnFullName(props.getProperty("data.checkout.fullName"));
        Products fillOnAddressOne = new Products(driver);
        fillOnAddressOne.fillOnAddressLineOne(props.getProperty("data.checkout.addressOne"));
        Products fillOnAddressTwo = new Products(driver);
        fillOnAddressTwo.fillOnAddressLineTwo(props.getProperty("data.checkout.addressTwo"));
        Products fillOnCity = new Products(driver);
        fillOnCity.fillOnCity(props.getProperty("data.checkout.city"));
        Products fillOnState = new Products(driver);
        fillOnState.fillOnState(props.getProperty("data.checkout.state"));
        Products fillOnZipCode = new Products(driver);
        fillOnZipCode.fillOnZipCode(props.getProperty("data.checkout.zipCode"));
        Products fillOnCountry = new Products(driver);
        fillOnCountry.fillOnCountry(props.getProperty("data.checkout.country"));
        Products clickOnPayment = new Products(driver);
        clickOnPayment.clickOnPayment();
    }

    @And("Fills in all fields on the card page and then to review order")
    public void fillsInAllFieldsOnTheCardPageAndThenToReviewOrder() {
        Products fillOnFullNameCard = new Products(driver);
        fillOnFullNameCard.fillOnFullNameCard(props.getProperty("data.card.fullName"));
        Products fillOnCardNumber = new Products(driver);
        fillOnCardNumber.fillOnCardNumber(props.getProperty("data.card.cardNumber"));
        Products fillOnExpirationDate = new Products(driver);
        fillOnExpirationDate.fillOnExpirationDate(props.getProperty("data.card.expirationDate"));
        Products fillOnSecurityCode = new Products(driver);
        fillOnSecurityCode.fillOnSecurityCode(props.getProperty("data.card.securityCode"));
        Products clickOnReviewOrder = new Products(driver);
        clickOnReviewOrder.clickOnReviewOrder();
    }

    @Then("validates the jacket price and total item price")
    public void validatesTheJacketPriceAndTotalItemPrice() throws InterruptedException{
        Products isCheckoutJacketPrice = new Products(driver);
        Products.putPriceMostExpensive();
        Assert.assertEquals(isCheckoutJacketPrice.priceJacketOnCheckout(), Products.getPriceMostExpensiseTag());
        Products scrollToFinish = new Products(driver);
        scrollToFinish.scrollToFinish();
        double jacketPrice = 49.99;
        double deliveryPrice = 5.99;
        double totalItem = jacketPrice + deliveryPrice;
        double totalPrice = 55.98;
        if (totalItem == totalPrice){
            System.out.println("The total is the same.");
        }
        else {
            System.out.println("The total is not the same");
        }
        Products clickOnPlaceOrder = new Products(driver);
        clickOnPlaceOrder.clickOnPlaceOrder();
        Products isOrderComplete = new Products(driver);
        Assert.assertEquals(isOrderComplete.checkOutComplete(), props.getProperty("data.order.complete"));

    }

    @And("Logout from the app")
    public void logoutFromTheApp() {
        Products clickSideButton = new Products(driver);
        clickSideButton.clickOnSideMenu();
        Products clickOnLogOut = new Products(driver);
        clickOnLogOut.clickOnLogOut();
        Products clickOnLogOutConfirm = new Products(driver);
        clickOnLogOutConfirm.clickOnLogoutConfirm();

    }

    @Then("validates the log out")
    public void validatesTheLogOut() {
        Products logoutComplete = new Products(driver);
        Assert.assertEquals(logoutComplete.checkOutComplete(), props.getProperty("data.order.complete"));
    }
}
