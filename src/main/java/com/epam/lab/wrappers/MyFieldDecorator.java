package com.epam.lab.wrappers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public class MyFieldDecorator extends DefaultFieldDecorator {
    public MyFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (WebElement.class.isAssignableFrom(field.getType())) {
            return super.decorate(loader, field);
        }
        else {

            if (Button.class.isAssignableFrom(field.getType())) {
                ElementLocator locator = factory.createLocator(field);
                Button button = new Button(proxyForLocator(loader, locator));
                return button;
            }
            else if(Label.class.isAssignableFrom(field.getType())) {
                ElementLocator locator = factory.createLocator(field);
                Label label = new Label(proxyForLocator(loader,locator));
                return label;
            }
        }
        return null;
    }
}
