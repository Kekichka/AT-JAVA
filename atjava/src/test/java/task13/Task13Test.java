package task13;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import task12.TextAreaBusinessObject;
import task13.CustomListener;

@Listeners(CustomListener.class)
public class Task13Test {
    WebDriver driver;

    @BeforeTest
    void setup() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @Test
    void task13() {
        TextAreaBusinessObject textAreaBO = new TextAreaBusinessObject();
        textAreaBO.signupAndFillTextArea("MEOW :333 !", driver);
    }

    @AfterTest
    void teardown() {
        driver.quit();
    }
}

