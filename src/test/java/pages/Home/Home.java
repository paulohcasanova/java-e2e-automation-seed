package pages.Home;

import constants.ConstantsEnum;
import constants.WebEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageBase;

public class Home extends PageBase {

    private HomeElementEnum webEnum;
    private Home(WebDriver driver) throws Exception {
        super(driver);
        this.webEnum = new HomeElementEnum(driver instanceof ChromeDriver);
    }

    public static Home of(WebDriver driver) throws Exception {
        return new Home(driver);
    }
    //region Web Elements
    private By LoginButton() { return By.xpath(WebEnum.LOGIN_BUTTON_ELEMENT);}
    private By UsernameInput() { return By.xpath(WebEnum.USERNAME_INPUT_ELEMENT);}
    //Below option if the elements are different between Desktop and Mobile
    private By PasswordInput(){ return By.xpath(webEnum.PASSWORD_INPUT_ELEMENT());}
    //endregion

    //region Actions
    public Home goToURL(){
        driver.navigate().to(ConstantsEnum.HOME_URL);
        return this;
    }
    public Home clickLoginButton(){
        click(LoginButton());
        return this;
    }
    public Home fillUsername(String username){
        fillString(UsernameInput(), username);
        return this;
    }
    public Home fillPassword(String password){
        fillString(PasswordInput(), password);
        return this;
    }
    //endregion
}



