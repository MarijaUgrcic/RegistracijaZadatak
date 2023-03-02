import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.Utils;

import javax.xml.xpath.XPath;

public class RegistrationTest extends BaseTest {

    By registrationButton = By.cssSelector("a[class='ico-register']");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By email = By.id("Email");
    By password = By.id("Password");
    By confirmPassword = By.id("ConfirmPassword");
    By registerButton = By.id("register-button");
    By logOutButton = By.cssSelector("a[class='ico-logout']");
    By message = By.cssSelector("div[class='result']");

    @Test
    public void registerUserTest() {
        clickOnElement(registrationButton);

        String randomMail = Utils.randomMail();
        System.out.println(randomMail);

        typeIn(firstName, "firstName");
        typeIn(lastName, "lastName");
        typeIn(email, randomMail);
        typeIn(password, "password");
        typeIn(confirmPassword, "password");
        clickOnElement(registerButton);

        String actualMessage = getTextFromElement(message);
        String expectedMessage = "Your registration completed";
        Assert.assertTrue(actualMessage.equals(expectedMessage), "Expected text is not equal to " + actualMessage);

        String actualLogOutText = getTextFromElement(logOutButton);
        String expectedLogOutText = "Log out";
        Assert.assertTrue(actualLogOutText.equals(expectedLogOutText), "Expected text is not equal to " + actualLogOutText);

    }
}
