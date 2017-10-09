package com.epam.lab.page;
import com.epam.lab.singletondriver.EnvProperties;
import com.epam.lab.singletondriver.SingletonDriver;
import com.epam.lab.wrappers.Button;
import com.epam.lab.wrappers.Label;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage extends PageObject{
    private EnvProperties envProperties = new EnvProperties();
    private WebDriver driver = SingletonDriver.getInstance();
    private final Wait wait = new WebDriverWait(driver, 5, 1000);

    @FindBy(css = "input.whsOnd.zHQkBf")
    private Label loginInput;
    @FindBy(css = "span.RveJvd.snByac")
    private Button nextButton;
    @FindBy(css = "input.whsOnd.zHQkBf")
    private Label passwordInput;
    @FindBy(xpath = "//*[@id=\"passwordNext\"]/content/span")
    private Button logButton;

    public boolean checkPresentOfLoginPage(){
        boolean presentOfLoginPage = loginInput.isDisplayed();
        return presentOfLoginPage;
    }
    public void typeLoginAndSubmit(String login) {
        driver.get(envProperties.getBaseUrl());
        loginInput.sendKeys(login);
        nextButton.click();
    }

    public void typePasswordAndSubmit(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"passwordNext\"]/content/span")));
        passwordInput.sendKeys(password);
        logButton.click();
    }
}



