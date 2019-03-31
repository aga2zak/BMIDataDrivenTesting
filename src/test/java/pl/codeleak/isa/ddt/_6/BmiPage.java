package pl.codeleak.isa.ddt._6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

// TODO Implement the page
class BmiPage {

    RemoteWebDriver driver;

    BmiPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    void navigateTo() {
        driver.get("http://bmi-online.pl/");
    }

    BmiResultPage submit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type=submit]"));
        submit.click();
        return new BmiResultPage(driver);
    }

    List<String> submitExpectingErrors() {
        WebElement submit = driver.findElement(By.cssSelector("button[type=submit]"));
        submit.click();
        return getFormErrors();
    }

    private List<String> getFormErrors() {
        List<WebElement> errorElements = driver.findElements(By.cssSelector(".error-text-std"));
        return errorElements.stream()
                .map(webElement -> webElement.getText())
                .collect(Collectors.toList());
    }

    public void acceptCookies() {
        WebElement cookieOverlay = driver.findElement(By.cssSelector(".t-a-c__overlay"));
        WebElement acceptCookiesButton = driver.findElement(By.cssSelector(".t-a-c__box__btn"));
        acceptCookiesButton.click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.invisibilityOf(cookieOverlay));
    }

    public void setBmiForm(String weight, String height) {
        WebElement weightInput = driver.findElement(By.cssSelector("input[name=weight]"));
        weightInput.clear();
        weightInput.sendKeys(weight);
        WebElement heightInput = driver.findElement(By.cssSelector("input[name=height]"));
        heightInput.clear();
        heightInput.sendKeys(height);
    }
}
