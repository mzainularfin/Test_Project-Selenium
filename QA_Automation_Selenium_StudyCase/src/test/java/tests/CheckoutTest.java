package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckoutTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    // Helper untuk delay manual
    private void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkoutFlow() {
        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        pause(1);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        pause(1);
        driver.findElement(By.id("login-button")).click();
        pause(1);

        // Tambah barang ke cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        pause(2);
        driver.findElement(By.className("shopping_cart_link")).click();
        pause(2);

        // Checkout
        driver.findElement(By.id("checkout")).click();
        pause(2);
        driver.findElement(By.id("first-name")).sendKeys("Zainul");
        pause(1);
        driver.findElement(By.id("last-name")).sendKeys("Arifin");
        pause(1);
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        pause(1);
        driver.findElement(By.id("continue")).click();
        pause(2);
        driver.findElement(By.id("finish")).click();
        pause(2);

        // Verifikasi
        WebElement successMsg = driver.findElement(By.className("complete-header"));
        Assert.assertTrue(successMsg.getText().contains("Thank you for your order!"));

        pause(3); // jeda terakhir biar kelihatan hasilnya
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}