package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PeoplePage {

    private final SelenideElement
            searchPositionInput = $("input.main-search-page"),
            searchPositionButton = $(".btn-search-main"),
            titleInput = $("div[data-container] span"),
            jobTitleInput = $("div.list-item_hr .job-title"),
            jobTitleDetailInput = $(".H-title-for-pages-hr span"),
            itAndBigDataLink = $("[data-link][href='/ITBigData']"),
            internshipLink = $("[data-link][href='/Students']"),
            beginnersLink = $("[data-link][href='/Beginners']"),
            allPositionsButton = $("button.btn-blocks-hr[data-button]");


    private final ElementsCollection dropdownLocator = $$("div.dropdown-container");

    @Step("Open the People Beeline page")
    public PeoplePage openPeoplePage() {
        open("https://people.beeline.kz/");
        return this;
    }

    @Step("Check that Beeline People page displayed for user")
    public PeoplePage checkCareerPage() {
        titleInput.shouldHave(Condition.text("Открой себя с яркой стороны!"));
        return this;
    }

    @Step("Check the existence of the position {positionTitle}")
    public PeoplePage checkPositionTitle(String positionTitle) {
        jobTitleInput.shouldHave(text(positionTitle));
        return this;
    }

    @Step("Click on the position title to open detailed page")
    public PeoplePage navigateToPositionDetails(String positionTitle) {
        jobTitleInput.click();
        return this;
    }

    @Step("Navigate to Internship section")
    public PeoplePage navigateToInternshipPage() {
        internshipLink.click();
        return this;
    }

    @Step("Navigate to Beginners section")
    public PeoplePage navigateToBeginnersPage() {
        beginnersLink.click();
        return this;
    }

    @Step("Execute search of the position {position}")
    public PeoplePage searchPosition(String position) {
        searchPositionInput.setValue(position);
        searchPositionButton.click();
        return this;
    }

    @Step("Check the existence of the position - {positionName}")
    public PeoplePage checkPositionDetails(String positionName) {
        jobTitleDetailInput.shouldHave(text(positionName));
        return this;
    }

    @Step("Navigate to IT and Big Data section")
    public PeoplePage navigateToITAndBigDataSection() {
        itAndBigDataLink.click();
        return this;
    }

    public PeoplePage navigateToAllPositionsButton() {
        allPositionsButton.click();
        return this;
    }

    @Step("Select dropdown {dropdownName} AND filter {filterOptionText}")
    public PeoplePage selectDropdownOptionByName(String dropdownName, String filterOptionText) {
        SelenideElement targetDropdown = dropdownLocator.findBy(Condition.text(dropdownName))
                .$("select.dropdown-display");
        targetDropdown.click();
        targetDropdown.selectOption(filterOptionText);
        return this;
    }
}
