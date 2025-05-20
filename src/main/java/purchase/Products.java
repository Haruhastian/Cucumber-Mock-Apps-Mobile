package purchase;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en_scouse.An;
import pages.base.BasePage;

import java.util.HashMap;

public class Products extends BasePage {
    @AndroidFindBy (xpath = "//*[@content-desc=\"open menu\"]")
    private MobileElement openMenuButton;
    @AndroidFindBy (xpath = "//*[@text=\"Log In\"]")
    private MobileElement loginSideButton;
    @AndroidFindBy (xpath = "//*[@content-desc=\"Username input field\"]")
    private MobileElement usernameField;
    @AndroidFindBy (xpath = "//*[@content-desc=\"Password input field\"]")
    private MobileElement passwordField;
    @AndroidFindBy (xpath = "(//*[@text=\"Login\"])[2]")
    private MobileElement loginButton;
    @AndroidFindBy (xpath = "//*[@text=\"Products\"]")
    private MobileElement productsText;
    @AndroidFindBy (xpath = "//*[@content-desc=\"sort button\"]")
    private MobileElement sortButton;
    @AndroidFindBy (xpath = "//*[@text=\"Price - Descending\"]")
    private MobileElement priceDescButton;
    @AndroidFindBy (xpath = "//*[@text=\"$49.99\"]")
    private static MobileElement priceMostExpensiveText;
    @AndroidFindBy (xpath = "//*[@text=\"Sauce Labs Fleece Jacket\"]")
    private MobileElement jacketMostExpensiveButton;
    @AndroidFindBy (xpath = "//*[@text=\"Add To Cart\"]")
    private MobileElement addToCartButton;
    @AndroidFindBy (xpath = "//*[@content-desc=\"cart badge\"]")
    private MobileElement cartFilledButton;
    @AndroidFindBy (xpath = "(//*[@text=\"$49.99\"])[2]")
    private MobileElement totalItemText;
    @AndroidFindBy (xpath = "//*[@content-desc=\"Proceed To Checkout button\"]")
    private MobileElement checkoutButton;
    @AndroidFindBy (xpath = "//*[@content-desc=\"Full Name* input field\"]")
    private MobileElement fullNameField;
    @AndroidFindBy (xpath = "//*[@content-desc=\"Address Line 1* input field\"]")
    private MobileElement addressOneField;
    @AndroidFindBy (xpath = "//*[@content-desc=\"Address Line 2 input field\"]")
    private MobileElement addressTwoField;
    @AndroidFindBy (xpath = "//*[@content-desc=\"City* input field\"]")
    private MobileElement cityField;
    @AndroidFindBy (xpath = "//*[@content-desc=\"State/Region input field\"]")
    private MobileElement stateField;
    @AndroidFindBy (xpath = "//*[@content-desc=\"Zip Code* input field\"]")
    private MobileElement zipCodeField;
    @AndroidFindBy (xpath = "//*[@content-desc=\"Country* input field\"]")
    private MobileElement countryField;
    @AndroidFindBy (xpath = "//*[@content-desc=\"To Payment button\"]")
    private MobileElement paymentButton;
    @AndroidFindBy (xpath = "//*[@content-desc=\"Full Name* input field\"]")
    private MobileElement fullNameOnCardField;
    @AndroidFindBy (xpath = "//*[@content-desc=\"Card Number* input field\"]")
    private MobileElement cardNumberField;
    @AndroidFindBy (xpath = "//*[@content-desc=\"Expiration Date* input field\"]")
    private MobileElement expirationDateField;
    @AndroidFindBy (xpath = "//*[@content-desc=\"Security Code* input field\"]")
    private MobileElement securityCodeField;
    @AndroidFindBy (xpath = "//*[@text=\"Review Order\"]")
    private MobileElement reviewOrderButton;
    @AndroidFindBy (xpath = "//*[@text=\"$49.99\"]")
    private MobileElement checkoutJacketPriceText;
    @AndroidFindBy (xpath = "//*[@text=\"DHL Standard Delivery\"]")
    private MobileElement dhlText;
    @AndroidFindBy (xpath = "//*[@text=\"Place Order\"]")
    private MobileElement placeOrderButton;
    @AndroidFindBy (xpath = "//*[@text=\"Checkout Complete\"]")
    private MobileElement checkOutCompleteText;
    @AndroidFindBy (xpath = "//*[@text=\"Log Out\"]")
    private MobileElement logoutButton;
    @AndroidFindBy (xpath = "//*[@text=\"LOG OUT\"]")
    private MobileElement logoutConfirmButton;
    @AndroidFindBy (xpath = "//*[@text=\"You are successfully logged out.\"]")
    private MobileElement isLogout;




    public Products(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
    public void clickOnSideMenu() {
        click(openMenuButton);
    }
    public void clickOnLoginSide(){
        click(loginSideButton);
    }
    public void fillOnUsername(String username){
        sendKeys(usernameField, username);
    }
    public void fillOnPasword(String password){
        sendKeys(passwordField, password);
    }
    public void clickOnLogin(){
        click(loginButton);
    }
    public String isProductsDisplayed(){
        waitForVisibility(productsText);
        return getText(productsText, "productsText");
    }
    public void clickOnSort(){
        click(sortButton);
    }
    public void clickOnPriceDesc(){
        click(priceDescButton);
    }

//    public String getPriceMostExpensiveText(){
//        return getText(priceMostExpensiveText, "getPriceMostExpensiveText");
//    }
    static HashMap<String, String> value = new HashMap<>();
    public static void putPriceMostExpensive(){
        value.put("getPriceMostExpensiveText", priceMostExpensiveText.getText());
        System.out.println(value.get("getPriceMostExpensiveText"));
    }
    public static String getPriceMostExpensiseTag(){
        return value.get("getPriceMostExpensiveTag");
    }
    public String getTotalItemText(){
        return getText(totalItemText, "getTotalItemText");
    }

    public void clickOnMostExpensiveJacket(){
        click(jacketMostExpensiveButton);
    }
    public void clickOnAddToCart(){
        click(addToCartButton);
    }
    public void clickOnCartFilled(){
        click(cartFilledButton);
    }
    public void clickOnCheckout(){
        click(checkoutButton);
    }
    public void fillOnFullName(String fullname){
        sendKeys(fullNameField, fullname);
    }
    public void fillOnAddressLineOne(String addressOne){
        sendKeys(addressOneField, addressOne);
    }
    public void fillOnAddressLineTwo(String addressTwo){
        sendKeys(addressTwoField, addressTwo);
    }
    public void fillOnCity(String city){
        sendKeys(cityField, city);
    }
    public void fillOnState(String state){
        sendKeys(stateField, state);
    }
    public void fillOnZipCode(String zipCode){
        sendKeys(zipCodeField, zipCode);
    }
    public void fillOnCountry(String country){
        sendKeys(countryField, country);
    }
    public void clickOnPayment(){
        click(paymentButton);
    }
    public void fillOnFullNameCard(String fullNameCard){
        sendKeys(fullNameOnCardField, fullNameCard);
    }
    public void fillOnCardNumber(String cardNumber){
        sendKeys(cardNumberField, cardNumber);
    }
    public void fillOnExpirationDate(String expDate){
        sendKeys(expirationDateField, expDate);
    }
    public void fillOnSecurityCode(String sCode){
        sendKeys(securityCodeField, sCode);
    }
    public void clickOnReviewOrder(){
        click(reviewOrderButton);
    }
    public String priceJacketOnCheckout(){
        return getText(checkoutJacketPriceText, "priceJacketOnCheckout");
    }

    public void scrollToFinish() throws InterruptedException{
        swipe(950, 2280, 950, 1200, 250);
//        scrollToElement(dhlText,"up");
        waitForVisibility(dhlText);
    }
    public void clickOnPlaceOrder(){
        click(placeOrderButton);
    }
    public String checkOutComplete(){
        return getText(checkOutCompleteText, "checkOutComplete");
    }
    public void clickOnLogOut(){
        click(logoutButton);
    }
    public void clickOnLogoutConfirm(){
        click(logoutConfirmButton);
    }
    public void isLogout(){

    }
}


