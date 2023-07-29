package org.example.pageobject.section;

import org.example.pageobject.element.Button;
import org.example.pageobject.element.TextField;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class OffersSection extends HtmlElement {
    public static final String OFFERS_LIST = "//div[./h1[contains(text(),'Praca w IT – ')]]//a[@aria-label='Sekcja oferty pracy']";
    public static final String OFFERTA = "(//div[./h1[contains(text(),'Praca w IT – ')]]//a[@aria-label='Sekcja oferty pracy'])[%d]";

    @FindBy(xpath = "//nav//a[@aria-label='Idź do previous strony']")
    public Button previousOfferTab;

    @FindBy(xpath = "//nav//a[@aria-label='Idź do next strony']")
    public Button nextOfferTab;

    @FindBy(xpath = "//div[contains(text(), 'ważna jeszcze') or contains(text(), 'valid for')]")
    public TextField offerFreshTxt;
}
