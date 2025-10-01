package task11;

import org.openqa.selenium.By;

public class SignUpPage {
    public SignUpPage() {
        DriverProvider.getDriver().get("https://www.demoblaze.com/");
    }

    public void clickSignUp() {
        DriverProvider.getDriver().findElement(By.linkText("Sign up")).click();
    }
}
