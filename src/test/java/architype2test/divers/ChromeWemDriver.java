package architype2test.divers;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeWemDriver implements DriverSource {
    private WebDriver driver;

    @Override
    public WebDriver newDriver() {
        if (driver == null){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-infobars", "--disable-extensions");
            driver = new ChromeDriver(options);
        }

        return driver;
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
