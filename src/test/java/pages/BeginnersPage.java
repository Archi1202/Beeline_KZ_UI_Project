package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BeginnersPage {

    SelenideElement mainTitleLocator = $("div#b1-firstscreen span.H-title-for-pages-hr"),
                    beginCareerButton = $("button.btn-search-main.OSFillParent"),
                    moreInCareerButton = $("button.btn-search-exp-itbig"),
                    secondaryTextLocator = $("div[data-container] span:nth-of-type(2)");

    public BeginnersPage checkMainTitle(String title) {
        mainTitleLocator.shouldHave(text(title));
        return this;
    }

    public BeginnersPage clickBeginCareer() {
        beginCareerButton.click();
        return this;
    }

    public BeginnersPage clickMoreButtonInCareer() {
        moreInCareerButton.click();
        return this;
    }

    public BeginnersPage verifyTextPage(String secondaryText) {
        secondaryTextLocator.shouldHave(text(secondaryText));
        return this;
    }

}
