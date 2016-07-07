package main;

import com.codeborne.selenide.Condition;
import main.timesheet.TimesheetController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class main {
    private static Map<String, String> creds;

    public static void main(String[] args) {

        TimesheetController tc = new TimesheetController(args);
        creds =  tc.argsParser(args);


        WebDriver driver =  new FirefoxDriver();
        driver.navigate().to("https://workforcenow.adp.com/public/index.htm");
        WebElement username_field = driver.findElement(By.cssSelector("#login input[class *= 'input1']"));
        $(username_field).shouldBe(Condition.visible).setValue(creds.get("username"));
        WebElement password_field = driver.findElement(By.cssSelector("#login input[class *= 'input2']"));
        $(password_field).shouldBe(Condition.visible).setValue(creds.get("password"));
        WebElement login_button = driver.findElement(By.cssSelector("#portal.login.login"));
        $(login_button).shouldBe(Condition.visible).click();
        sleep(10000);
    }
}
