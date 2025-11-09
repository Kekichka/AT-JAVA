package task20;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Task20Test {

    @Test
    void invalidInputTest() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setDeviceName("Medium_Phone")
                .setApp("C:\\Users\\home\\Desktop\\AT\\atjava\\apk\\calc.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://192.168.56.1:4723"), options);

        driver.findElement(By.id("com.motorola.cn.calculator:id/formula_or_result")).sendKeys("abc");

        driver.findElement(By.id("com.motorola.cn.calculator:id/eq")).click();

        String result = driver.findElement(By.id("com.motorola.cn.calculator:id/formula_or_result")).getText();
        assert result.contains("Error") : "Error message not displayed! Actual: " + result;

        driver.quit();
    }
}
