package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By emailField = By.id("identifierId");
    By nextButton = By.xpath("//span[text()='Next']");
    By passwordField = By.name("password");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(nextButton).click();
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(nextButton).click();
    }
}
