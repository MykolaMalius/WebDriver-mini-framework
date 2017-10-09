package com.epam.lab.wrappers;
import org.openqa.selenium.WebElement;

public class Label extends Element  {
    public Label(WebElement webElement) {
        super(webElement);
    }
    public void sendKeys(CharSequence... charSequences) {
        webElement.sendKeys(charSequences);
    }
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }
}
