package architype2test;

import net.serenitybdd.jbehave.SerenityStories;
import net.serenitybdd.jbehave.annotations.Metafilter;
import net.thucydides.core.webdriver.DriverConfiguration;

import javax.security.auth.login.Configuration;

import static net.thucydides.core.ThucydidesSystemProperty.WEBDRIVER_DRIVER;
import static net.thucydides.core.ThucydidesSystemProperty.WEBDRIVER_PROVIDED_TYPE;

//@Metafilter("+my")
public class AcceptanceTestSuite extends SerenityStories {
    private DriverConfiguration configuration;

    public AcceptanceTestSuite(){
        configuration = super.getSystemConfiguration();

        configuration.setIfUndefined(WEBDRIVER_DRIVER.getPropertyName(), "provided");
        configuration.setIfUndefined(WEBDRIVER_PROVIDED_TYPE.getPropertyName(), "mydriver");
        configuration.setIfUndefined("webdriver.provided.mydriver", "architype2test.divers.ChromeWemDriver");
    }
}
