package main;

import main.timesheet.TimesheetController;

public class main {

    public static void main(String[] args) {
        TimesheetController tc = new TimesheetController(args);
        try {
            tc.run();
        } finally {
            System.exit(0);
        }
    }
}
