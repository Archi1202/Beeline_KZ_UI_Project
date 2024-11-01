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

import static io.qameta.allure.Allure.step;

@Feature("Beeline Kazakhstan Main Page")
@Owner("Anuar Zhangeldi")
@DisplayName("Check features on the Main Page and QA position search in Beeline People")

public class MainBeelinePageTests extends TestBase {

    @BeforeEach
    void setUpPeoplePage() {
        Configuration.baseUrl = "https://beeline.kz/ru";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    MainPage mainPage = new MainPage();
    PeoplePage peoplePage = new PeoplePage();


    @Test
    @Tag("Beeline")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz/ru")
    @DisplayName("Check that Main Page has Social Media Support buttons 'WhatsUp' and 'Telegram' on the bottom section")
    void checkBottomLineInfoTest() {
        step("open Beeline KZ page", () -> {
            mainPage.openPage();
        });
        step("Check 'WhatsUp' button on the bottom section", () -> {
            mainPage.checkWhatsUpButton();
        });
        step("Check 'Telegram' button on the bottom section", () -> {
            mainPage.checkTelegramButton();
        });

    }

    @Test
    @Tag("Beeline")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz/ru")
    @DisplayName("Check that user is able to change the Language to RU and Location to Astana")
    void changeLocationTest() {
        step("open Beeline KZ page", () -> {
            mainPage.openPage();
        });
        step("Switch location to Астана", () -> {
            mainPage.setCity("Астана");
        });
        step("Check that location was selected to 'Астана'", () -> {
            mainPage.checkChangedLocation("Астана");
        });
    }

    @Test
    @Tag("Beeline")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz/ru")
    @DisplayName("Check there is a 'Вакансии и карьера в Beeline' on the Main Beeline Page")
    void checkPeopleCareerNavigationTest() {

        step("open Beeline KZ page", () -> {
            mainPage.openPage();
        });
        step("Check existence of the 'Вакансии и карьера в Beeline' on the bottom section of page", () -> {
            mainPage.checkCareerSection();
        });
        step("Click on the 'Вакансии и карьера в Beeline' link", () -> {
            mainPage.navigateToCareerPage();
        });
        step("Check that user was redirected to Beeline People page", () -> {
            peoplePage.checkCareerPage();
        });
    }
}
