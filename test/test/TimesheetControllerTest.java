package test;


import main.timesheet.TimesheetController;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by spencec on 7/7/16.
 */
public class TimesheetControllerTest {
    private static TimesheetController tc;

    @BeforeClass
    public static void setup() {
        tc = new TimesheetController();
    }

    @Test public void
    argsParser_Should_Return_Hashmap_with_Username_and_Password() throws Exception {
        String[] fake_args = {TimesheetController.KEYS[0] + "=fake_username",
                TimesheetController.KEYS[1] + "=fake_pw"};
        Map<String, String> expect = new HashMap<String, String>();

        expect.put(TimesheetController.KEYS[0], fake_args[0]);
        expect.put(TimesheetController.KEYS[1], fake_args[1]);

        assertThat(tc.argsParser(fake_args), is(expect));
    }

    @Test (expected = IllegalArgumentException.class) public void
    argsParser_Should_Throw_Exception_if_Args_Size_Invalid() throws Exception {
        String[] fake_args = {"fake_username"};

        tc.argsParser(fake_args);
    }

}









