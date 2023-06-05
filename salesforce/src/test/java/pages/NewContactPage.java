package pages;

import elements.DropDown;
import elements.InputField;
import model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewContactPage extends BasePage {
    public NewContactPage(WebDriver driver) {
        super(driver);
    }

    public static final String SAVE_BUTTON = "//button[@name='SaveEdit']";
    private static final String DROP_DOWN_FIELD = "//input[@placeholder='Search Accounts...']";
    private static final String ACCOUNT_NAME = "//span[@title='AccountAQA']";

    public NewContactPage openNewContactPage() {
        driver.get("https://d8e000000risnea4.lightning.force.com/lightning/o/Contact/new");
        return this;
    }

    public void createNewContact(Contact contact) {
        new InputField(driver, "First Name").writeText(contact.getFirstName());
        new InputField(driver, "Last Name").writeText(contact.getLastName());
        new DropDown(driver, "Salutation").selectContactOption(contact.getSalutation());
        driver.findElement(By.xpath(DROP_DOWN_FIELD)).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ACCOUNT_NAME)))).click();
        driver.findElement(By.xpath(SAVE_BUTTON)).click();

    }
}
