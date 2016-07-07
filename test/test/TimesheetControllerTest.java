package test;

import main.timesheet.TimesheetController;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by spencec on 7/7/16.
 */
public class TimesheetControllerTest {
    @Test public void
    argsParser_Should_Return_Hashmap_with_Username_and_Password() throws Exception {
        TimesheetController tc = new TimesheetController(null);
        Map<String, String> expect = new HashMap<String, String>();
        String[] fake_args = {"fake_username", "fake_pw"};
        expect.put("username", fake_args[0]);
        expect.put("pw", fake_args[1]);

        assertThat(tc.argsParser(fake_args), is(expect));
    }

}