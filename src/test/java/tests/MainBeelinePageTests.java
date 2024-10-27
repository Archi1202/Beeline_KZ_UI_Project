package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Feature("Beeline Kazakhstan Main Page")
@Owner("Anuar Zhangeldi")
@DisplayName("Check features on the Main Page")

public class MainBeelinePageTests {

    @Test
    @Tag("Beeline")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz/ru")
    @DisplayName("Check there is a Интернет-магазин on the Main Beeline Page")
    void checkOnlineShopTest(){
        //open Beeline KZ page
        open("https://beeline.kz/ru");
        //switch to RU language
        $("select.language__picker").selectOption("Рус");
        //Check existence of the Интернет-магазин
        $$("#simple-content-main h2")
                .filterBy(text("Интернет-магазин"))
                .first()
                .shouldBe(Condition.visible);
    }

    @Test
    @Tag("Beeline")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz")
    @DisplayName("Check that user is able to change the Language to RU and Location to Astana")
    void changeLocationAndLanguageTest(){
        open("https://beeline.kz/");
        $("select.language__picker").selectOption("Рус");
        $("select.regions-select").selectOption("Астана");
        $("ul.c-menu-top__list a.c-menu-top__list-link--active").shouldHave(text("Для меня"));
    }

    @Test
    @Tag("Beeline")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz")
    @DisplayName("Check that user is able click on the Add Balance button and redirect to that page")
    void addBalanceTest(){
        open("https://beeline.kz/");
        $("select.language__picker").selectOption("Рус");
        $$("#box-1 .mobile__boxes-txt p").find(text("Пополнить баланс")).click();
        $("h1").shouldHave(text("Пополнение баланса"));
    }

    @Test
    @Tag("Beeline")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz")
    @DisplayName("Check that user is able scroll down to the positions section and open People Page")
    void openPeoplePageTest(){
        open("https://beeline.kz/ru");
        $$("a").find(Condition.text("Вакансии и карьера в Beeline"))
                .shouldBe(Condition.visible);
        $("ul[data-test='footer_list-group'] a[href='https://people.beeline.kz/']").click();
        $("div[data-container] span").shouldHave(Condition.text("Открой себя с яркой стороны!"));
    }

    @Test
    @Tag("Beeline")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Beeline Kazakhstan Main page", url = "https://beeline.kz")
    @DisplayName("Check that user opens People Page from Main and search for QA Automation engineer")
    void searchQAPositionTest(){
        open("https://beeline.kz/ru");
        //Open the People Beeline page
        $("ul[data-test='footer_list-group'] a[href='https://people.beeline.kz/']").click();
        //Search the QA Automation engineer
        $("input.main-search-page").setValue("QA Automation engineer");
        $(".btn-search-main").click();
        //Check the existance of the position and click on it
        $("div.list-item_hr .job-title")
                .shouldHave(text("QA Automation engineer"));
        $("div.list-item_hr .job-title").click();
        //Check the title of QA position
        $(".H-title-for-pages-hr span")
                .shouldHave(text("QA Automation engineer"));
    }

}
