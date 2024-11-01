package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement
        languageInput = $("select.language__picker"),
        cityInput = $("select.regions-select"),
        whatsUpButton = $(".svg-whatsapp"),
        telegramButton = $(".svg-telegram"),
        careerPageLink = $("ul[data-test='footer_list-group'] a[href='https://people.beeline.kz/']"),
        searchPositionInput = $("input.main-search-page"),
        searchPositionButton = $(".btn-search-main");

    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage checkWhatsUpButton() {
        whatsUpButton.shouldBe(visible);
        return this;
    }
    public MainPage checkTelegramButton() {
        telegramButton.shouldBe(Condition.visible);
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

    public MainPage checkCareerSection(){
        $$("a").findBy(text("Вакансии и карьера в Beeline"))
                .shouldBe(visible);
        return this;
    }

    public MainPage navigateToCareerPage(){
        $$("a").find(Condition.text("Вакансии и карьера в Beeline"))
                .shouldBe(visible);
        careerPageLink.click();
        return this;
    }


    public MainPage searchPosition(String position){
        searchPositionInput.setValue(position);
        searchPositionButton.click();
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
}
