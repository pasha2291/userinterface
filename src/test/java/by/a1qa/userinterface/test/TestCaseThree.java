package by.a1qa.userinterface.test;

import by.a1qa.userinterface.pages.LogInPage;
import by.a1qa.userinterface.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseThree extends BaseTest {
    @Test
    public void runTest() {
        WelcomePage welcomePage = new WelcomePage();
        Assert.assertTrue(welcomePage.state().isDisplayed(), "Welcome page is not opened!");
        welcomePage.goToNextPage();

        LogInPage logInPage = new LogInPage();
        Assert.assertTrue(logInPage.state().isDisplayed(), "Log in page is not opened!");

        logInPage.acceptCookies();
        Assert.assertFalse(logInPage.isCookiesFormDisplayed(), "Cookies form is not closed!");
    }
}
