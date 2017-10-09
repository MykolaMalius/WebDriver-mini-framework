package com.epam.lab.page;
import com.epam.lab.singletondriver.SingletonDriver;
import com.epam.lab.wrappers.Button;
import com.epam.lab.wrappers.Label;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class IncorrectMessagePage extends PageObject{
    private WebDriver driver = SingletonDriver.getInstance();
    private final Wait wait = new WebDriverWait(driver, 10, 1000);
    private boolean presentOfWindowForMessages;
    @FindBy(xpath = "//div/div[@gh = 'cm']")
    private WebElement writeNewMessage;
    @FindBy(css = "textarea.vO")
    private Label adressInput;
    @FindBy(css = "input.aoT")
    private Label titleInput;
    @FindBy(css = "div.Am.Al.editable.LW-avf")
    private Label contentOfMessage;
    @FindBy(css = "div.T-I.J-J5-Ji.aoO.T-I-atl.L3")
    private Button sendButton;

    public boolean checkPresentOfHomePage(){
        boolean presentOfHomePage = writeNewMessage.isDisplayed();
        return presentOfHomePage;
    }
    public void clickNewMessage(){
        wait.until(ExpectedConditions.visibilityOf(writeNewMessage));
        writeNewMessage.click();

    }
    public void writeIncorrectAdressOfMessage(String incorrectAdress){
        presentOfWindowForMessages = adressInput.isDisplayed();
        adressInput.sendKeys(incorrectAdress);
    }
    public void writTitleOfMessage(String title){
        titleInput.sendKeys(title);
    }
    public void writeContentAndSend(String content){
        contentOfMessage.sendKeys(content);
        sendButton.click();
    }
    public boolean checkPresentOfWindowForWriteMessage(){
        return presentOfWindowForMessages;
    }
}
