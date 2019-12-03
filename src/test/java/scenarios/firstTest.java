package scenarios;


import configurations.TestBase;
import constants.DriverEnum;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import workflows.Workflow;

import static constants.DriverEnum.*;

@RunWith(Theories.class)
public class firstTest extends TestBase {

    public firstTest(DriverEnum browser){
        super(browser);
    }

    //Will run each test once for every entry
    public static @DataPoints DriverEnum[] drivers = {ANDROID, IOS, CHROME};

    @Theory
    public void sampleTest() throws Exception {
        Workflow.of(this.driver).ExampleFlow("Fill valid Value");
    }
    @Theory
    public void sampleTest_Neg() throws Exception {
        Workflow.of(this.driver).ExampleFlow(""); // Invalid value
    }
}


