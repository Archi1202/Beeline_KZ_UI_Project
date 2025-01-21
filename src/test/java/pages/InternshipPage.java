package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class InternshipPage {

    SelenideElement
            checkAllPositionButton = $(".btn-search-main"),
            frequentQuestionsLocator = $("div#b1-answer div.H-title-for-pages-hr span");

    ElementsCollection
            questionsCollection = $$("div.card-arrow"),
            answersCollection = $$("div.hidden.answer-container"),
            jobTitles =  $$(".job-title");

    public InternshipPage searchAllPosition() {
        checkAllPositionButton.click();
        return this;
    }

    public InternshipPage verifyPositionsWithInternship(String positionTitle) {
        jobTitles
                .filterBy(text(positionTitle))
                .forEach(title -> title.shouldBe(visible));
        return this;
    }

    public InternshipPage verifyTextForFrequentQuestions(String frequentQuestions) {
        frequentQuestionsLocator.shouldBe(visible)
                .shouldHave(text(frequentQuestions));
        return this;
    }

    public InternshipPage clickOnQuestionFromList(String questionText) {
        questionsCollection
                .findBy(text(questionText))
                .click();
        return this;
    }

    public InternshipPage verifyDisplayedAnswer(String expectedAnswer) {
        answersCollection
                .findBy(text(expectedAnswer))
                .shouldBe(visible);
        return this;
    }
}
