package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import configs.web.WebDriverConfig;
import configs.WebDriverProvider;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    private static WebDriverConfig config;

    @BeforeAll
    static void setUp() {
        config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        WebDriverProvider webConfig = new WebDriverProvider(config);
        webConfig.setUp();
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    protected void tearDown() {
        if (System.getProperty("remote") != null) {
            Attach.screenshotAs("Last Screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        }
        Selenide.closeWebDriver();
    }
}