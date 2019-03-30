package pl.codeleak.isa.ddt._3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class BmiOnlineTest {

    RemoteWebDriver driver;

    @BeforeClass
    public static void beforeAll() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setUp() throws Exception {
        // setup Firefox or Chrome driver
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        // quite the driver
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void verifiesBmiValueBasedOnFixedInputs() {

        // TODO Open bmi online page

        // TODO Get overlay

        // TODO Accept cookies

        // TODO Wait for overlay to be invisible

        // TODO Set bmi form

        // TODO Submit the form and get bmi result page

        // TODO Get bmi value (number only)

        // TODO Assert value

    }
}
