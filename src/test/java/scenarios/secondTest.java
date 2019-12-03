package scenarios;


import configurations.TestBase;
import constants.DriverEnum;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;
import workflows.Workflow;

@RunWith(Theories.class)
public class secondTest extends TestBase {

    public secondTest(){
        super(DriverEnum.CHROME);
    }

    @Test
    public void sampleTest() throws Exception {
        Workflow.of(this.driver).ExampleFlow("Fill valid Value");
    }
    @Test
    public void sampleTest_Neg() throws Exception {
        Workflow.of(this.driver).ExampleFlow(""); // Invalid value
    }
}



