package main.timesheet;

import main.main;
import org.openqa.selenium.WebDriver;

public class AutoTimesheet {

    WebDriver wd;
    public WebDriver getWd() {
        return wd;
    }
    public void setWd(WebDriver wd) {
        this.wd = wd;
    }
    public AutoTimesheet(WebDriver wd) {
        this.wd = wd;
    }
}
