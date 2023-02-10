package by.a1qa.userinterface.pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonalDetailsPage extends Form {
    private static final By PERSONAL_DETAILS_FORM_LOCATOR = By.xpath("//div[@class='personal-details__form']");

    public PersonalDetailsPage() {
        super(PERSONAL_DETAILS_FORM_LOCATOR, "Personal details form");
    }
}
