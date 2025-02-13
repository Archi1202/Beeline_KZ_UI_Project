package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class InternshipPage {

    final SelenideElement
            allPositionsButton = $(".btn-search-main");
    final SelenideElement frequentQuestionsLocator = $("div#b1-answer div.H-title-for-pages-hr span");
    final SelenideElement bottomHeaderQuestionsLocator = $("div.last_blocks_student span.H-title-for-pages-hr");
    final SelenideElement bottomAskQuestionButton = $("div.last_blocks_student button.btn-blocks-hr");

    final ElementsCollection
            questionsCollection = $$("div.card-arrow");
    final ElementsCollection answersCollection = $$("div.hidden.answer-container");
    final ElementsCollection jobTitles = $$(".job-title");

    @Step("Click on the 'All Positions' button")
    public InternshipPage searchAllPosition() {
        allPositionsButton.click();
        return this;
    }

    @Step("Check that position has word {positionTitle} in title")
    public InternshipPage verifyPositionsWithInternship(String positionTitle) {
        jobTitles
                .filterBy(text(positionTitle))
                .forEach(title -> title.shouldBe(visible));
        return this;
    }

    @Step("Check that title of the bottom section has text {frequentQuestions}")
    public InternshipPage verifyTextForFrequentQuestions(String frequentQuestions) {
        frequentQuestionsLocator.shouldBe(visible)
                .shouldHave(text(frequentQuestions));
        return this;
    }

    @Step("Check that there is a question {questionText} and click on it")
    public InternshipPage clickOnQuestionFromList(String questionText) {
        questionsCollection
                .findBy(text(questionText))
                .click();
        return this;
    }

    @Step("Verify that answer was expanded and displayed for user")
    public InternshipPage verifyDisplayedAnswer(String expectedAnswer) {
        answersCollection
                .findBy(text(expectedAnswer))
                .shouldBe(visible);
        return this;
    }

    @Step("Verify that bottom section has relevant text {expectedText}")
    public InternshipPage verifyBottomQuestionText(String expectedText) {
        bottomHeaderQuestionsLocator.scrollTo()
                .shouldHave(text(expectedText))
                .shouldBe(visible);
        return this;
    }

    @Step("Verify that bottom section has button to communicate with support and has text {buttonText}")
    public InternshipPage verifyBottomQuestionButton(String buttonText) {
        bottomAskQuestionButton
                .shouldHave(text(buttonText))
                .shouldBe(visible);
        return this;
    }


}
