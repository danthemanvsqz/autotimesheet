package main.timesheet;

import main.datastore.UserPrefs;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

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
    public Map<String, String> argsParser(String[] args) throws Exception {
        if (args.length != 2)
            throw new Exception("args is not the right size");

        Map<String, String> returnValue = new HashMap<String, String>();


        return returnValue;
    }
}
