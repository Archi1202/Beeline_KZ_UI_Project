package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BeginnersPage {

    SelenideElement mainTitle = $("div#b1-firstscreen span.H-title-for-pages-hr");

    public BeginnersPage checkMainTitle(String title) {
        mainTitle.shouldHave(text(title));
        return this;
    }

}
