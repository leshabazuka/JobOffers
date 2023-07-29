package org.example.pageobject.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.example.utils.StringEditor.getDaysFreshness;

public class TextField extends BaseElement{
    public TextField(WebElement webElement) {
        super(webElement);
    }

    public boolean verifyFreshLevel(){
        String elementText = shortWait.until(ExpectedConditions.visibilityOf(getWrappedElement())).getText();
        return getDaysFreshness(elementText) >= 25;
    }
}
