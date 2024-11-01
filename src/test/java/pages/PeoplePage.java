package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PeoplePage {

    private final SelenideElement
            searchPositionInput = $("input.main-search-page"),
            searchPositionButton = $(".btn-search-main");

    public PeoplePage openPeoplePage() {
        open("https://people.beeline.kz/");
        return this;
    }

    public PeoplePage navigateToPositionDetails(String positionTitle) {
        $("div.list-item_hr .job-title")
                .shouldHave(text(positionTitle));
        $("div.list-item_hr .job-title").click();
        return this;
    }

    public PeoplePage searchPosition(String position) {
        searchPositionInput.setValue(position);
        searchPositionButton.click();
        return this;
    }

    public PeoplePage checkPositionName(String positionName) {
        $(".H-title-for-pages-hr span")
                .shouldHave(text(positionName));
        return this;
    }
}
