package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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

    @Step("Open Beeline KZ page")
    public MainPage openPage() {
        open("/");
        return this;
    }

    @Step("Check 'WhatsUp' button on the bottom section")
    public MainPage checkWhatsUpButton() {
        whatsUpButton.shouldBe(visible);
        return this;
    }

    @Step("Check 'Telegram' button on the bottom section")
    public MainPage checkTelegramButton() {
        telegramButton.shouldBe(Condition.visible);
        return this;
    }

    @Step("Switch location to {city}")
    public MainPage setCity(String city) {
        cityInput.selectOption(city);
        return this;
    }

    @Step("Check that location was selected to {location}")
    public MainPage checkChangedLocation(String location) {
        selectedCity.shouldHave(text(location));
        return this;
    }

    @Step("Check existence of the 'Вакансии и карьера в Beeline' on the bottom section of page")
    public MainPage checkCareerSection() {
        $$("a").findBy(text("Вакансии и карьера в Beeline"))
                .shouldBe(visible);
        return this;
    }

    @Step("Click on the 'Вакансии и карьера в Beeline' link")
    public MainPage navigateToCareerPage() {
        careerPageLink.click();
        return this;
    }
}
