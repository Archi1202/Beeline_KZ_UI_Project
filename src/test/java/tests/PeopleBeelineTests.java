package tests;

import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PeoplePage;

import static io.qameta.allure.Allure.step;

public class PeopleBeelineTests extends TestBase{

    PeoplePage peoplePage = new PeoplePage();

    @Test
    @Tag("Beeline")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz")
    @DisplayName("Check that user opens People Page from Main and search for QA Automation engineer")
    void searchQAPositionTest(){


        step("Open the People Beeline page" ,() -> {
            peoplePage.openPeoplePage();
        });
        step("Search the QA Automation engineer" ,() -> {
            peoplePage.searchPosition("QA Automation engineer");
        });
        step("Check the existence of the position and click on it" ,() -> {
            peoplePage.navigateToPositionDetails("QA Automation engineer");
        });
        step("Check the title of position" ,() -> {
            peoplePage.checkPositionName("QA Automation engineer");
        });
    }
}
