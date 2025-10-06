package task12;

import org.openqa.selenium.WebDriver;

public class TextAreaBusinessObject {
    public void signupAndFillTextArea(String text, WebDriver driver) {
        driver.get("https://www.demoblaze.com/");

        TextAreaPageObject textAreaPage = new TextAreaPageObject(driver);
        textAreaPage.clickSignUpMenuButton(); // Sign up
        textAreaPage.waitForTextArea();       // чекаємо
        textAreaPage.setText(text);           // вводимо
        textAreaPage.getText();               // читаємо
        textAreaPage.waitForText(text);       // перевіряємо
    }
}
