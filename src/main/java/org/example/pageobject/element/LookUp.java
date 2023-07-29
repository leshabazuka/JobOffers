package org.example.pageobject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static javax.swing.text.SimpleAttributeSet.EMPTY;
import static org.example.core.Driver.getDriver;
import static org.example.utils.MarkElements.markElementBlueColor;

public class LookUp extends BaseElement{
    public static final String KEY_WORD = ".//div[./span[text()='słowo kluczowe'] and .//strong[text()='%s']]";
    public static final String KEY_WORD_CLOUD = ".//span[text()='%s']";
    public static final String TECH_WORD = ".//div[./span[text()='filtr: '] and .//strong[text()='%s']]";
    public static final String TECH_WORD_CLOUD = "//section[.//span[text()='Najtrafniejsze']]//div[./span[text()='%s']]";
    public static final String INPUT = ".//input";

    public LookUp(WebElement webElement) {
        super(webElement);
    }

    public void findKeyWord(String keyWord) {
        WebElement webElement = getWrappedElement();
        markElementBlueColor(getDriver(), webElement);
        webElement.click();
        webElement.findElement(By.xpath(INPUT)).sendKeys(keyWord);

        shortWait.until(ExpectedConditions.visibilityOf(webElement.findElement(By.xpath(String.format(KEY_WORD, keyWord))))).click();
        markElementBlueColor(getDriver(), shortWait.until(ExpectedConditions.visibilityOf(webElement.findElement(By.xpath(String.format(KEY_WORD_CLOUD, keyWord.toLowerCase()))))));;
    }

    public void findTechnologiesWord(String techWord) {
        WebElement webElement = getWrappedElement();
        markElementBlueColor(getDriver(), webElement);
        webElement.click();
        webElement.findElement(By.xpath(INPUT)).sendKeys(techWord);

        shortWait.until(ExpectedConditions.visibilityOf(webElement.findElement(By.xpath(String.format(TECH_WORD, techWord))))).click();
        markElementBlueColor(getDriver(), shortWait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(String.format(TECH_WORD_CLOUD, techWord))))));
    }
}
