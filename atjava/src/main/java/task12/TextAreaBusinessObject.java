package task12;

import org.openqa.selenium.WebDriver;

public class TextAreaBusinessObject {
    public void signupAndFillTextArea(String text, WebDriver driver) {
        driver.get("https://www.demoblaze.com/");

        TextAreaPageObject textAreaPage = new TextAreaPageObject(driver);
        textAreaPage.clickSignUpMenuButton(); // спершу відкриваємо Sign up
        textAreaPage.waitForTextArea();       // чекаємо textarea
        textAreaPage.setText(text);           // вводимо текст
        textAreaPage.getText();               // читаємо текст
        textAreaPage.waitForText(text);       // перевіряємо, що текст зʼявився
    }
}
