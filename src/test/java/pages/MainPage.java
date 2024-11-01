package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement
        cityInput = $("select.regions-select"),
        selectedCity = $(".regions-select option[selected='selected']"),
        whatsUpButton = $(".svg-whatsapp"),
        telegramButton = $(".svg-telegram"),
        careerPageLink = $("ul[data-test='footer_list-group'] a[href='https://people.beeline.kz/']");

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
        careerPageLink.click();
        return this;
    }

    public MainPage checkChangedLocation(String location){
        selectedCity.shouldHave(text(location));
        return this;
    }
}
