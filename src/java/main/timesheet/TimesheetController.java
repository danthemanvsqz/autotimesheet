package main.timesheet;

import main.datastore.UserPrefs;

import java.util.Map;

public class TimesheetController {

    private String[] args;
    private UserPrefs userPrefs;

    public UserPrefs getUserPrefs() {
        return userPrefs;
    }

    public void setUserPrefs(UserPrefs userPrefs) {
        this.userPrefs = userPrefs;
    }

    public TimesheetController(String[] args) {
        this.args = args;
    }

    // For now <Username:"usn">, <PW:"pw">
    public Map<String,String> argsParser(String[] args) {

        return null;
    }
}
