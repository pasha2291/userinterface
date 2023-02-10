package by.a1qa.userinterface.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import by.a1qa.userinterface.enums.Domain;
import org.openqa.selenium.By;

public class LogInPage extends Form {
    private static final String DOMAIN_DYNAMIC_LOCATOR = "//div[contains(text(), '%s')]";
    private static final By LOGIN_FORM_LOCATOR = By.xpath("//div[@class = 'login-form']");
    private static final By HIDE_HELP_FORM_BUTTON_LOCATOR = By.xpath("//button[contains(@class, 'send-to-bottom')]");
    private static final By COOKIES_FORM_LOCATOR = By.xpath("//div[contains(@class, 'cookies')]");
    private static final By ACCEPT_COOKIES_BUTTON_LOCATOR = By.xpath("//button[contains(text(), 'Not')]");
    private static final By ZERO_TIMER_LABEL_LOCATOR = By.xpath("//div[contains(@class, 'timer') and contains(text(), '00:00:00')]");
    private static final By PASSWORD_INPUT_FIELD_LOCATOR = By.xpath("//input[contains(@placeholder, 'Password')]");
    private static final By EMAIL_INPUT_FIELD_LOCATOR = By.xpath("//input[contains(@placeholder, 'email')]");
    private static final By DOMAIN_INPUT_FIELD_LOCATOR = By.xpath("//input[contains(@placeholder, 'Domain')]");
    private static final By DROPDOWN_DOMAIN_FIELD_LOCATOR = By.xpath("//div[contains(@class, 'dropdown__field')]");
    private static final By ACCEPT_POLICY_CHECKBOX_LOCATOR = By.xpath("//span[contains(@class, 'checkbox__box')]");
    private static final By NEXT_BUTTON_LOCATOR = By.xpath("//a[contains(text(), 'Next')]");
    private final IButton HIDE_HELP_FORM_BUTTON = getElementFactory().getButton(HIDE_HELP_FORM_BUTTON_LOCATOR, "Hide help form button");
    private final ILabel COOKIES_LABEL = getElementFactory().getLabel(COOKIES_FORM_LOCATOR, "Cookies form");

    public LogInPage() {
        super(LOGIN_FORM_LOCATOR, "Login form");
    }

    public void hideHelpForm() {
        HIDE_HELP_FORM_BUTTON.click();
        AqualityServices.getConditionalWait().waitFor(() -> !HIDE_HELP_FORM_BUTTON.state().isDisplayed());
    }

    public boolean isHelpFormDisplayed() {
        return getElementFactory().getButton(HIDE_HELP_FORM_BUTTON_LOCATOR, "Hide help form button").state().isDisplayed();
    }

    public void acceptCookies() {
        AqualityServices.getConditionalWait().waitFor(() -> COOKIES_LABEL.state().isDisplayed());
        getElementFactory().getButton(ACCEPT_COOKIES_BUTTON_LOCATOR, "Accept cookies button").click();
    }

    public boolean isCookiesFormDisplayed(){
        return COOKIES_LABEL.state().isDisplayed();
    }

    public boolean isTimerStartsFromZero() {
        return getElementFactory().getLabel(ZERO_TIMER_LABEL_LOCATOR, "Timer label with zeros").state().isDisplayed();
    }

    public void fillAndSubmitSignInFormWithCredentials(String email, String password, String domain,
                                                       Domain dropdownBoxDomain) {
        getElementFactory().getTextBox(EMAIL_INPUT_FIELD_LOCATOR, "Email field").clearAndType(email);
        getElementFactory().getTextBox(PASSWORD_INPUT_FIELD_LOCATOR, "Password field").clearAndType(password);
        getElementFactory().getTextBox(DOMAIN_INPUT_FIELD_LOCATOR, "Domain field").clearAndType(domain);
        getElementFactory().getButton(DROPDOWN_DOMAIN_FIELD_LOCATOR, "Dropdown domain menu").click();
        getElementFactory().getButton(By.xpath(String.format(DOMAIN_DYNAMIC_LOCATOR, dropdownBoxDomain)),
                "Dropdown domain element").click();
        getElementFactory().getButton(ACCEPT_POLICY_CHECKBOX_LOCATOR, "Accept policy checkBox").click();
        getElementFactory().getButton(NEXT_BUTTON_LOCATOR, "Next button locator").click();
    }
}
