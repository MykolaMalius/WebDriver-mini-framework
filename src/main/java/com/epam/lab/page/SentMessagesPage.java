package com.epam.lab.page;
import com.epam.lab.singletondriver.EnvProperties;
import com.epam.lab.singletondriver.SingletonDriver;
import com.epam.lab.wrappers.Button;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
public class SentMessagesPage extends PageObject {
    private final Logger LOG = Logger.getLogger(SentMessagesPage.class);
    private WebDriver driver = SingletonDriver.getInstance();
    private EnvProperties envProperties = new EnvProperties();
    private final Wait wait = new WebDriverWait(driver, 5, 1000);
    @FindBy(css = "a[href='https://mail.google.com/mail/u/0/#sent']")
    private Button sentMessagesButton;
    @FindAll({@FindBy(className = "zA zE")})
    public List<WebElement> listOfSentMessages;
    public void checkSentMessage() {
        sentMessagesButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("zA zE")));
        for (int i = 0; i < listOfSentMessages.size(); i++) {
            if (listOfSentMessages.get(i).getText().contains(envProperties.getSentMessage())) {
               LOG.info("Your message was sent!Success!");
               LOG.info(listOfSentMessages.get(i).getText());
            }
        }
    }
}
