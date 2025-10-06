package task12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextAreaPageObject {

    WebDriver driver;
    WebDriverWait wait;

    // кнопка "Sign up" у меню
    @FindBy(xpath = "//*[@id=\"signin2\"]")
    WebElement signUpMenuButton;

    // textarea, яка зʼявляється в модальному вікні після кліку на Sign up
    @FindBy(xpath = "//*[@id=\"sign-username\"]")
    WebElement textArea;

    public TextAreaPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickSignUpMenuButton() {
        signUpMenuButton.click();
        System.out.println("Clicked on Sign Up menu button");
    }

    public void waitForTextArea() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sign-username\"]")));
        System.out.println("Textarea is visible");
    }

    public void setText(String text) {
        textArea.clear();
        textArea.sendKeys(text);
        System.out.println("Set text: " + text);
        try {
            Thread.sleep(2000); // робимо паузу 2 секунди, щоб було видно результат
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public String getText() {
        String value = textArea.getAttribute("value");
        System.out.println("Retrieved text: " + value);
        return value;
    }

    public void waitForText(String expectedText) {
        wait.until(ExpectedConditions.textToBePresentInElementValue(textArea, expectedText));
        System.out.println("Text \"" + expectedText + "\" is present in textarea");
    }
}
