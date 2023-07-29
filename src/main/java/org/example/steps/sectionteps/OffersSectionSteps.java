package org.example.steps.sectionteps;

import org.example.pageobject.element.TextField;
import org.example.pageobject.page.ProtocolItPage;
import org.example.pageobject.section.OffersSection;
import org.example.steps.pagesteps.ProtocolItPageSteps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.example.constants.AssertMessages.EXPECTED_ACTUAL_VALUE;
import static org.example.constants.URL.PROTOCOL_IT;
import static org.example.core.Driver.getDriver;
import static org.example.pageobject.section.OffersSection.OFFERS_LIST;
import static org.example.pageobject.section.OffersSection.OFFERTA;
import static org.example.utils.MarkElements.markElementRedColor;

public class OffersSectionSteps {
    protected WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));

    public List<String> getRecentOffersUrl(){
        List<String> freshOfferUrls = new ArrayList<>();
        OffersSection offersSection = new ProtocolItPage(getDriver()).offersSection;

        for  (int i = 1; i<=25; i++){
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(offersSection.findElement(By.xpath(String.format(OFFERTA,i)))));

            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", el);

            markElementRedColor(getDriver(), el);
            el.click();
            if (offersSection.offerFreshTxt.verifyFreshLevel()) {
                freshOfferUrls.add(getDriver().getCurrentUrl());
            }
        }
        return freshOfferUrls;
    }
}
