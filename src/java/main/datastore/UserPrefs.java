package main.datastore;

import java.util.Map;

public class UserPrefs {

    private String username;
    private String password;
    private String startTime;
    private String endTime;
    private String startDay;

    private static final String MONDAY = "Mon";
    private static final String TUESDAY = "Tue";
    private static final String WEDNESDAY = "Wed";
    private static final String THURSDAY = "Thu";
    private static final String FRIDAY = "Fri";
    private static final String SATURDAY = "Sat";
    private static final String SUNDAY = "Sun";

    public UserPrefs (Map<String, String> userData) {
        this.username = userData.get("username");
        this.password = userData.get("password");
        this.startDay = userData.get("startDay");
        this.startTime = userData.get("startTime");
        this.endTime = userData.get("endTime");
    }


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String firstHalfStart) {
        this.startTime = firstHalfStart;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String secondHalfEnd) {
        this.endTime = secondHalfEnd;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String days) {
        this.startDay = days;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
