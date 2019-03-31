package pl.codeleak.isa.ddt._6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

// Implement the result page
class BmiResultPage {

    private RemoteWebDriver driver;

    BmiResultPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    String getBmiValue() {
        WebElement resultEl = driver.findElement(By.cssSelector(".result-v1__title > strong:nth-child(1)"));
        return resultEl.getText();
    }
}
