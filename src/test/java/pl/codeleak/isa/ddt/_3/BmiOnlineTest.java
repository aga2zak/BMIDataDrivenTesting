package pl.codeleak.isa.ddt._3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

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
        driver.get("http://bmi-online.pl/");

        // TODO Get overlay
        WebElement cookieOverlay = driver.findElement(By.cssSelector(".t-a-c__overlay"));

        // TODO Accept cookies
        WebElement acceptCookiesButton = driver.findElement(By.cssSelector(".t-a-c__box__btn"));
        acceptCookiesButton.click();

        // TODO Wait for overlay to be invisible
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.invisibilityOf(cookieOverlay));

        // TODO Set bmi form
        WebElement weightInput = driver.findElement(By.cssSelector("input[name=weight]"));
        weightInput.clear();
        weightInput.sendKeys("76");

        WebElement heightInput = driver.findElement(By.cssSelector("input[name=height]"));
        heightInput.clear();
        heightInput.sendKeys("176");

        // TODO Submit the form and get bmi result page
        WebElement submit = driver.findElement(By.cssSelector("button[type=submit]"));
        submit.click();

        // TODO Assert value
        WebElement resultEl = driver.findElement(By.cssSelector(".result-v1__title > strong:nth-child(1)"));

        assertThat(resultEl.getText()).isEqualTo("24.54");
    }
}
