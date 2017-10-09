package com.epam.lab.page;
import com.epam.lab.singletondriver.SingletonDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class AlertErrorPage extends PageObject{
    private WebDriver driver = SingletonDriver.getInstance();
    private final Wait wait = new WebDriverWait(driver, 10, 1000);
    private boolean presentOfAlert = false;
    @FindBy(css = "div.Kj-JD-Jz")
    private WebElement errorMessageText;
    @FindBy(css = "button.J-at1-auR")
    private WebElement okButton;

    public void checkingValidErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(okButton));
        presentOfAlert = true;
        okButton.click();
    }
    public boolean checkPresentOfAlert(){
        return presentOfAlert;
    }
}
