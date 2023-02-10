package by.a1qa.userinterface.pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class WelcomePage extends Form {
    private static final By WELCOME_TEXT_LABEL_LOCATOR = By.xpath("//p[contains(text(),'welcome')]");
    private static final By NEXT_PAGE_LINK_LOCATOR = By.xpath("//a[contains(text(),'HERE')]");

    public WelcomePage() {
        super(WELCOME_TEXT_LABEL_LOCATOR, "Welcome text label");
    }

    public void goToNextPage(){
        getElementFactory().getLink(NEXT_PAGE_LINK_LOCATOR, "next page link").click();
    }
}
