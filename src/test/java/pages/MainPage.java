package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement
        languageInput = $("select.language__picker"),
        cityInput = $("select.regions-select");



    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage checkOnlineShopText() {
        $$("#simple-content-main h2")
                .filterBy(text("Интернет-магазин"))
                .first()
                .shouldBe(Condition.visible);
        return this;
    }

    public MainPage setLanguage(String language){
        languageInput.selectOption(language);
        return this;
    }

    public MainPage setCity(String city){
        cityInput.selectOption(city);
        return this;
    }

    public MainPage navigateToCareerPage(){
        $$("a").find(Condition.text("Вакансии и карьера в Beeline"))
                .shouldBe(Condition.visible);
        $("ul[data-test='footer_list-group'] a[href='https://people.beeline.kz/']").click();
        return this;
    }


    public MainPage navigateToAddBalance(){
        $$("#box-1 .mobile__boxes-txt p").find(text("Пополнить баланс")).click();
        return this;
    }

    public MainPage searchPosition(String position){
        $("input.main-search-page").setValue(position);
        $(".btn-search-main").click();
        return this;
    }

    public MainPage navigateToPositionDetails(String positionTitle){
        $("div.list-item_hr .job-title")
                .shouldHave(text(positionTitle));
        $("div.list-item_hr .job-title").click();
        return this;
    }
    public MainPage checkPositionName(String positionName){
        $(".H-title-for-pages-hr span")
                .shouldHave(text(positionName));
        return this;
    }



    public MainPage checkCareerPage(){
        $("div[data-container] span").shouldHave(Condition.text("Открой себя с яркой стороны!"));
        return this;
    }

    public MainPage checkChangedLanguageText(){
        $("ul.c-menu-top__list a.c-menu-top__list-link--active").shouldHave(text("Для меня"));
        return this;
    }

    public MainPage checkAddBalancePage(){
        $("h1").shouldHave(text("Пополнение баланса"));
        return this;
    }


}
