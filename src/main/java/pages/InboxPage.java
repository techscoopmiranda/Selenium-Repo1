package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InboxPage {
    WebDriver driver;

    By composeButton = By.xpath("//div[text()='Compose']");

    public InboxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCompose() {
        driver.findElement(composeButton).click();
    }
}
