package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.PeoplePage;

@Feature("Beeline Kazakhstan Main Page")
@Owner("Anuar Zhangeldi")
@DisplayName("Check features on the Main Page")

public class MainBeelinePageTests extends TestBase {

    final MainPage mainPage = new MainPage();
    final PeoplePage peoplePage = new PeoplePage();

    @BeforeEach
    void setUpPeoplePage() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Test
    @Tag("Beeline_Main_Page")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz/ru")
    @DisplayName("Confirm 'WhatsUp' and 'Telegram' buttons appear on the main page")
    void checkBottomLineInfoTest() {
        mainPage.openPage()
                .checkWhatsUpButton()
                .checkTelegramButton();
    }

    @Test
    @Tag("Beeline_Main_Page")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz/ru")
    @DisplayName("Check search functionality with valid data on the Beeline Main Page")
    void checkSearchFunctionalityTest() {
        mainPage.openPage()
                .clickOnSearchButton()
                .enterSearchValue("NOKIA")
                .openFirstSearchResult()
                .verifyArticleFromSearch("NOKIA");
    }

    @Test
    @Tag("Beeline_Main_Page")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz/ru")
    @DisplayName("Check More button and Fraud section with FAQ from the Main Page")
    void checkFraudSectionTest() {
        mainPage.openPage()
                .navigateToMoreSection()
                .clickOnFraudOption()
                .findQuestionAndExpandIt("Прислали сообщение с просьбой о помощи от лица близкого человека")
                .checkAnswerForFraud("Не паникуйте и не переводите деньги.");
    }

    @Test
    @Tag("Beeline_Main_Page")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz/ru")
    @DisplayName("Validate location selection functionality on the main page")
    void changeLocationTest() {
        mainPage.openPage()
                .setCity("Астана")
                .checkChangedLocation("Астана");
    }

    @Test
    @Tag("Beeline_Main_Page")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz/ru")
    @DisplayName("Ensure 'Вакансии и карьера в Beeline' link is present in the footer")
    void checkPeopleCareerLinkTest() {
        mainPage.openPage()
                .checkCareerSection();
    }

    @Test
    @Tag("Beeline_Main_Page")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz/ru")
    @DisplayName("Check that user can open 'Вакансии и карьера в Beeline' from the Main Page")
    void checkPeopleCareerPageTest() {
        mainPage.openPage()
                .navigateToCareerPage();
        peoplePage.checkCareerPage();
    }


}
