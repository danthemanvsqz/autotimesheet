package main.datastore;

import java.util.Map;

public class UserPrefs {

    private String username;
    private String password;

    public UserPrefs (Map<String, String> userData) {
        this.username = userData.get("username");
        this.password = userData.get("password");
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
