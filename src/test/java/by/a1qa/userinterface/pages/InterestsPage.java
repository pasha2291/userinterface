package by.a1qa.userinterface.pages;

import aquality.selenium.forms.Form;
import by.a1qa.userinterface.utils.AvatarUploadUtils;
import by.a1qa.userinterface.enums.Interest;
import org.openqa.selenium.By;

import java.util.List;

public class InterestsPage extends Form {
    private static final By INTERESTS_FORM_LOCATOR = By.xpath("//div[contains(@class, 'interests__form')]");
    private static final String SELECT_BUTTON_DYNAMIC_LOCATOR = "//span[contains(text(), '%s')]//preceding-sibling::span";
    private static final By UPLOAD_BUTTON_LOCATOR = By.xpath("//a[contains(@class, 'upload-button')]");
    private static final By NEXT_BUTTON_LOCATOR = By.xpath("//button[contains(text(), 'Next')]");
    private static final String BUTTON = "%s button";

    public InterestsPage() {
        super(INTERESTS_FORM_LOCATOR, "Interests form");
    }

    public void unselectAllButtonClick() {
        getElementFactory().getButton(By.xpath(String.format(SELECT_BUTTON_DYNAMIC_LOCATOR, Interest.UNSELECT)),
                "Unselect all button").click();
    }

    public void selectInterests(List<Interest> interestsList) {
        for(Interest currentInterest : interestsList){
            selectInterest(currentInterest);
        }
    }

    private void selectInterest(Interest interest) {
        getElementFactory().getButton(By.xpath(String.format(SELECT_BUTTON_DYNAMIC_LOCATOR, interest)),
                String.format(BUTTON, interest)).click();
    }

    public void uploadButtonClick(){
        getElementFactory().getButton(UPLOAD_BUTTON_LOCATOR, "Upload button").click();
    }

    public void uploadAvatar(String avatarPath){
        AvatarUploadUtils.uploadAvatar(avatarPath);
    }

    public void nextButtonClick(){
        getElementFactory().getButton(NEXT_BUTTON_LOCATOR, "Next button").click();
    }
}
