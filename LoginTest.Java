package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {
        test = extent.createTest("Valid Login Test");
        driver.get("https://www.saucedemo.com/");
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    public void invalidLogin() {
        test = extent.createTest("Invalid Login Test");
        driver.get("https://www.saucedemo.com/");
        LoginPage login = new LoginPage(driver);
        login.login("wrong_user", "wrong_pass");
        Assert.assertTrue(login.getErrorMsg().contains("Epic sadface"));
    }
}
