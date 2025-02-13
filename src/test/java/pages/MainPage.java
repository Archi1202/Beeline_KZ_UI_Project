package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement
            cityInput = $("select.regions-select"),
            selectedCity = $(".regions-select option[selected='selected']"),
            whatsUpButton = $(".svg-whatsapp"),
            telegramButton = $(".svg-telegram"),
            careerPageLink = $("ul[data-test='footer_list-group'] a[href='https://people.beeline.kz/']"),
            searchButton = $("[data-test='header_svg-newsearch-icon']"),
            searchFieldSelector = $("input[data-test='header_search-input']"),
            articleSelector = $(".container.pt-3 .action__txt"),
            moreSelector = $(".c-menu-bottom-dropdown > .c-menu-bottom__list-link"),
            fraudSelector = $(".c-menu-bottom-dropdown__content-link[href*='fraud']");

    private final ElementsCollection
            listOfResultsSelector = $$("div.py-2.source-title a"),
            fraudQuestionsSelector = $$(".roaming_accordion_header"),
            fraudAnswersSelector = $$(".collapse.show .card-body p");

    @Step("Open Beeline KZ page")
    public MainPage openPage() {
        open("https://beeline.kz/ru");
        return this;
    }

    @Step("Click on Search button from the Main Page")
    public MainPage clickOnSearchButton() {
        searchButton.shouldBe(Condition.visible, Duration.ofSeconds(5));
        executeJavaScript("arguments[0].click();", searchButton);
        return this;
    }

    @Step("Insert value into the search field")
    public MainPage enterSearchValue(String value) {
        searchFieldSelector.setValue(value).pressEnter();
        return this;
    }


    @Step("Click on the first search result")
    public MainPage openFirstSearchResult() {
        listOfResultsSelector.first().click();
        return this;
    }

    @Step("Verify that article from search has text {0}")
    public MainPage verifyArticleFromSearch(String value) {
        articleSelector.shouldHave(text(value));
        return this;
    }

    @Step("Navigate to More section")
    public MainPage navigateToMoreSection() {
        moreSelector.hover();
        return this;
    }

    @Step("Click on the Fraud option")
    public MainPage clickOnFraudOption() {
        fraudSelector.click();
        return this;
    }

    @Step("Find question {0} and expand the answer")
    public MainPage findQuestionAndExpandIt(String question) {
        fraudQuestionsSelector.findBy(text(question)).click();
        return this;
    }

    @Step("Verify that answer was displayed for fraud question")
    public MainPage checkAnswerForFraud(String answerText) {
        fraudAnswersSelector.findBy(text(answerText))
                .shouldBe(visible);
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
        $$("a").findBy(text("Вакансии и карьера в Beeline")).shouldBe(visible);
        return this;
    }

    @Step("Click on the 'Вакансии и карьера в Beeline' link")
    public MainPage navigateToCareerPage() {
        careerPageLink.click();
        return this;
    }
}
