import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

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

    @AfterMethod
    public void logOut() {
        clickOnElement(logOutButton);
    }

    @Test
    public void registerUserTestbyMessage() {
        clickOnElement(registrationButton);

        typeIn(firstName, "firstName");
        typeIn(lastName, "lastName");
        typeIn(email, "lkergregg@fhg.aaa");
        typeIn(password, "password");
        typeIn(confirmPassword, "password");
        clickOnElement(registerButton);

        String actualMessage = getTextFromElement(message);
        String expectedMessage = "Your registration completed";
        Assert.assertTrue(actualMessage.equals(expectedMessage), "Expected text is not equal to " + actualMessage);

    }

    @Test
    public void registerUserTestbyLogOutText() {
        clickOnElement(registrationButton);

        typeIn(firstName, "firstName");
        typeIn(lastName, "lastName");
        typeIn(email, "mnreefgvc@fhg.aaa");
        typeIn(password, "password");
        typeIn(confirmPassword, "password");
        clickOnElement(registerButton);

        String actualLogOutText = getTextFromElement(logOutButton);
        String expectedLogOutText = "Log out";
        Assert.assertTrue(actualLogOutText.equals(expectedLogOutText), "Expected text is not equal to " + actualLogOutText);

    }

}
