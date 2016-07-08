package main.timesheet;

import main.datastore.UserPrefs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;
import java.util.HashMap;

public class TimesheetController {

    private Map<String, String> args;
    private AutoTimesheet autoTimesheet;

    public final static String[] KEYS = {"username", "password", "startDay", "startTime", "endTime"};

    public TimesheetController(String[] args) {
        try {
            this.args = argsParser(args);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        this.autoTimesheet = new AutoTimesheet(new FirefoxDriver(), new UserPrefs(this.args));
    }

    public TimesheetController() {
    }

    public void run() {
        this.autoTimesheet.run();
    }

    // For now <Username:"usn">, <PW:"pw">
    public Map<String, String> argsParser(String[] args) throws IllegalArgumentException {
        if (args == null) {
            throw new IllegalArgumentException("No args passed");
        }
        if (args.length != 5) {
            throw new IllegalArgumentException("args is not the right size");
        }
        Map<String, String> returnValue = new HashMap<String, String>();

        for(String s : args) {
            String [] kv = s.split("=");
            for(String k : KEYS) {
                if(k.compareTo(kv[0]) == 0) {
                    try {
                        returnValue.put(kv[0], kv[1]);
                    } catch (ArrayIndexOutOfBoundsException unused_e) {
                        throw new IllegalArgumentException("args need to be passed as key value pairs");
                    }
                }
            }
        }

        for(String k : KEYS) {
            if(!returnValue.containsKey(k)) throw new IllegalArgumentException("args are not valid");
        }
        return returnValue;
    }

}
