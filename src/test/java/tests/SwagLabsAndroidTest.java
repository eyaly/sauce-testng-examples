package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import listeners.BaseTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.SwagLabsPage;

import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

//import pages.android.SwagLabsPage;


/**
 * Created by mehmetgerceker on 12/7/15.
 */

public class SwagLabsAndroidTest extends BaseTestListener {

    /**
     * Runs a simple test verifying if the comment input is functional.
     * @throws InvalidElementStateException
     */
    @Test(groups = { "@SwagLabsAndroid" })
    public void loginToSwagLabsTestValid()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        System.out.println("*** Sauce - start test loginToSwagLabsTestValid " );

        AppiumDriver driver = (AppiumDriver)this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;

        page = new SwagLabsPage(driver);

          // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation 
        Assert.assertTrue(page.isOnProductsPage());
    }

    @Test(groups = { "@SwagLabsAndroidInstall" })
    public void installAPPs(){
        System.out.println("*** Sauce - start test installAPPs " );

        AndroidDriver driver = (AndroidDriver)this.getDriver();

        driver.context("NATIVE_APP");

        String usernameID = "test-Username";
        WebElement usernameEdit = (WebElement) driver.findElementByAccessibilityId(usernameID);
        usernameEdit.click();
        usernameEdit.sendKeys("standard_user");

        driver.installApp("https://github.com/saucelabs-training/demo-java/blob/master/appium-example/resources/android/GuineaPigApp-debug.apk?raw=true");
        //driver.installApp("storage:filename=Android.SauceLabs.Mobile.Sample.app.2.3.0.apk");
        boolean isInstalled = driver.isAppInstalled("com.swaglabsmobileapp");
        System.out.println("*** Sauce - Sawg App installed: " + isInstalled);

        isInstalled = driver.isAppInstalled("com.saucelabs.guineapig");
        System.out.println("*** Sauce - guineapig  App installed: " + isInstalled);

        driver.startActivity(new Activity("com.saucelabs.guineapig", ".Activities.MainActivity"));

        By commentsTextInput = By.id("comments");
        driver.findElement(commentsTextInput).click();
        driver.findElement(commentsTextInput).sendKeys("Sauce");
        driver.hideKeyboard();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(groups = { "@android-app-upgrades" })
    public void testSavedTextAfterUpgrade() {
        // Based on https://appiumpro.com/editions/9-testing-android-app-upgrades
        System.out.println("*** Sauce - start test testSavedTextAfterUpgrade ");

        // **** parameters
        String APP_PKG = "io.cloudgrey.the_app";
        String APP_ACT = "com.theapp.MainActivity";

        String APP_V1_0_0 = "https://github.com/cloudgrey-io/the-app/releases/download/v1.0.0/TheApp-v1.0.0.apk?raw=true";
        String APP_V1_0_1 = "https://github.com/cloudgrey-io/the-app/releases/download/v1.0.1/TheApp-v1.0.1.apk";
        String APP_V1_0_2 = "https://github.com/cloudgrey-io/the-app/releases/download/v1.0.2/TheApp-v1.0.2.apk?raw=true";


        String TEST_MESSAGE = "Hello World";

        By msgInput = MobileBy.AccessibilityId("messageInput");
        By savedMsg = MobileBy.AccessibilityId(TEST_MESSAGE);
        By saveMsgBtn = MobileBy.AccessibilityId("messageSaveBtn");
        By echoBox = MobileBy.AccessibilityId("Echo Box");

        String appUpgradeVersion = APP_V1_0_0;

        // **** parameters END

        AndroidDriver driver = (AndroidDriver) this.getDriver();
        driver.context("NATIVE_APP");

        driver.installApp(appUpgradeVersion);
        Activity activity = new Activity(APP_PKG, APP_ACT);
        driver.startActivity(activity);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.presenceOfElementLocated(echoBox)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(msgInput)).sendKeys(TEST_MESSAGE);
        wait.until(ExpectedConditions.presenceOfElementLocated(saveMsgBtn)).click();
        String savedText = wait.until(ExpectedConditions.presenceOfElementLocated(savedMsg)).getText();
        Assert.assertEquals(savedText, TEST_MESSAGE);

        appUpgradeVersion = APP_V1_0_2;
        driver.installApp(appUpgradeVersion);
        //Activity activity = new Activity(APP_PKG, APP_ACT);
        driver.startActivity(activity);

        wait.until(ExpectedConditions.presenceOfElementLocated(echoBox)).click();
        savedText = wait.until(ExpectedConditions.presenceOfElementLocated(savedMsg)).getText();
        Assert.assertEquals(savedText, TEST_MESSAGE);
    }

    @Test(groups = { "@SwagLabsAndroid" })
    public void loginToSwagLabsTestValid2()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        System.out.println("*** Sauce - start test loginToSwagLabsTestValid " );

        AppiumDriver driver = (AppiumDriver)this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;

        page = new SwagLabsPage(driver);

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }

    @Test(groups = { "@webAndroid" })
    public void webTestAndroid()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException, InterruptedException {

        System.out.println("*** Sauce - start test loginToSwagLabsTestValid " );

        AppiumDriver driver = (AppiumDriver)this.getDriver();
        String type = this.getDriverType().toLowerCase();

        Thread.sleep(10000);

    }

}