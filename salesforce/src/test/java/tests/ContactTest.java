package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import model.Contact;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewContactPage;

import java.util.concurrent.TimeUnit;

public class ContactTest {

    @Test
    public void createContact() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        User user = new User("https://d8e000000risnea4.lightning.force.com", "kosix67400-jwsp@force.com",
                "3333Yana!");
        driver.get(user.getUrl());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(user);
        NewContactPage newContactPage = new NewContactPage(driver);
        Contact contact = new Contact("Mr.", "James", "Smith");
        newContactPage.openNewContactPage()
                .createNewContact(contact);
        WebElement contactInfo = driver.findElement(By.xpath("//span[contains(text(), 'Mr. James Smith')]"));
        Assert.assertTrue(contactInfo.isDisplayed(), "New contact wasn't created.");
    }
}
