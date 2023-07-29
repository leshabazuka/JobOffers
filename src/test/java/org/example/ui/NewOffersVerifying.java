package org.example.ui;

import lombok.extern.log4j.Log4j;
import org.example.steps.pagesteps.ProtocolItPageSteps;
import org.example.steps.sectionteps.OffersSectionSteps;
import org.example.utils.EmailSender;
import org.example.utils.NotepadWriter;
import org.testng.annotations.Test;

import java.util.List;

@Log4j
@Test
public class NewOffersVerifying extends CommonConditions {

    @Test
    public void verifyTodayOffersExisting() {
        ProtocolItPageSteps protocolItPagesteps = new ProtocolItPageSteps();
        protocolItPagesteps
                .openProtocolItPage()
                .searchTechnologyWord("Java")
                .searchKeyWord("Selenium")
                .sortByFreshness();

        List<String> urlList = new OffersSectionSteps().getRecentOffersUrl();
        NotepadWriter.writeOffersIntoFile(urlList);
    }
}
