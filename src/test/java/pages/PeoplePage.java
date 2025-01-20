package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PeoplePage {

    private SelenideElement
            searchPositionInput = $("input.main-search-page"),
            searchPositionButton = $(".btn-search-main"),
            titleInput = $("div[data-container] span"),
            jobTitleInput = $("div.list-item_hr .job-title"),
            jobTitleDetailInput = $(".H-title-for-pages-hr span"),
            itAndBigDataLink = $("[data-link][href='/ITBigData']"),
            internshipLink = $("[data-link][href='/Students']"),
            beginnersLink = $("[data-link][href='/Beginners']"),
            allPositionsButton = $("button.btn-blocks-hr[data-button]");


    private ElementsCollection dropdownLocator = $$("div.dropdown-container");


    public PeoplePage openPeoplePage() {
        open("/");
        return this;
    }

    public PeoplePage checkCareerPage() {
        titleInput.shouldHave(Condition.text("Открой себя с яркой стороны!"));
        return this;
    }

    public PeoplePage checkPositionTitle(String positionTitle) {
        jobTitleInput.shouldHave(text(positionTitle));
        return this;
    }

    public PeoplePage navigateToPositionDetails(String positionTitle) {
        jobTitleInput.click();
        return this;
    }

    public PeoplePage navigateToInternshipPage() {
        internshipLink.click();
        return this;
    }

    public PeoplePage navigateToBeginnersPage() {
        beginnersLink.click();
        return this;
    }

    public PeoplePage searchPosition(String position) {
        searchPositionInput.setValue(position);
        searchPositionButton.click();
        return this;
    }

    public PeoplePage checkPositionDetails(String positionName) {
        jobTitleDetailInput.shouldHave(text(positionName));
        return this;
    }

    public PeoplePage navigateToITAndBigDataSection() {
        itAndBigDataLink.click();
        return this;
    }

    public PeoplePage navigateToAllPositionsButton() {
        allPositionsButton.click();
        return this;
    }

    public PeoplePage selectDropdownOptionByName(String dropdownName, String filterOptionText) {
        SelenideElement targetDropdown = dropdownLocator.findBy(Condition.text(dropdownName))
                .$("select.dropdown-display");
        targetDropdown.click();
        targetDropdown.selectOption(filterOptionText);
        return this;
    }
}
