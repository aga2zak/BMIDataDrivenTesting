package pl.codeleak.isa.ddt._6;

import org.openqa.selenium.remote.RemoteWebDriver;

// TODO Implement the page
class BmiPage {

    RemoteWebDriver driver;

    BmiPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    void navigateTo() {

    }

    BmiResultPage submit() {
        return new BmiResultPage(driver);
    }
}
