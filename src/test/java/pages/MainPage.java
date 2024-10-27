package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final SelenideElement
        languageInput = $("select.language__picker"),
        cityInput = $("select.regions-select");



    public MainPage openPage() {
        open("/ru");
        return this;
    }

    public MainPage setLanguage(String language){
        languageInput.setValue(language);
        return this;
    }

    public MainPage setCity(String city){
        cityInput.setValue(city);
        return this;
    }

    public MainPage addBalance(){
        return this;
    }
}
