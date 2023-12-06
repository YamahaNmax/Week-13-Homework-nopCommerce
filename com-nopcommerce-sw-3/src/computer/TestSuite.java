package computer;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestSuite extends BaseTest {

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
    public void verifyProductArrange() throws InterruptedException {

        selectMenu("//div[@class='master-wrapper-page']/div[2]/ul/li/a");

        selectMenu("//div[@class='master-column-wrapper']/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2");

        WebElement sortByPosition = driver.findElement(By.id("products-orderby"));
        sortByPosition.click();

        Select select = new Select(sortByPosition);
        select.selectByIndex(2);

        Thread.sleep(5000);
    }


    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        selectMenu("//div[@class='master-wrapper-page']/div[2]/ul/li/a");

        selectMenu("//div[@class='master-column-wrapper']/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2");

        WebElement sortByPosition = driver.findElement(By.id("products-orderby"));
        sortByPosition.click();

        Select select = new Select(sortByPosition);
        select.selectByIndex(1);

        Thread.sleep(1000);

        selectMenu("//div[@class='products-wrapper']/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]");

        Thread.sleep(1000);

        verify("product-name", "Build your own computer");

        WebElement sortByPosition1 = driver.findElement(By.id("product_attribute_1"));
        sortByPosition1.click();

        Select select1 = new Select(sortByPosition1);
        select1.selectByIndex(1);

        WebElement sortByPosition2 = driver.findElement(By.id("product_attribute_2"));
        sortByPosition2.click();

        Select select2 = new Select(sortByPosition2);
        select2.selectByIndex(3);

        selectMenu("//dd[@id='product_attribute_input_3']/ul[1]/li[2]/input[1]");

        selectMenu("//dd[@id='product_attribute_input_4']/ul[1]/li[2]/input[1]");

        Thread.sleep(1000);

        selectMenu("//dd[@id='product_attribute_input_5']/ul[1]/li[3]/input[1]");

        Thread.sleep(1000);

        verify("product-price", "$1,475.00");

        selectMenu("//div[@class='add-to-cart-panel']/button[1]");

        Thread.sleep(1000);

        verify("content","The product has been added to your shopping cart");

        selectMenu("//div[@class='bar-notification success']/span[1]");

        Actions actions = new Actions(driver);

        Thread.sleep(1000);
        WebElement shoppingCart=driver.findElement(By.xpath("//div[@class='header']/div[1]/div[2]/div[1]/ul[1]/li[4]"));
        WebElement goToCart=driver.findElement(By.xpath("//div[@class='header']/div[1]/div[2]/div[2]/div[1]/div[4]/button[1]"));
        actions.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();

        verify("page-title", "Shopping cart");

        WebElement qty = driver.findElement(By.xpath("//div[@class='table-wrapper']/table[1]/tbody[1]/tr[1]/td[5]/input[1]"));
        qty.clear();
        qty.sendKeys("2");
        qty.sendKeys(Keys.RETURN);

        verify("product-subtotal", "$2,950.00");

        selectMenu("//div[@class='terms-of-service']/input[1]");

        selectMenu("//div[@class='checkout-buttons']/button[1]");

        verify("page-title", "Welcome, Please Sign In!");

        selectMenu("//div[@class='customer-blocks']/div[1]/div[3]/button[1]");

        fillForm("//div[@class='edit-address']/div[1]/input[1]", "Miten");

        fillForm("//div[@class='edit-address']/div[2]/input[1]", "Patel");

        fillForm("//div[@class='edit-address']/div[3]/input[1]", "m4mitzcodebuster@gmail.com");

        fillForm("//div[@class='edit-address']/div[4]/input[1]", "Codebuster");

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

        Thread.sleep(1000);

        selectMenu("//div[@id='checkout-shipping-method-load']/div[1]/div[1]/ul[1]/li[2]/div[1]/input[1]");

        selectMenu("//div[@id='shipping-method-buttons-container']/button[1]");

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

        verify1("//div[@class='total-info']/table[1]/tbody[1]/tr[4]/td[2]/span","$2,950.00");

        selectMenu("//div[@id='checkout-step-confirm-order']/div[2]/button[1]");

        Thread.sleep(1000);

        verify1("//div[@class='center-1']/div[1]/div[1]/h1","Thank you");

        verify1("//div[@class='center-1']/div[1]/div[2]/div[1]/div[1]/strong", "Your order has been successfully processed!");

        selectMenu("//div[@class='center-1']/div[1]/div[2]/div[1]/div[3]/button");

        Thread.sleep(1000);

        verify1("//div[@class='topic-block']/div[1]/h2","Welcome to our store");
    }

    @After
    public void endTest() {
        closeBrowser();
    }
}
