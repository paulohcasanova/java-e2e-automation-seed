package pages;

import constants.WebEnum;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    public WebDriver driver;
    public WebDriverWait wait;
    public By HomeButton(){ return By.xpath(WebEnum.HOME_BUTTON);}
    public By BackButton(){ return By.xpath(WebEnum.BACK_BUTTON);}
    public By YesPopUpButton(){return By.xpath(WebEnum.YES_POPUP_BUTTON);}

    public PageBase(WebDriver driver) throws Exception {
        this.driver = driver;
        this.wait = (WebDriverWait) new WebDriverWait(driver, 300).ignoring(StaleElementReferenceException.class);
    }

    ExpectedCondition<Boolean> pageLoaded = new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver input) {
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        }
    };

    public void waitForElement(By byElement){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byElement));
    }

    public void waitForElementNotVisible(WebElement element) {
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public void waitForElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElement(){
        wait.until(pageLoaded);
    }

    public void click(By locator){
        try {
            waitForElement(locator);
            driver.findElement(locator).click();
        }catch (StaleElementReferenceException sef){
            waitForElement(locator);
            driver.findElement(locator).click();
        }
    }

    public void fillString(By locator, String value){
        waitForElement(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    public void click(WebElement element){
        waitForElement(element);
        element.click();
    }

    public void clickHome(){
        waitForElement(HomeButton());
        click(HomeButton());
    }

    public void clickBackButton(){
        waitForElement(BackButton());
        click(BackButton());
    }

    public void clickYesPopUp(){
        waitForElement(YesPopUpButton());
        click(YesPopUpButton());
    }

}

