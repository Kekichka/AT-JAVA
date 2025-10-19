package task13;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import task12.TextAreaBusinessObject;
import task13.CustomListener;

//General task (use Task_12 like base)
//Implement custom Listeners with methods for your variant.
//Add logging for all overridden listener methods using log4j console and file appenders
//V6. ITestListener method task (3, 4); ISuiteListener, IExecutionListener,IInvoke...(1, 4)
//
//1. Open Demoblaze
//2. Click Sign up
//3. Wait for the username textarea.
//4. Type text
//5. Verify that the text has been entered correctly.
//6. Listener should log every stage of execution to console and log file.

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

