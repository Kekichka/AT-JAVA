package task11;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.UUID;

public class SignUpPage {

    private final WebDriver driver;

    private final By signUpLink = By.linkText("Sign up");
    private final By usernameField = By.id("sign-username");
    private final By passwordField = By.id("sign-password");
    private final By signUpButton = By.xpath("//button[text()='Sign up']");

    public SignUpPage() {
        this.driver = DriverProvider.getDriver();
        driver.get("https://www.demoblaze.com/");
    }

    public void clickSignUp() {
        driver.findElement(signUpLink).click();
    }

    public void enterCredentials(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void submitForm() {
        driver.findElement(signUpButton).click();
    }

    public String getAlertMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String message = alert.getText();
        alert.accept();
        return message;
    }

    public String randomString() {
        return UUID.randomUUID().toString().substring(0, 10);
    }
}
