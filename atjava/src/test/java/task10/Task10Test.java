package task10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task10Test {
    WebDriver driver;

    @BeforeTest
    void setUp(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver",
                "driver/chromedriver");
//        options.addArguments("--headless=new");

        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver(options);
    }

    @Test
    void task10Test(){

        driver.get("https://www.demoblaze.com/cart.html");

        WebElement homeButton = driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a"));
        Assert.assertTrue(homeButton.isDisplayed());

        homeButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
    @AfterTest
    void close(){
        driver.quit();
    }
}
