package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;


public class InternshipPage {

    private SelenideElement
            checkAllPositionButton = $(".btn-search-main");

    public InternshipPage searchAllPosition() {
        checkAllPositionButton.click();
        return this;
    }

    public InternshipPage verifyPositionsWithInternship(String positionTitle){
            $$(".job-title")
                    .filterBy(text(positionTitle))
                    .forEach(title -> title.shouldBe(visible));
        return this;
    }
}
