package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BeginnersPage {

    SelenideElement mainTitleLocator = $("div#b1-firstscreen span.H-title-for-pages-hr"),
            beginCareerButton = $("button.btn-search-main.OSFillParent"),
            moreInCareerButton = $("button.btn-search-exp-itbig"),
            secondaryTextLocator = $("div[data-container] span[style*='color: rgb(168, 166, 179)']");

    @Step("Check that Main Title in Internship has text {title}")
    public BeginnersPage checkMainTitle(String title) {
        mainTitleLocator.shouldHave(text(title));
        return this;
    }

    @Step("Click on the Begin Career Button")
    public BeginnersPage clickBeginCareer() {
        beginCareerButton.click();
        return this;
    }

    @Step("Click on the 'More' button")
    public BeginnersPage clickMoreButtonInCareer() {
        moreInCareerButton.click();
        return this;
    }

    @Step("Check additional text on Title - {secondaryText}")
    public BeginnersPage verifyTextPage(String secondaryText) {
        secondaryTextLocator.shouldHave(text(secondaryText));
        return this;
    }

}
