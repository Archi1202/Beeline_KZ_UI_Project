package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.BeginnersPage;
import pages.InternshipPage;
import pages.ItAndBigDataPage;
import pages.PeoplePage;

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
    InternshipPage internshipPage = new InternshipPage();
    BeginnersPage beginnersPage = new BeginnersPage();

    @Test
    @Tag("Beeline_People_Page")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline People page", url = "https://people.beeline.kz")
    @DisplayName("Check that user is able open Beeline People Page")
    void openPeoplePageTest() {

        peoplePage.openPeoplePage()
                .checkCareerPage();
    }

    @Test
    @Tag("Beeline_People_Page")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline People page", url = "https://people.beeline.kz")
    @DisplayName("Check that user opens People Page from and search for QA Automation engineer")
    void searchQAPositionTest() {

        peoplePage.openPeoplePage()
                .searchPosition("QA Automation engineer")
                .checkPositionTitle("QA Automation engineer")
                .navigateToPositionDetails("QA Automation engineer")
                .checkPositionDetails("QA Automation engineer");
    }

    @Test
    @Tag("Beeline_People_Page")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Beeline People page", url = "https://people.beeline.kz")
    @DisplayName("Check that user can open IT and BIG Data section and select filter 'IT' to see all relevant open positions")
    void checkItAndBigDataSectionTest() {

        peoplePage.openPeoplePage()
                .navigateToITAndBigDataSection();
        itAndBigDataPage.selectItOption()
                .checkFilterInJobList("IT");
    }

    @Test
    @Tag("Beeline_People_Page")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Beeline People page", url = "https://people.beeline.kz")
    @DisplayName("Check that user can open job list via 'All Positions' button and apply drop down filter 'Удаленный формат'")
    void verifyAllPositionsRemoteFilterTest() {
        peoplePage.openPeoplePage()
                .navigateToAllPositionsButton()
                .selectDropdownOptionByName("Формат работы", "Удаленный формат");
        itAndBigDataPage.checkFilterInJobList("Удаленный формат");
    }

    @Test
    @Tag("Beeline_People_Page")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Beeline People page", url = "https://people.beeline.kz")
    @DisplayName("Check that Internship page can be opened and user is able to see list of open positions")
    void verifyInternshipPageTest() {
        peoplePage.openPeoplePage()
                .navigateToInternshipPage();
        internshipPage.searchAllPosition()
                .verifyPositionsWithInternship("Стажер");
    }

    @Test
    @Tag("Beeline_People_Page")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Beeline People page", url = "https://people.beeline.kz")
    @DisplayName("Check that Filters Уровень available for user in IT and BIG Data section")
    void verifyFilterLevelTest() {
        peoplePage.openPeoplePage()
                .navigateToITAndBigDataSection();
        peoplePage.selectDropdownOptionByName("Уровень","Senior");
        itAndBigDataPage.checkFilterInJobList("Senior");
    }

    @Test
    @Tag("Beeline_People_Page")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Beeline People page", url = "https://people.beeline.kz")
    @DisplayName("Check the 'Начинающим' page visible for user and details for specific position can be opened")
    void verifyBeginnersPageTest() {
        peoplePage.openPeoplePage()
                .navigateToBeginnersPage();
        beginnersPage.checkMainTitle("Стань частью успешной компании")
                .clickBeginCareer()
                .clickMoreButtonInCareer()
                .verifyTextPage("Начни свою карьеру вместе с Beeline Казахстан");
    }

    @Test
    @Tag("Beeline_People_Page")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Beeline People page", url = "https://people.beeline.kz")
    @DisplayName("Check the section 'Ответы на частые вопросы' in Internship section")
    void verifyInternshipPageBottomQuestionListTest() {
        peoplePage.openPeoplePage()
                .navigateToInternshipPage();
        internshipPage.verifyTextForFrequentQuestions("Ответы на частые вопросы")
                .clickOnQuestionFromList("1. Сколько длится стажировка?")
                .verifyDisplayedAnswer("От 3 до 6 месяцев. Масса времени, чтобы научиться и проявить себя.");

    }

    @Test
    @Tag("Beeline_People_Page")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Beeline People page", url = "https://people.beeline.kz")
    @DisplayName("Check the section 'Остались вопросы?' in Internship page")
    void verifyInternshipPageQuestionSupportTest() {
        peoplePage.openPeoplePage()
                .navigateToInternshipPage();
        internshipPage.verifyBottomQuestionText("Остались вопросы?")
                .verifyBottomQuestionButton("Задать вопрос");

    }

}
