package pl.codeleak.isa.ddt._6;

import io.github.bonigarcia.wdm.WebDriverManager;
import junitparams.JUnitParamsRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

@RunWith(JUnitParamsRunner.class)
public class BmiOnlinePopTest {

    RemoteWebDriver driver;

    @BeforeClass
    public static void beforeAll() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void verifiesBmiValue() {
        // TODO Implement the test using pages
    }
}
