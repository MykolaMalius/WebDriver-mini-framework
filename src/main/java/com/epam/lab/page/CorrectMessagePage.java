package com.epam.lab.page;
import com.epam.lab.singletondriver.SingletonDriver;
import com.epam.lab.wrappers.Button;
import com.epam.lab.wrappers.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CorrectMessagePage extends PageObject{
    private WebDriver driver = SingletonDriver.getInstance();
    private final Wait wait = new WebDriverWait(driver, 5, 1000);
    @FindBy(css = "div.aoD.hl")
    private Button adressNewInput;
    @FindBy(css = "div.vM")
    private Button clearAdressButton;
    @FindBy(css = "textarea.vO")
    private Label adressInput;
    @FindBy(css = "div.T-I.J-J5-Ji.aoO.T-I-atl.L3")
    private Button sendButton;
    @FindBy(css = "div.vh")
    private WebElement sentMessageConfirm;

    public CorrectMessagePage clickOnAddressInputAndClear(){
        adressNewInput.click();
        clearAdressButton.click();
        return this;
    }
    public CorrectMessagePage writeNewAddressAndSend(String newAddress){
        adressInput.sendKeys(newAddress);
        sendButton.click();
        return this;
    }
    public boolean checkThatMessageWasSent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.vh")));
        return sentMessageConfirm.isDisplayed();
    }
}
