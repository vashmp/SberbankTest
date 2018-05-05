
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Nikita Blokhin
 */
public class SberTest {
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.sberbank.ru/ru/person");
    }

    @After
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void sberTest() throws InterruptedException {
        WebElement webElement = driver.findElement(By.xpath(".//div[@class='kit-hidden kit-hidden_screenreader']"));
        new Actions(driver).moveToElement(webElement).perform();
        webElement.click();
        /*   WebElement inputRegion = driver.findElement(By.xpath(".//input[@class='kit-input__control']"));
        Thread.sleep(1000);
        inputRegion.sendKeys("Нижегородская область");*/ //Не получается передать значение в поле как написано в ТЗ
        //Поэтому выбираем область кликом
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//a[@data-id='52']"))));
        WebElement searchRegion = driver.findElement(By.xpath(".//a[@data-id='52']"));
        searchRegion.click();

        //Проверка области
        WebElement checkRegion = driver.findElement(By.xpath(".//span[text()='Нижегородская область']"));
        String factRegion = checkRegion.getText();
        Assert.assertTrue("Заголовок не соответствует ", factRegion.contains("Нижегородская область"));

        //Прокрутка вниз
        WebElement footer = driver.findElement(By.xpath(".//div[@class='footer-info']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(footer);
        actions.perform();

        //проверка наличия значков соцсетей
        driver.findElement(By.xpath(".//span[@class='social__icon social__icon_type_yt']")).isDisplayed();
        driver.findElement(By.xpath(".//span[@class='social__icon social__icon_type_fb']")).isDisplayed();
        driver.findElement(By.xpath(".//span[@class='social__icon social__icon_type_tw']")).isDisplayed();
        driver.findElement(By.xpath(".//span[@class='social__icon social__icon_type_vk']")).isDisplayed();
        driver.findElement(By.xpath(".//span[@class='social__icon social__icon_type_ok']")).isDisplayed();
        driver.findElement(By.xpath(".//span[@class='social__icon social__icon_type_ins']")).isDisplayed();

    }

}


