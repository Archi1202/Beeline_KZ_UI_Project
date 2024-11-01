package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.MainPage;

import java.util.Map;

import static io.qameta.allure.Allure.step;

public class TestBase {

    private final MainPage mainPage = new MainPage();


    @BeforeAll
    static void setUp(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://" + System.getProperty("login") + "@" + System.getProperty("remote");
        Configuration.timeout = 10000;
        Configuration.browser = System.getProperty("browserName","chrome");
        Configuration.browserSize = System.getProperty("browserSize");
        Configuration.browserVersion = System.getProperty("browserVersion");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    protected void doBeforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        step("Open Beeline KZ page" ,() -> {
            mainPage.openPage();
        });
    }


    @AfterEach
    protected void tearDown() {
        Attach.screenshotAs("Last Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}