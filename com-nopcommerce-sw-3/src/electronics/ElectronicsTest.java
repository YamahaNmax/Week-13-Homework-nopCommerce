package electronics;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElectronicsTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    public void selectMenu(String menu) {
        WebElement menuLink = driver.findElement(By.xpath(menu));
        menuLink.click();

    }

    public void verify(String title, String text) {
        String actualText = driver.findElement(By.className(title)).getText();
        Assert.assertEquals(actualText, text);
    }

    public void verify1(String title, String text) {
        String actualText = driver.findElement(By.xpath(title)).getText();
        Assert.assertEquals(actualText, text);
    }

    public void fillForm(String path, String value){
        driver.findElement(By.xpath(path)).sendKeys(value);
    }

    @Before

    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void textVerified() {

        Actions actions = new Actions(driver);

        WebElement computers=driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/a"));

        WebElement software=driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]/a"));

        actions.moveToElement(computers).moveToElement(software).click().build().perform();

        verify("page-title", "Cell phones");
    }


    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        Actions actions = new Actions(driver);

        WebElement computers=driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/a"));

        WebElement software=driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]/a"));

        actions.moveToElement(computers).moveToElement(software).click().build().perform();

        verify("page-title", "Cell phones");

        selectMenu("//div[@class='product-viewmode']/a[2]");

        Thread.sleep(1000);

        selectMenu("//div[@data-productid='20']/div[2]/h2/a");

        Thread.sleep(2000);

        verify("product-name", "Nokia Lumia 1020");

        verify("product-price","$349.00");

        WebElement qty = driver.findElement(By.xpath("//div[@class='add-to-cart-panel']/input[1]"));
        qty.clear();
        qty.sendKeys("2");

        selectMenu("//div[@class='add-to-cart-panel']/button");

        Thread.sleep(1000);

        verify("content","The product has been added to your shopping cart");

        selectMenu("//div[@class='bar-notification success']/span[1]");

        Actions actions1 = new Actions(driver);

        Thread.sleep(3000);

        WebElement shoppingCart=driver.findElement(By.xpath("//div[@class='header']/div[1]/div[2]/div[1]/ul[1]/li[4]"));
        WebElement goToCart=driver.findElement(By.xpath("//div[@class='header']/div[1]/div[2]/div[2]/div[1]/div[4]/button[1]"));
        actions1.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();

        Thread.sleep(2000);

        verify("page-title", "Shopping cart");

        Thread.sleep(2000);

        verify1("//td[@class='quantity']/input", "");

        verify1("//td[@class='subtotal']/span", "$698.00");


        selectMenu("//div[@class='terms-of-service']/input[1]");

        selectMenu("//div[@class='checkout-buttons']/button[1]");

        verify("page-title", "Welcome, Please Sign In!");

        selectMenu("//div[@class='customer-blocks']/div[1]/div[3]/button[2]");

        Thread.sleep(1000);

        verify("page-title", "Register");

        WebElement genderButton = driver.findElement(By.id("gender-male"));
        genderButton.click();

        WebElement firstNameField = driver.findElement(By.id("FirstName"));
        firstNameField.sendKeys("Miten");

        WebElement lastNameField = driver.findElement(By.id("LastName"));
        lastNameField.sendKeys("Patel");

        WebElement dateField = driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select"));
        dateField.sendKeys("15");

        WebElement monthField = driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select[2]"));
        monthField.sendKeys("August");

        WebElement yearField = driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select[3]"));
        yearField.sendKeys("1998");

        WebElement fieldLastName = driver.findElement(By.id("Company"));
        fieldLastName.sendKeys("Software Testing");

        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("m4mitzcodebuster11111@gmail.com");

        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Codebuster");

        WebElement confirmPasswordField = driver.findElement(By.id("ConfirmPassword"));
        confirmPasswordField.sendKeys("Codebuster");

        WebElement registerButton = driver.findElement(By.id("register-button"));
        registerButton.click();

        verify1("//div[@class='page-body']/div[1]","Your registration completed");

        selectMenu("//div[@class='page-body']/div[2]/a");

        Thread.sleep(1000);

        verify("page-title", "Shopping cart");

        Thread.sleep(1000);

        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click();

        WebElement emailLoginField = driver.findElement(By.id("Email"));
        emailLoginField.sendKeys("m4mitzcodebuster11111@gmail.com");

        WebElement passwordLoginField = driver.findElement(By.id("Password"));
        passwordLoginField.sendKeys("Codebuster");

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        loginButton.click();

        Thread.sleep(1000);

        selectMenu("//div[@class='terms-of-service']/input[1]");

        selectMenu("//div[@class='checkout-buttons']/button[1]");


        WebElement sortByPosition3 = driver.findElement(By.xpath("//div[@class='edit-address']/div[5]/select"));
        sortByPosition3.click();

        Select select3 = new Select(sortByPosition3);
        select3.selectByVisibleText("United Kingdom");

        fillForm("//div[@class='edit-address']/div[6]/select", "");

        fillForm("//div[@class='edit-address']/div[7]/input[1]", "London");

        fillForm("//div[@class='edit-address']/div[8]/input[1]", "3 Stn stat");

        fillForm("//div[@class='edit-address']/div[9]/input[1]", "Harrow");

        fillForm("//div[@class='edit-address']/div[10]/input[1]", "HA7 4PD");

        fillForm("//div[@class='edit-address']/div[11]/input[1]", "1234567890");

        fillForm("//div[@class='edit-address']/div[12]/input[1]", "223344");

        selectMenu("//div[@id='billing-buttons-container']/button[4]");

        Thread.sleep(5000);

        selectMenu("//div[@id='checkout-shipping-method-load']/div[1]/div[1]/ul[1]/li[2]/div[1]/input[1]");

        selectMenu("//div[@id='shipping-method-buttons-container']/button[1]");
        ;

        Thread.sleep(1000);

        selectMenu("//div[@class='section payment-method']/ul[1]/li[2]/div[1]/div[2]/input");

        selectMenu("//div[@id='payment-method-buttons-container']/button[1]");

        Thread.sleep(1000);

        WebElement sortByPosition4 = driver.findElement(By.xpath("//div[@class='info']/table[1]/tbody[1]/tr[1]/td[2]/select[1]"));
        sortByPosition4.click();

        Select select4 = new Select(sortByPosition4);
        select4.selectByIndex(1);

        fillForm("//div[@class='info']/table[1]/tbody[1]/tr[2]/td[2]/input", "Mr Miten patel");

        fillForm("//div[@class='info']/table[1]/tbody[1]/tr[3]/td[2]/input", "1111 2222 3333 4444");

        WebElement sortByPosition5 = driver.findElement(By.xpath("//div[@class='info']/table[1]/tbody[1]/tr[4]/td[2]/select[2]"));
        sortByPosition5.click();

        Select select5 = new Select(sortByPosition5);
        select5.selectByIndex(3);

        fillForm("//div[@class='info']/table[1]/tbody[1]/tr[5]/td[2]/input", "555");

        selectMenu("//div[@id='checkout-step-payment-info']/div[1]/button[1]");

        Thread.sleep(1000);

        verify1("//div[@class='billing-info-wrap']/div[2]/ul[1]/li[1]/span[2]", "Credit Card");

        verify1("//div[@class='shipping-info-wrap']/div[2]/ul[1]/li[1]/span[2]", "Next Day Air");

        verify1("//div[@class='total-info']/table[1]/tbody[1]/tr[4]/td[2]/span","$698.00");

        selectMenu("//div[@id='checkout-step-confirm-order']/div[2]/button[1]");

        Thread.sleep(1000);

        verify1("//div[@class='center-1']/div[1]/div[1]/h1","Thank you");

        verify1("//div[@class='center-1']/div[1]/div[2]/div[1]/div[1]/strong", "Your order has been successfully processed!");

        selectMenu("//div[@class='center-1']/div[1]/div[2]/div[1]/div[3]/button");

        Thread.sleep(1000);

        verify1("//div[@class='topic-block']/div[1]/h2","Welcome to our store");

        selectMenu("//div[@class='header-links-wrapper']/div[1]/ul[1]/li[2]/a[1]");

        String url1 = driver.getCurrentUrl();
        Assert.assertEquals(url1,"https://demo.nopcommerce.com/");

    }

    @After
    public void endTest() {
        closeBrowser();
    }
}
