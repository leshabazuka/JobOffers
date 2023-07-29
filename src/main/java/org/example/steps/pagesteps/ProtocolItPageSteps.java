package org.example.steps.pagesteps;

import org.example.pageobject.page.ProtocolItPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.asserts.SoftAssert;

import static org.example.constants.AssertMessages.EXPECTED_ACTUAL_VALUE;
import static org.example.constants.URL.PROTOCOL_IT;
import static org.example.core.Driver.getDriver;

public class ProtocolItPageSteps {
    public ProtocolItPageSteps openProtocolItPage(){
        getDriver().navigate().to(PROTOCOL_IT);
        ProtocolItPage protocolItPage = new ProtocolItPage(getDriver());
        protocolItPage.acceptCookiesBtn.clickButton();
        Assert.assertEquals(String.format(EXPECTED_ACTUAL_VALUE, "url", PROTOCOL_IT, getDriver().getCurrentUrl()), PROTOCOL_IT, getDriver().getCurrentUrl());
        return this;
    }

    public ProtocolItPageSteps searchKeyWord(String keyWord){
        ProtocolItPage protocolItPage = new ProtocolItPage(getDriver());
        protocolItPage.findOffersLookUp.findKeyWord(keyWord);
        return this;
    }

    public ProtocolItPageSteps searchTechnologyWord(String techWord){
        ProtocolItPage protocolItPage = new ProtocolItPage(getDriver());
        protocolItPage.findOffersLookUp.findTechnologiesWord(techWord);
        return this;
    }

    public ProtocolItPageSteps sortByFreshness(){
        ProtocolItPage protocolItPage = new ProtocolItPage(getDriver());
        protocolItPage.theNewestBtn.clickButton();
        return this;
    }
}
