package by.a1qa.userinterface.test;

import by.a1qa.userinterface.pages.LogInPage;
import by.a1qa.userinterface.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseFour extends BaseTest {
    @Test
    public void runTest() {
        WelcomePage welcomePage = new WelcomePage();
        Assert.assertTrue(welcomePage.state().isDisplayed(), "Welcome page is not opened!");
        welcomePage.goToNextPage();

        LogInPage logInPage = new LogInPage();
        Assert.assertTrue(logInPage.state().isDisplayed(), "Log in page is not opened!");

        Assert.assertTrue(logInPage.isTimerStartsFromZero(), "Timer does not start from 00:00:00!");
    }
}
