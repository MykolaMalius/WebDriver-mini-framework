package com.epam.lab.page;
import com.epam.lab.singletondriver.SingletonDriver;
import com.epam.lab.wrappers.MyFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class PageObject {
    public PageObject(WebDriver driver) {
        WebDriver instance = SingletonDriver.getInstance();
        PageFactory.initElements( new MyFieldDecorator(new DefaultElementLocatorFactory(instance)),this);
    }

    public PageObject() {
        this(SingletonDriver.getInstance());
    }
}
