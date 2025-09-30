package task10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//1. Set up ChromeDriver using the driver file and properties.
//2. Set up ChromeDriver using DriverManager.
//3. Navigate to the page assigned to your variant.
//4. Select any three different elements.
//5. Interact with all the selected elements.
//6. Verify the visibility of each element using assertions.
//7. Wrap all these steps into a TestNG test case.

public class Task10DriveManager {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver",
                "driver/chromedriver");
//        options.addArguments("--headless=new");

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.demoblaze.com/cart.html");

        WebElement homeButton = driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a"));
        homeButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
