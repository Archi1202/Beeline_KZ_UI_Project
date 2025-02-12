package tests;

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
    @DisplayName("Verify accessibility of the Beeline People page")
    void openPeoplePageTest() {

        peoplePage.openPeoplePage()
                .checkCareerPage();
    }

    @Test
    @Tag("Beeline_People_Page")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline People page", url = "https://people.beeline.kz")
    @DisplayName("Search for QA Automation Engineer position on Beeline People page")
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
    @DisplayName("Validate job search using quick filters in the IT and Big Data section")
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
    @DisplayName("Test job search functionality with 'All Positions' button and filter options (Remote work format)")
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
    @DisplayName("Check that the Internship page displays available positions")
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
    @DisplayName("Validate 'Уровень' filter functionality in the IT and Big Data section")
    void verifyFilterLevelTest() {
        peoplePage.openPeoplePage()
                .navigateToITAndBigDataSection();
        peoplePage.selectDropdownOptionByName("Уровень", "Senior");
        itAndBigDataPage.checkFilterInJobList("Senior");
    }

    @Test
    @Tag("Beeline_People_Page")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Beeline People page", url = "https://people.beeline.kz")
    @DisplayName("Ensure the visibility of the 'Начинающим' page and access to specific career fields")
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
    @DisplayName("Verify visibility of the FAQ section on the Internship page")
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
    @DisplayName("Ensure the 'Остались вопросы?' section is displayed at the bottom of the page")
    void verifyInternshipPageQuestionSupportTest() {
        peoplePage.openPeoplePage()
                .navigateToInternshipPage();
        internshipPage.verifyBottomQuestionText("Остались вопросы?")
                .verifyBottomQuestionButton("Задать вопрос");

    }

}
