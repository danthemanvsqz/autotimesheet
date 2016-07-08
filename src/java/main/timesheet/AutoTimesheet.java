package main.timesheet;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import main.datastore.UserPrefs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;

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

    public final static String PAY_PERIOD_SELECT_SELECTOR = "#widget_dateRangeselect input[role *= 'button']";
    public final static String PAY_PERIOD_SELECT_LIST = "#dateRangeselect_popup";
    public final static String PAY_PERIOD_START_DATE_INPUT_SELECTOR = "#dateRangestart";
    public final static String PAY_PERIOD_END_DATE_INPUT_SELECTOR = "#dateRangeend";

    public final static String DATE_PARTIAL_SELECTOR = "InDate";

    public AutoTimesheet(WebDriver wd, UserPrefs up) {
        WebDriverRunner.setWebDriver(wd);
        this.userPrefs = up;
    }

    public void run() {
        this.login();
        this.openTimesheet();
        this.enterHours();
        sleep(3000);
        driver.close();
    }

    public void login() {
        open(ADPADDRESS);
        $(By.cssSelector(USERNAME_SELECTOR)).shouldBe(Condition.visible).setValue(this.userPrefs.getUsername());
        $(By.cssSelector(PW_SELECTOR)).shouldBe(Condition.visible).setValue(this.userPrefs.getPassword());
        $(By.cssSelector(LOGIN_BUTTON_SELECTOR)).shouldBe(Condition.visible).click();
    }

    public void openTimesheet() {
        $(By.cssSelector(MYSELF_TAB_SELECTOR)).shouldBe(Condition.visible).click();
        $(By.cssSelector(TIME_AND_ATTENDANCE_SELECTOR)).shouldBe(Condition.visible).click();
        $(By.cssSelector(MY_TIMECARD_SELECTOR)).shouldBe(Condition.visible).click();
        sleep(1000);
    }

    public void enterHours() {

        for (SelenideElement d : $$("td[id *= 'DayName'] div[id *= 'DayName']").filterBy(Condition.hasText("Fri"))) {
            String dateId = d.parent().parent().$("td[id *= 'InDate'] div[id *= 'InDate']").getText();
            int count = 0;
            for (SelenideElement e : $$("td[id *= 'InDate'] div[id *= 'InDate']").filterBy(Condition.text(dateId))) {
                if (count == 0) {
                    if (e.parent().parent().$("td[id *= 'PayCodeID'] div[id *= 'PayCodeID']").getText().contains("")) {
                        e.parent().parent().$("td[id *= 'InTime'] div[id *= 'InTime']").click();
                        e.parent().parent().$("td[id *= 'InTime'] input[id *= 'TcTimeTextBox_0']").setValue("8:00AM");
                        e.parent().parent().$("td[id *= 'OutTime'] div[id *= 'OutTime']").click();
                        e.parent().parent().$("td[id *= 'OutTime'] input[id *= 'TcTimeTextBox_1']").setValue("12:00PM");
                    }
                } else {
                    e.parent().parent().$("td[id *= 'InTime'] div[id *= 'InTime']").click();
                    e.parent().parent().$("input[id *= 'TcTimeTextBox']").setValue("1:00PM");
                    e.parent().parent().$("td[id *= 'OutTime'] div[id *= 'OutTime']").click();
                    e.parent().parent().$("input[id *= 'TcTimeTextBox']").setValue("5:00PM");
                }
                count++;
            }
        }
    }

    public WebDriver getWd() {
        return this.driver;
    }
    public void setWd(WebDriver wd) {
        this.driver = wd;
    }
}
