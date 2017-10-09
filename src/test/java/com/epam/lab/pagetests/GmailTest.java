package com.epam.lab.pagetests;
import com.epam.lab.businessobject.GmailHomePageBO;
import com.epam.lab.businessobject.GmailLoginBO;
import com.epam.lab.parsers.UserJAXBParser;
import com.epam.lab.singletondriver.EnvProperties;
import com.epam.lab.singletondriver.SingletonDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GmailTest {
    private UserJAXBParser userJAXBParser;
    @BeforeClass()
    public void init() throws InterruptedException {
        userJAXBParser = new UserJAXBParser();
    }
    @Test(dataProvider = "userData", threadPoolSize = 3)/*treadPoolSize write only in suite.xml!*/
    public void testGmail(String login, String password) {
        GmailLoginBO gmailLoginBO = new GmailLoginBO();
        GmailHomePageBO gmailHomePageBO = new GmailHomePageBO();
        Assert.assertTrue(gmailLoginBO.checkPresentOfLoginPage(),"LoginPage is not present!");
        gmailLoginBO.testLogin(login, password);
        Assert.assertTrue(gmailHomePageBO.checkPresentOfHomePage(),"HomePage is not present!");
        gmailHomePageBO.writeIncorrectMessage();
        Assert.assertTrue(gmailHomePageBO.checkWindowForWritingMessage(),"Window for writing new message is not present");
        gmailHomePageBO.checkForValidAlertErrorMessage();
        Assert.assertTrue(gmailHomePageBO.checkPresentOfAlert(),"AlertMessage is not present");
        gmailHomePageBO.writeCorrectMessage();
        Assert.assertTrue(gmailHomePageBO.checkThatMessageWasSent(),"Message was not sent!");
        gmailHomePageBO.checkForPresentSentMessage();
    }
    @DataProvider(name = "userData",parallel = true)
    public Object[][] getData() {
        Object data[][] = new Object[userJAXBParser.getAllUsers().size()][2];
        for (int i = 0; i < userJAXBParser.getAllUsers().size(); i++) {
            data[i][0] = userJAXBParser.getLogin(i);
            data[i][1] = userJAXBParser.getPassword(i);
        }
         return data;
    }
    @AfterMethod
    public void closeDriver(){
        SingletonDriver.quit();
    }

}



