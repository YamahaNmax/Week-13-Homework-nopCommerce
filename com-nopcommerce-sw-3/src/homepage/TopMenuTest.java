package homepage;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    public void selectMenu(String menu) {
        WebElement menuLink = driver.findElement(By.xpath(menu));
        menuLink.click();

    }

    public void verify(String title, String text) {
        String actualText = driver.findElement(By.className(title)).getText();
        Assert.assertEquals(actualText, text);
    }

    @Before

    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyPageNavigation() {

        selectMenu("//div[@class='master-wrapper-page']/div[2]/ul/li/a");
        verify("page-title", "Computers");

        selectMenu("//div[@class='master-wrapper-page']/div[2]/ul/li[2]/a");
        verify("page-title", "Electronics");

        selectMenu("//div[@class='master-wrapper-page']/div[2]/ul/li[3]/a");
        verify("page-title", "Apparel");

        selectMenu("//div[@class='master-wrapper-page']/div[2]/ul/li[4]/a");
        verify("page-title", "Digital downloads");

        selectMenu("//div[@class='master-wrapper-page']/div[2]/ul/li[5]/a");
        verify("page-title", "Books");

        selectMenu("//div[@class='master-wrapper-page']/div[2]/ul/li[6]/a");
        verify("page-title", "Jewelry");

        selectMenu("//div[@class='master-wrapper-page']/div[2]/ul/li[7]/a");
        verify("page-title", "Gift Cards");
    }

    @After
    public void endTest() {
        closeBrowser();
    }
}
