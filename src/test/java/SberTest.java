
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


/**
 * @author Nikita Blokhin
 */
public class SberTest extends BaseTest {
    private final By topBarSelect = By.xpath(".//div[@class='kit-hidden kit-hidden_screenreader']");
    private final By regionSelect = By.xpath(".//a[@data-id='52']");
    private final By chkRegionSelect = By.xpath(".//span[text()='Нижегородская область']");
    private final By footerScroll = By.xpath(".//div[@class='footer-info']");

    private final By icon_yt = By.xpath(".//div[@class='sbrf-div-list-inner --area bp-area footer-white']//span[@class='social__icon social__icon_type_yt']");
    private final By icon_fb = By.xpath(".//div[@class='sbrf-div-list-inner --area bp-area footer-white']//span[@class='social__icon social__icon_type_fb']");
    private final By icon_vk = By.xpath(".//div[@class='sbrf-div-list-inner --area bp-area footer-white']//span[@class='social__icon social__icon_type_vk']");
    private final By icon_tw = By.xpath(".//div[@class='sbrf-div-list-inner --area bp-area footer-white']//span[@class='social__icon social__icon_type_tw']");
    private final By icon_ok = By.xpath(".//div[@class='sbrf-div-list-inner --area bp-area footer-white']//span[@class='social__icon social__icon_type_ok']");
    private final By icon_ins = By.xpath(".//div[@class='sbrf-div-list-inner --area bp-area footer-white']//span[@class='social__icon social__icon_type_ins']");


    @Test
    public void sberTest() throws InterruptedException {

        WebElement webElement = driver.findElement(topBarSelect);
        new Actions(driver).moveToElement(webElement).perform();
        webElement.click();

        waitVisibilityOf(regionSelect);
        WebElement searchRegion = driver.findElement(regionSelect);
        searchRegion.click();

        //Проверка области
        WebElement checkRegion = driver.findElement(chkRegionSelect);
        String factRegion = checkRegion.getText();
        Assert.assertTrue("Заголовок не соответствует ", factRegion.contains("Нижегородская область"));

        //Прокрутка вниз
        WebElement footer = driver.findElement(footerScroll);
        Actions actions = new Actions(driver);
        actions.moveToElement(footer);
        actions.perform();

        //проверка наличия значков соцсетей
        driver.findElement(icon_yt).isDisplayed();
        driver.findElement(icon_fb).isDisplayed();
        driver.findElement(icon_vk).isDisplayed();
        driver.findElement(icon_tw).isDisplayed();
        driver.findElement(icon_ok).isDisplayed();
        driver.findElement(icon_ins).isDisplayed();

    }

}


