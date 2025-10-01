package task11;

//1. Make up one simple UI end-to-end test case for your test page from Task_10
//2. Automate that scenario using WebDriver
//3. Create PageObject (use Business object if needed)for all pages used in the scenario

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.UUID;

public class Task11Test {
    @BeforeClass
    public void setUp(){
        ChromeDriverManager.getInstance().setup();
        DriverProvider.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        DriverProvider.getDriver().manage().window().maximize();
    }
    @Test public void task11(){
        WebDriver driver = DriverProvider.getDriver();
// Step 1 click Sign Up button
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.clickSignUp();
// Step 2 fill form
        driver.findElement(By.id("sign-username")).sendKeys(UUID.randomUUID().toString().substring(0,10));
        driver.findElement(By.id("sign-password")).sendKeys(UUID.randomUUID().toString().substring(0,10));
// Step 3 Submit
        driver.findElement(By.xpath("//button[text()= 'Sign up']")).click();
// Step 4 Validate success message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String message = alert.getText();
        Assert.assertEquals(message, "Sign up successful.", "invalid message");
// Step 5 Close message
        alert.accept();
    }
    @AfterClass
    public void tearDown(){
        DriverProvider.getDriver().quit();
    }
}
