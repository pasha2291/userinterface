package by.a1qa.userinterface.test;

import by.a1qa.userinterface.config.ConfigManager;
import by.a1qa.userinterface.enums.Domain;
import by.a1qa.userinterface.pages.InterestsPage;
import by.a1qa.userinterface.pages.LogInPage;
import by.a1qa.userinterface.pages.PersonalDetailsPage;
import by.a1qa.userinterface.pages.WelcomePage;
import by.a1qa.userinterface.utils.RandomItemUtil;
import by.a1qa.userinterface.utils.RandomStringUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseOne extends BaseTest {

    @Test
    public void runTest() {
        WelcomePage welcomePage = new WelcomePage();
        Assert.assertTrue(welcomePage.state().isDisplayed(), "Welcome page is not opened!");
        welcomePage.goToNextPage();

        LogInPage logInPage = new LogInPage();
        Assert.assertTrue(logInPage.state().isDisplayed(), "Log in page is not opened!");

        String email = RandomStringUtil.getRandomEmail();
        String password = RandomStringUtil.getRandomPassword(email);
        String domain = RandomStringUtil.getRandomDomain();
        Domain dropdownBoxDomain = RandomItemUtil.getRandomDomain();
        logInPage.fillAndSubmitSignInFormWithCredentials(email, password, domain, dropdownBoxDomain);

        InterestsPage interestsPage = new InterestsPage();
        Assert.assertTrue(interestsPage.state().isDisplayed(), "Interests page is not opened!");

        interestsPage.unselectAllButtonClick();
        interestsPage.uploadButtonClick();
        interestsPage.selectInterests(RandomItemUtil.getRandomInterests(ConfigManager.getInterestQuantity()));
        interestsPage.uploadAvatar(ConfigManager.getAvatarPath());
        interestsPage.nextButtonClick();

        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        Assert.assertTrue(personalDetailsPage.state().isDisplayed(), "Personal details page is not opened!");
    }
}
