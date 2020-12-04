package pages.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

public class GuineaPigPage {

    By theActiveLink = By.id("i_am_a_link");
    By yourComments = By.id("your_comments");
    By commentsTextInput = By.id("comments");
    By submitButton = By.id("submit");

    public AppiumDriver driver;

    public GuineaPigPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void submitComment(String text) {
        try {
            driver.findElement(commentsTextInput).click();
            driver.findElement(commentsTextInput).sendKeys(text);
            hideKeyboard();
            driver.findElement(submitButton).click();
        } catch (Exception e) {
            System.out.println("*** Problem: " + e.getMessage());
        }
    }

    public String getSubmittedCommentText() {
        return driver.findElement(yourComments).getText();
    }

    public void followLink() {
        driver.findElement(theActiveLink).click();
    }

    public boolean isOnPage() {
        try {
            getSubmittedCommentText();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    /**
     * This method only work for this page and assumes the app supports keyboard hide on click-away.
     */
    public void hideKeyboard() {

        driver.hideKeyboard();
    }
}
