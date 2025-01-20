package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ItAndBigDataPage;
import pages.PeoplePage;

import static io.qameta.allure.Allure.step;

@Feature("Beeline Kazakhstan People Page")
@Owner("Anuar Zhangeldi")
@DisplayName("Check search for QA position and People Page features")

public class PeopleBeelineTests extends TestBase {

    @BeforeEach
    void setUpPeoplePage() {
        Configuration.baseUrl = "https://people.beeline.kz";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    PeoplePage peoplePage = new PeoplePage();

    ItAndBigDataPage itAndBigDataPage = new ItAndBigDataPage();

    @Test
    @Tag("Beeline_People_Page")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline People page", url = "https://people.beeline.kz")
    @DisplayName("Check that user is able open Beeline People Page")
    void openPeoplePageTest() {

        step("Open the People Beeline page", () -> {
            peoplePage.openPeoplePage();
        });
        step("Check People Beeline page opened", () -> {
            peoplePage.checkCareerPage();
        });
    }

    @Test
    @Tag("Beeline_People_Page")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline People page", url = "https://people.beeline.kz")
    @DisplayName("Check that user opens People Page from and search for QA Automation engineer")
    void searchQAPositionTest() {


        step("Open the People Beeline page", () -> {
            peoplePage.openPeoplePage();
        });
        step("Search the QA Automation engineer", () -> {
            peoplePage.searchPosition("QA Automation engineer");
        });
        step("Check the existence of the position", () -> {
            peoplePage.checkPositionTitle("QA Automation engineer");
        });
        step("Click on the position title to open Detailed page", () -> {
            peoplePage.navigateToPositionDetails("QA Automation engineer");
        });
        step("Check the title of position", () -> {
            peoplePage.checkPositionDetails("QA Automation engineer");
        });
    }

    @Test
    @Tag("Beeline_People_Page")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Beeline People page", url = "https://people.beeline.kz")
    @DisplayName("Check that user can open IT and BIG Data section and select filter 'IT' to see all relevant open positions")
    void checkItAndBigDataSectionTest() {


        step("Open the People Beeline page", () -> {
            peoplePage.openPeoplePage();
        });
        step("Navigate to IT and Big Data section", () -> {
            peoplePage.navigateToITAndBigDataSection();
        });
        step("Select option IT from the available search filters", () -> {
            itAndBigDataPage.selectItOption();
        });
        step("Get the list of job items and assert that at least one contains the label 'IT'", () -> {
            itAndBigDataPage.checkFilterInJobList("IT");
        });
    }

    @Test
    @Tag("Beeline_People_Page")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Beeline People page", url = "https://people.beeline.kz")
    @DisplayName("Check that user can open job list via 'All Positions' button and apply drop down filter 'Удаленный формат'")
    void verifyAllPositionsRemoteFilterTest() {


        step("Open the People Beeline page", () -> {
            peoplePage.openPeoplePage();
        });
        step("Navigate to All positions button", () -> {
            peoplePage.navigateToAllPositionsButton();
        });
        step("Select format of work - Remote in filters", () -> {
            peoplePage.selectDropdownOptionByName("Формат работы", "Удаленный формат");
        });
        step("Get the list of job items and assert that all positions contains the label 'Удаленный формат'", () -> {
            itAndBigDataPage.checkFilterInJobList("Удаленный формат");
        });
    }

}
