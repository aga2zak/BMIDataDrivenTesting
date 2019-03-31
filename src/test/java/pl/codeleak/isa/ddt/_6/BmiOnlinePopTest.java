package pl.codeleak.isa.ddt._6;

import io.github.bonigarcia.wdm.WebDriverManager;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

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
    @FileParameters(value = "classpath:bmi.csv", mapper = CsvWithHeaderMapper.class)
    public void verifiesBmiValue(String weight, String height, String expectedResult) {
        BmiPage bmiPage = new BmiPage(driver);

        bmiPage.navigateTo();
        bmiPage.acceptCookies();
        bmiPage.setBmiForm(weight, height);
        BmiResultPage bmiResultPage = bmiPage.submit();

        assertThat(bmiResultPage.getBmiValue()).isEqualTo(expectedResult);
    }

    @Test
    public void expectsFormErrors() {
        BmiPage bmiPage = new BmiPage(driver);

        bmiPage.navigateTo();
        bmiPage.acceptCookies();
        bmiPage.setBmiForm("1", "1");

        List<String> errors = bmiPage.submitExpectingErrors();

        assertThat(errors).contains("Błędnie podany wzrost", "Błędnie podana waga");
    }
}
