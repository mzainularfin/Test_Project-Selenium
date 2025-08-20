package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // locator
    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginBtn = By.id("login-button");
    By errorMsg = By.cssSelector("h3[data-test='error']");

    // constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // implementasi login
    public void login(String username, String password) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public String getErrorMsg() {
        return driver.findElement(errorMsg).getText();
    }
}