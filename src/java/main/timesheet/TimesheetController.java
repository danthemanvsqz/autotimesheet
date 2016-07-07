package main.timesheet;

import main.datastore.UserPrefs;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class TimesheetController {

    private Map<String, String> args;
    private UserPrefs userPrefs;
    public final static String[] KEYS = {"username", "password"};

    public UserPrefs getUserPrefs() {
        return userPrefs;
    }

    public void setUserPrefs(UserPrefs userPrefs) {
        this.userPrefs = userPrefs;
    }

    public TimesheetController(String[] args) {
        try {
            this.args = argsParser(args);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public TimesheetController() {
    }

    // For now <Username:"usn">, <PW:"pw">
    public Map<String, String> argsParser(String[] args) throws IllegalArgumentException {
        if (args.length != 2) {
            throw new IllegalArgumentException("args is not the right size");
        }
        String username = args[0];
        String pw = args[1];
        Map<String, String> returnValue = new HashMap<String, String>();

        returnValue.put(KEYS[0], args[0]);
        returnValue.put(KEYS[1], args[1]);
        return returnValue;
    }
}
