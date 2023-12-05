package electronics;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElectronicsTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    public void selectMenu(String menu) {
        WebElement menuLink = driver.findElement(By.xpath(menu));
        menuLink.click();

    }

    @Before

    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {

        WebElement textDesktop = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
        textDesktop.click();

        selectMenu("//ul[@class='nav navbar-nav']/li[1]/div[1]/a");

        WebElement sortByPosition = driver.findElement(By.id("input-sort"));
        sortByPosition.click();

        Select select = new Select(sortByPosition);
        select.selectByIndex(2);

    }

    @After
    public void endTest() {
        closeBrowser();
    }
}
