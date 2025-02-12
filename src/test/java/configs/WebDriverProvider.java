package configs;

import com.codeborne.selenide.Configuration;
import configs.web.WebDriverConfig;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebDriverProvider {
    private final WebDriverConfig config;

    public WebDriverProvider(WebDriverConfig config) {
        this.config = config;
    }

    public void setUp() {
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browser = config.getBrowser().toString();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.pageLoadStrategy = "eager";

        if (config.isRemote()) {
            Configuration.remote = config.getRemoteUrl();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true

            ));
            Configuration.browserCapabilities = capabilities;
        }
    }
}
