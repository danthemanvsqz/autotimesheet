package test;


import main.timesheet.TimesheetController;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TimesheetControllerTest {
    private static TimesheetController tc;

    @BeforeClass
    public static void setup() {
        tc = new TimesheetController();
    }

    @Test public void
    argsParser_Should_Return_Hashmap_with_Username_and_Password() throws Exception {
        String fake_username = "fake_username";
        String fake_pw = "fake_pw";
        String fake_start_day = "Fake_start";
        String fake_start_time = "fake_st";
        String fake_end_time = "fake_end";
        String username_key = TimesheetController.KEYS[0];
        String pw_key = TimesheetController.KEYS[1];
        String sd_key = TimesheetController.KEYS[2];
        String st_key = TimesheetController.KEYS[3];
        String et_key = TimesheetController.KEYS[4];
        String [] fake_args = {username_key + "=" + fake_username,
            pw_key + "=" + fake_pw, sd_key + "=" + fake_start_day,
            st_key + "=" + fake_start_time, et_key + "=" + fake_end_time};
        Map<String, String> expect = new HashMap<String, String>();

        expect.put(username_key, fake_username);
        expect.put(pw_key, fake_pw);
        expect.put(sd_key, fake_start_day);
        expect.put(st_key, fake_start_time);
        expect.put(et_key, fake_end_time);

        assertThat(tc.argsParser(fake_args), is(expect));
    }

    @Test (expected = IllegalArgumentException.class) public void
    argsParser_Should_Throw_Exception_if_Args_Size_Invalid() throws Exception {
        String[] fake_args = {"fake_username"};

        tc.argsParser(fake_args);
    }

    @Test (expected = IllegalArgumentException.class) public void
    argsParser_Should_Throw_Exception_if_Args_are_null() throws Exception {
        tc.argsParser(null);
    }

    @Test (expected = IllegalArgumentException.class) public void
    argsParser_Should_Throw_Exception_if_Args_are_not_valid_args() throws Exception {
        String [] fake_args = {"foo=bar", "biz=baz"};
        tc.argsParser(fake_args);
    }

    @Test (expected = IllegalArgumentException.class) public void
    argsParser_Should_Throw_Exception_if_Args_are_not_Key_Value_pairs() throws Exception {
        String [] fake_args = {"foo", "bar"};
        tc.argsParser(fake_args);
    }

}









