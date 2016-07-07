package main;

import main.timesheet.TimesheetController;
import org.apache.commons.lang.IllegalClassException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class main {

    public static void main(String[] args) {
        try {
            TimesheetController tc = new TimesheetController(args);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        //WebDriver driver = new FirefoxDriver();

    }
}
