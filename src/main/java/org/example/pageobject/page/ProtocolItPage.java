package org.example.pageobject.page;

import org.example.pageobject.element.Button;
import org.example.pageobject.element.LookUp;
import org.example.pageobject.section.OffersSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProtocolItPage extends AbstractPage{

    @FindBy(xpath = "//button[.//*[text()='Akceptuję wszystkie']]")
    public Button acceptCookiesBtn;

    @FindBy(xpath = "//div[@class='ata8bmv Wrapper_w1q2hnii']")
    public LookUp findOffersLookUp;

    @FindBy(xpath = "//span[text()='Najnowsze']")
    public Button theNewestBtn;

    @FindBy(xpath = "//section[.//span[text()='Najtrafniejsze']]/following-sibling::section")
    public OffersSection offersSection;

    public ProtocolItPage(WebDriver driver) {
        super(driver);
    }
}
