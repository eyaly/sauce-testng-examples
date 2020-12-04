package tests;

import io.appium.java_client.AppiumDriver;
import listeners.BaseTestListener;
import org.openqa.selenium.InvalidElementStateException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.GuineaPigPage;

import java.net.MalformedURLException;
import java.rmi.UnexpectedException;
import java.util.UUID;


/**
 * Created by mehmetgerceker on 12/7/15.
 */

public class GuineaPigTest extends BaseTestListener {

    /**
     * Runs a simple test verifying if the comment input is functional.
     * @throws InvalidElementStateException
     */
    @Test(groups = { "@GuineaPig" })
    public void verifyCommentInputTest()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        AppiumDriver driver = (AppiumDriver)this.getDriver();
      //  System.out.println("Sauce - Device name: " + driver.getCapabilities().getCapability("testobject_device"));
        String type = this.getDriverType().toLowerCase();

        String commentInputText = UUID.randomUUID().toString();

        GuineaPigPage page = new GuineaPigPage(driver);

        page.submitComment(commentInputText);

        Assert.assertTrue(page.getSubmittedCommentText().contains(commentInputText));
    }

}