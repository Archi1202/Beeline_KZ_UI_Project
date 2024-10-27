package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static io.qameta.allure.Allure.step;

@Feature("Beeline Kazakhstan Main Page")
@Owner("Anuar Zhangeldi")
@DisplayName("Check features on the Main Page")

public class MainBeelinePageTests {

    MainPage mainPage = new MainPage();

    @Test
    @Tag("Beeline")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz")
    @DisplayName("Check there is a Интернет-магазин on the Main Beeline Page")
    void checkOnlineShopTest(){
        step("Open Beeline KZ page" ,() -> {
            mainPage.openPage();
        });
        step("Switch Main Page to RU language" ,() -> {
            mainPage.setLanguage("Рус");
        });
        step("Check existence of the Интернет-магазин",() -> {
            mainPage.checkOnlineShopText();
        });
    }

    @Test
    @Tag("Beeline")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz")
    @DisplayName("Check that user is able to change the Language to RU and Location to Astana")
    void changeLocationAndLanguageTest(){
        step("open Beeline KZ page" ,() -> {
            mainPage.openPage();
        });
        step("Switch Main Page to RU language" ,() -> {
            mainPage.setLanguage("Рус");
        });
        step("Switch location to Астана" ,() -> {
            mainPage.setCity("Астана");
        });

        step("Check that Language changed on Main Page for text - Для меня" ,() -> {
            mainPage.checkChangedLanguageText();
        });
    }

    @Test
    @Tag("Beeline")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz")
    @DisplayName("Check that user is able click on the Add Balance button and redirect to that page")
    void addBalanceTest(){
        step("open Beeline KZ page" ,() -> {
            mainPage.openPage();
        });
        step("Switch Main Page to RU language" ,() -> {
            mainPage.setLanguage("Рус");
        });
        step("Navigate to the Add Balance" ,() -> {
            mainPage.navigateToAddBalance();
        });
        step("Check that user on the Add Balance page" ,() -> {
            mainPage.checkAddBalancePage();
        });
    }

    @Test
    @Tag("Beeline")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz")
    @DisplayName("Check that user is able scroll down to the positions section and open People Page")
    void openPeoplePageTest(){
        step("open Beeline KZ page" ,() -> {
            mainPage.openPage();
        });
        step("Switch Main Page to RU language" ,() -> {
            mainPage.setLanguage("Рус");
        });
        step("Check the existence of Career hyperlink and click on it" ,() -> {
            mainPage.navigateToCareerPage();
        });
        step("Check People Beeline page opened" ,() -> {
            mainPage.checkCareerPage();
        });
    }

    @Test
    @Tag("Beeline")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz")
    @DisplayName("Check that user opens People Page from Main and search for QA Automation engineer")
    void searchQAPositionTest(){
        step("open Beeline KZ page" ,() -> {
            mainPage.openPage();
        });
        step("Switch Main Page to RU language" ,() -> {
            mainPage.setLanguage("Рус");
        });
        step("Open the People Beeline page" ,() -> {
            mainPage.navigateToCareerPage();
        });
        step("Search the QA Automation engineer" ,() -> {
            mainPage.searchPosition("QA Automation engineer");
        });
        step("Check the existence of the position and click on it" ,() -> {
            mainPage.navigateToPositionDetails("QA Automation engineer");
        });
        step("Check the title of position" ,() -> {
            mainPage.checkPositionName("QA Automation engineer");
        });
    }

}
