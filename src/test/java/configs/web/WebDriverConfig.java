package configs.web;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({"classpath:properties/${env}.properties", "classpath:properties/local.properties"})

public interface WebDriverConfig extends Config{
    @Key("baseUrl")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("browserVersion")
    @DefaultValue("125.0")
    String getBrowserVersion();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();

    @Key("remoteUrl")
    String getRemoteUrl();
}
