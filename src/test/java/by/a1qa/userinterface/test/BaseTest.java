package by.a1qa.userinterface.test;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import by.a1qa.userinterface.config.ConfigManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    private Browser browser;

    @BeforeMethod
    public void initializeTestScenario() {
        browser = AqualityServices.getBrowser();
        browser.maximize();
        browser.goTo(ConfigManager.getURL());
    }

    @AfterMethod
    public void finalizeTestScenario(){
        browser.quit();
    }
}
