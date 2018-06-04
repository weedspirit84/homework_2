package assignment2.tests;


import assignment2.BaseScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static assignment2.utils.Properties.getBaseAdminUrl;

public class LoginTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getDriver();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
        driver = new ChromeDriver(capabilities);
        driver.get(getBaseAdminUrl());
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 100);
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/h1/img[@id='logo']")));
        WebElement loginField = driver.findElement(By.xpath("//div/input[@id=\'email\']"));
        loginField.sendKeys("webinar.test@gmail.com");
        WebElement passwordField = driver.findElement(By.xpath("//div/input[@id=\"passwd\"]"));
        passwordField.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement loginButton = driver.findElement(By.xpath("//div/button[@class=\"btn btn-primary btn-lg btn-block ladda-button\"]"));
        loginButton.click();
        WebElement userIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[@class=\"dropdown open\"]")));
        userIcon.click();
        WebElement logOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li/a[@id=\"header_logout\"]")));
        logOut.click();
        driver.quit();


        // WebDriver driver = getDriver();
        // ...
    }
}
