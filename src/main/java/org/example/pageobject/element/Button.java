package org.example.pageobject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.core.Driver.getDriver;

public class Button extends BaseElement {
    public Button(WebElement webElement) {
        super(webElement);
    }

    public void clickButton() {
        if(getWrappedElement().isDisplayed()){
            getWrappedElement().click();
        }
    }
}
