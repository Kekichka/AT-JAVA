package task11;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task11Test {

    @BeforeClass
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        DriverProvider.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        DriverProvider.getDriver().manage().window().maximize();
    }

    @Test
    public void task11() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.clickSignUp();
        String username = signUpPage.randomString();
        String password = signUpPage.randomString();
        signUpPage.enterCredentials(username, password);
        signUpPage.submitForm();

        String message = signUpPage.getAlertMessage();
        Assert.assertEquals(message, "Sign up successful.", "Invalid sign-up confirmation message");
    }

    @AfterClass
    public void tearDown() {
        DriverProvider.getDriver().quit();
    }
}
