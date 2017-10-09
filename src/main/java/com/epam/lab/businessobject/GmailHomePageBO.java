package com.epam.lab.businessobject;
import com.epam.lab.page.*;
import com.epam.lab.parsers.LetterJAXBParser;
import com.epam.lab.singletondriver.SingletonDriver;
import org.openqa.selenium.WebDriver;

public class GmailHomePageBO {
  private WebDriver driver = SingletonDriver.getInstance();
  private LetterJAXBParser letterJAXBParser = new LetterJAXBParser();
  private  IncorrectMessagePage newMessagePage = new IncorrectMessagePage();
  private AlertErrorPage alertErrorPage = new AlertErrorPage();
  private CorrectMessagePage correctMessagePage = new CorrectMessagePage();
  private SentMessagesPage sentMessagesPage = new SentMessagesPage();

    public GmailHomePageBO() {
    }
    public boolean checkPresentOfHomePage(){
        return newMessagePage.checkPresentOfHomePage();
    }

    public void writeIncorrectMessage(){
        newMessagePage.clickNewMessage();
        newMessagePage.writeIncorrectAdressOfMessage(letterJAXBParser.getIncorrectAddress(0));
        newMessagePage.writTitleOfMessage(letterJAXBParser.getTitleOfMessage(0));
        newMessagePage.writeContentAndSend(letterJAXBParser.getContentOfMessage(0));
    }
    public void checkForValidAlertErrorMessage() {
        alertErrorPage.checkingValidErrorMessage();
    }
    public boolean checkPresentOfAlert(){
        return alertErrorPage.checkPresentOfAlert();
    }
    public void writeCorrectMessage( ){
        correctMessagePage.clickOnAddressInputAndClear();
        correctMessagePage.writeNewAddressAndSend(letterJAXBParser.getCorrectAdress(0));
    }
    public boolean checkThatMessageWasSent(){
        return correctMessagePage.checkThatMessageWasSent();
    }
    public void checkForPresentSentMessage() {
        sentMessagesPage.checkSentMessage();
    }
    public boolean checkWindowForWritingMessage(){
        return newMessagePage.checkPresentOfWindowForWriteMessage();
    }
}
