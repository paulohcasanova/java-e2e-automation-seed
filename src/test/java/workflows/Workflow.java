package workflows;

import org.openqa.selenium.WebDriver;
import pages.Home.Home;
import pages.PageBase;

public class Workflow  extends PageBase {

    private Workflow(WebDriver driver) throws Exception{
        super(driver);
    }
    public static Workflow of(WebDriver driver) throws Exception{
        return new Workflow(driver);
    }
    //region Flow
    public void ExampleFlow(String param1) throws Exception {
        Home.of(this.driver)
                .goToURL()
                .fillUsername("")
                .fillPassword("")
                .clickLoginButton();
        // other steps

        // assert
    }
    //endregion
}



