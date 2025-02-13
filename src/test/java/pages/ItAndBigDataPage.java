package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ItAndBigDataPage {

    final SelenideElement itOptionLocator = $(".tags-hr-button-itbigdata.item4");

    final ElementsCollection jobItems = $$("[data-container].list-item_hr");

    @Step("Select option 'IT' from the available search filters")
    public ItAndBigDataPage selectItOption() {
        itOptionLocator.click();
        return this;
    }

    @Step("Get the list of job items and assert that at least one contains the label {filterName}")
    public ItAndBigDataPage checkFilterInJobList(String filterName) {
        jobItems.findBy(text(filterName))
                .shouldBe(visible);
        return this;
    }
}
