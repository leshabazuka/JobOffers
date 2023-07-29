package org.example.pageobject.element;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.time.Duration;
import java.util.List;

import static org.example.core.Driver.getDriver;

public class BaseElement extends TypifiedElement {

    protected static final int WAIT_TIMEOUT_SECONDS = 30;
    protected static final int LONG_WAIT_TIMEOUT_SECONDS = 60;
    protected static final int SHORT_WAIT_TIMEOUT_SECONDS = 8;
    protected WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    protected WebDriverWait shortWait = new WebDriverWait(getDriver(), Duration.ofSeconds(SHORT_WAIT_TIMEOUT_SECONDS));
    private static final String REQUIRED = ".//abbr[@title='required']";

    protected BaseElement(WebElement webElement) {
        super(webElement);
    }

//    public WebElement getWebElement() {
//        return webElement;
//    }

    public boolean isRequired() {
        return getWrappedElement().findElements(By.xpath(REQUIRED)).size() == 1;
    }

}
