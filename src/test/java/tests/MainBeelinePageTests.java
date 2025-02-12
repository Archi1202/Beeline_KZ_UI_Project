package tests;

import com.codeborne.selenide.Configuration;
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
@DisplayName("Check features on the Main Page and QA position search in Beeline People")

public class MainBeelinePageTests extends TestBase {

    @BeforeEach
    void setUpPeoplePage() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    MainPage mainPage = new MainPage();
    PeoplePage peoplePage = new PeoplePage();

    @Test
    @Tag("Beeline_Main_Page")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz/ru")
    @DisplayName("Confirm 'WhatsUp' and 'Telegram' buttons appear on the main page")
    void checkBottomLineInfoTest() {
        mainPage.openPage();
        mainPage.checkWhatsUpButton();
        mainPage.checkTelegramButton();
    }

    @Test
    @Tag("Beeline_Main_Page")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz/ru")
    @DisplayName("Validate location selection functionality on the main page")
    void changeLocationTest() {
        mainPage.openPage();
        mainPage.setCity("Астана");
        mainPage.checkChangedLocation("Астана");
    }

    @Test
    @Tag("Beeline_Main_Page")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz/ru")
    @DisplayName("Ensure 'Вакансии и карьера в Beeline' link is present in the footer")
    void checkPeopleCareerNavigationTest() {
        mainPage.openPage();
        mainPage.checkCareerSection();
        mainPage.navigateToCareerPage();
        peoplePage.checkCareerPage();
    }
}
