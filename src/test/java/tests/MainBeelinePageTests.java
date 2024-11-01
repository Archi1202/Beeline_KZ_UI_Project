package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static io.qameta.allure.Allure.step;

@Feature("Beeline Kazakhstan Main Page")
@Owner("Anuar Zhangeldi")
@DisplayName("Check features on the Main Page and QA position search in Beeline People")

public class MainBeelinePageTests extends TestBase {

    @BeforeEach
    void setUpPeoplePage() {
        Configuration.baseUrl = "https://beeline.kz/";
    }

    MainPage mainPage = new MainPage();


    @Test
    @Tag("Beeline")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz")
    @DisplayName("Check that Main Page has Social Media Support buttons 'WhatsUp' and 'Telegram' on the bottom section")
    void checkBottomLineInfoTest() {
        step("open Beeline KZ page", () -> {
            mainPage.openPage();
        });
        step("Switch Main Page to RU language", () -> {
            mainPage.setLanguage("Рус");
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
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz")
    @DisplayName("Check that user is able to change the Language to RU and Location to Astana")
    void changeLocationAndLanguageTest() {
        step("open Beeline KZ page", () -> {
            mainPage.openPage();
        });
        step("Switch Main Page to RU language", () -> {
            mainPage.setLanguage("Рус");
        });
        step("Switch location to Астана", () -> {
            mainPage.setCity("Астана");
        });
        step("Check that Language changed on Main Page for text - Для меня", () -> {
            mainPage.checkChangedLanguageText();
        });
    }

    @Test
    @Tag("Beeline")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz")
    @DisplayName("Check there is a 'Вакансии и карьера в Beeline' on the Main Beeline Page")
    void checkOnlineShopTest() {

        step("Switch Main Page to RU language", () -> {
            mainPage.setLanguage("Рус");
        });
        step("Check existence of the 'Вакансии и карьера в Beeline' on the bottom section of page", () -> {
            mainPage.checkCareerSection();
        });
    }

    @Test
    @Tag("Beeline")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz")
    @DisplayName("Check that user is able scroll down to the positions section and open People Page")
    void openPeoplePageTest() {

        step("Switch Main Page to RU language", () -> {
            mainPage.setLanguage("Рус");
        });
        step("Check the existence of Career hyperlink and click on it", () -> {
            mainPage.navigateToCareerPage();
        });
        step("Check People Beeline page opened", () -> {
            mainPage.checkCareerPage();
        });
    }


}
