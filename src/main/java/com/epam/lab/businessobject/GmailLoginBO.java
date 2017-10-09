package com.epam.lab.businessobject;
import com.epam.lab.page.GmailLoginPage;

public class GmailLoginBO {
    private GmailLoginPage gmailLoginPage = new GmailLoginPage();

    public GmailLoginBO() {
    }
    public boolean checkPresentOfLoginPage(){
        return gmailLoginPage.checkPresentOfLoginPage();
    }
    public void testLogin(String  login, String password) {
     gmailLoginPage.typeLoginAndSubmit(login);
     gmailLoginPage.typePasswordAndSubmit(password);
 }
}
