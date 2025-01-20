package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ItAndBigDataPage {

    SelenideElement itOptionLocator = $(".tags-hr-button-itbigdata.item4");

    ElementsCollection jobItems = $$("[data-container].list-item_hr");



    public ItAndBigDataPage selectItOption() {
        itOptionLocator.click();
        return this;
    }

    public ItAndBigDataPage checkFilterInJobList(String filterName) {
        jobItems.findBy(text(filterName))
                .shouldBe(visible);
        return this;
    }

    public ItAndBigDataPage selectDropdownOptionAndValue(String option, String value) {
        SelenideElement
                targetDropdown =
                $$("div.dropdown-container").findBy(Condition.text(option))
                .$("select.dropdown-display");
        targetDropdown.click();
        targetDropdown.selectOption(value);
        return this;
    }
}
