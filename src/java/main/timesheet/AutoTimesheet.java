package main.timesheet;

import com.codeborne.selenide.Condition;
import main.datastore.UserPrefs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class AutoTimesheet {

    private WebDriver driver;
    private UserPrefs userPrefs;

    public final static String ADPADDRESS = "https://workforcenow.adp.com/public/index.htm";
    public final static String USERNAME_SELECTOR = ".input1";
    public final static String PW_SELECTOR = ".input2";
    public final static String LOGIN_BUTTON_SELECTOR = "#portal\\.login\\.logIn";
    public final static String MYSELF_TAB_SELECTOR = "#Myself_navItem_label";
    public final static String TIME_AND_ATTENDANCE_SELECTOR =
            "#revit_layout_TabContainer_1_tablist_dijit_layout_ContentPane_4 > span:nth-child(2) > span:nth-child(1)";
    public final static String MY_TIMECARD_SELECTOR =
            "#Myself_ttd_MyselfTabTimecardsAttendanceSchCategoryTLMWebMyTimecard > span:nth-child(2)";

    public AutoTimesheet(WebDriver wd, UserPrefs up) {
        this.driver = wd;
        this.userPrefs = up;
    }

    public void run() {
        this.login();
        //sleep(1000);
        this.openTimesheet();
        this.enterHours();
        sleep(3000);
        driver.close();
    }

    public void login() {
        driver.navigate().to(this.ADPADDRESS);
        WebElement username_field = driver.findElement(By.cssSelector(USERNAME_SELECTOR));
        $(username_field).shouldBe(Condition.visible).setValue(this.userPrefs.getUsername());
        WebElement password_field = driver.findElement(By.cssSelector(PW_SELECTOR));
        $(password_field).shouldBe(Condition.visible).setValue(this.userPrefs.getPassword());
        WebElement login_button = driver.findElement(By.cssSelector(LOGIN_BUTTON_SELECTOR));
        $(login_button).shouldBe(Condition.visible).click();
    }

    public void openTimesheet() {
        WebElement myself_tab = driver.findElement(By.cssSelector(MYSELF_TAB_SELECTOR));
        $(myself_tab).shouldBe(Condition.visible).click();
        WebElement timeAndAttendance_option = driver.findElement(By.cssSelector(TIME_AND_ATTENDANCE_SELECTOR));
        $(timeAndAttendance_option).shouldBe(Condition.visible).click();
        WebElement myTimesheet_option = driver.findElement(By.cssSelector(MY_TIMECARD_SELECTOR));
        $(myTimesheet_option).shouldBe(Condition.visible).click();
    }

    public void enterHours() {
        // #r_1
        WebElement cell1 = driver.findElement(By.cssSelector("#r_1_e_1_Value"));
        $(cell1).shouldBe(Condition.visible).setValue("8.00");
    }

    public WebDriver getWd() {
        return this.driver;
    }
    public void setWd(WebDriver wd) {
        this.driver = wd;
    }
}
