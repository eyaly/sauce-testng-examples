package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import listeners.BaseTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ios.SwagLabsPage;

import java.net.MalformedURLException;
import java.rmi.UnexpectedException;
import java.util.HashMap;

//import pages.android.SwagLabsPage;


/**
 * Created by mehmetgerceker on 12/7/15.
 */

public class SwagLabsTest extends BaseTestListener {

    /**
     * Runs a simple test verifying if the comment input is functional.
     *
     * @throws InvalidElementStateException
     */
    @Test(groups = {"@SwagLabs1"})
    public void loginToSwagLabsTestValid()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //AppiumDriver driver = this.getiosDriver();
        AppiumDriver driver = (AppiumDriver) this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;
        if (type.equals("ios")) {
            page = new SwagLabsPage(driver);
        } else {  // for now - it is also ios page
            page = new SwagLabsPage(driver);
        }

        // tap on the username
        page.tapOnUsername();

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }

    @Test(groups = {"@SwagLabs1"})
    public void loginToSwagLabsTestValid2()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //AppiumDriver driver = this.getiosDriver();
        AppiumDriver driver = (AppiumDriver) this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;
        if (type.equals("ios")) {
            page = new SwagLabsPage(driver);
        } else {  // for now - it is also ios page
            page = new SwagLabsPage(driver);
        }

        // tap on the username
        page.tapOnUsername();

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }

    @Test(groups = {"@SwagLabs"})
    public void loginToSwagLabsTestValid3()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //AppiumDriver driver = this.getiosDriver();
        AppiumDriver driver = (AppiumDriver) this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;
        if (type.equals("ios")) {
            page = new SwagLabsPage(driver);
        } else {  // for now - it is also ios page
            page = new SwagLabsPage(driver);
        }

        // tap on the username
        page.tapOnUsername();

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }

    @Test(groups = {"@SwagLabs"})
    public void loginToSwagLabsTestValid4()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //AppiumDriver driver = this.getiosDriver();
        AppiumDriver driver = (AppiumDriver) this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;
        if (type.equals("ios")) {
            page = new SwagLabsPage(driver);
        } else {  // for now - it is also ios page
            page = new SwagLabsPage(driver);
        }

        // tap on the username
        page.tapOnUsername();

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }

    @Test(groups = {"@SwagLabs"})
    public void loginToSwagLabsTestValid5()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //AppiumDriver driver = this.getiosDriver();
        AppiumDriver driver = (AppiumDriver) this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;
        if (type.equals("ios")) {
            page = new SwagLabsPage(driver);
        } else {  // for now - it is also ios page
            page = new SwagLabsPage(driver);
        }

        // tap on the username
        page.tapOnUsername();

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }


    @Test(groups = {"@SwagLabs"})
    public void loginToSwagLabsTestValid6()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //AppiumDriver driver = this.getiosDriver();
        AppiumDriver driver = (AppiumDriver) this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;
        if (type.equals("ios")) {
            page = new SwagLabsPage(driver);
        } else {  // for now - it is also ios page
            page = new SwagLabsPage(driver);
        }

        // tap on the username
        page.tapOnUsername();

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }

    @Test(groups = {"@SwagLabs"})
    public void loginToSwagLabsTestValid7()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //AppiumDriver driver = this.getiosDriver();
        AppiumDriver driver = (AppiumDriver) this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;
        if (type.equals("ios")) {
            page = new SwagLabsPage(driver);
        } else {  // for now - it is also ios page
            page = new SwagLabsPage(driver);
        }

        // tap on the username
        page.tapOnUsername();

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }

    @Test(groups = {"@SwagLabs"})
    public void loginToSwagLabsTestValid8()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //AppiumDriver driver = this.getiosDriver();
        AppiumDriver driver = (AppiumDriver) this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;
        if (type.equals("ios")) {
            page = new SwagLabsPage(driver);
        } else {  // for now - it is also ios page
            page = new SwagLabsPage(driver);
        }

        // tap on the username
        page.tapOnUsername();

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }

    @Test(groups = {"@SwagLabs"})
    public void loginToSwagLabsTestValid9()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //AppiumDriver driver = this.getiosDriver();
        AppiumDriver driver = (AppiumDriver) this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;
        if (type.equals("ios")) {
            page = new SwagLabsPage(driver);
        } else {  // for now - it is also ios page
            page = new SwagLabsPage(driver);
        }

        // tap on the username
        page.tapOnUsername();

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }

    @Test(groups = {"@SwagLabs"})
    public void loginToSwagLabsTestValid10()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //AppiumDriver driver = this.getiosDriver();
        AppiumDriver driver = (AppiumDriver) this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;
        if (type.equals("ios")) {
            page = new SwagLabsPage(driver);
        } else {  // for now - it is also ios page
            page = new SwagLabsPage(driver);
        }

        // tap on the username
        page.tapOnUsername();

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }

    @Test(groups = {"@SwagLabs"})
    public void loginToSwagLabsTestValid11()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //AppiumDriver driver = this.getiosDriver();
        AppiumDriver driver = (AppiumDriver) this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;
        if (type.equals("ios")) {
            page = new SwagLabsPage(driver);
        } else {  // for now - it is also ios page
            page = new SwagLabsPage(driver);
        }

        // tap on the username
        page.tapOnUsername();

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }

    @Test(groups = {"@SwagLabs"})
    public void loginToSwagLabsTestValid12()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //AppiumDriver driver = this.getiosDriver();
        AppiumDriver driver = (AppiumDriver) this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;
        if (type.equals("ios")) {
            page = new SwagLabsPage(driver);
        } else {  // for now - it is also ios page
            page = new SwagLabsPage(driver);
        }

        // tap on the username
        page.tapOnUsername();

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }

    @Test(groups = {"@SwagLabs"})
    public void loginToSwagLabsTestValid13()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //AppiumDriver driver = this.getiosDriver();
        AppiumDriver driver = (AppiumDriver) this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;
        if (type.equals("ios")) {
            page = new SwagLabsPage(driver);
        } else {  // for now - it is also ios page
            page = new SwagLabsPage(driver);
        }

        // tap on the username
        page.tapOnUsername();

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }

    @Test(groups = {"@SwagLabs"})
    public void loginToSwagLabsTestValid14()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //AppiumDriver driver = this.getiosDriver();
        AppiumDriver driver = (AppiumDriver) this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;
        if (type.equals("ios")) {
            page = new SwagLabsPage(driver);
        } else {  // for now - it is also ios page
            page = new SwagLabsPage(driver);
        }

        // tap on the username
        page.tapOnUsername();

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }
    @Test(groups = {"@SwagLabs"})
    public void loginToSwagLabsTestValid15()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //AppiumDriver driver = this.getiosDriver();
        AppiumDriver driver = (AppiumDriver) this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;
        if (type.equals("ios")) {
            page = new SwagLabsPage(driver);
        } else {  // for now - it is also ios page
            page = new SwagLabsPage(driver);
        }

        // tap on the username
        page.tapOnUsername();

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }
    @Test(groups = {"@SwagLabs"})
    public void loginToSwagLabsTestValid16()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //AppiumDriver driver = this.getiosDriver();
        AppiumDriver driver = (AppiumDriver) this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;
        if (type.equals("ios")) {
            page = new SwagLabsPage(driver);
        } else {  // for now - it is also ios page
            page = new SwagLabsPage(driver);
        }

        // tap on the username
        page.tapOnUsername();

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }
    @Test(groups = {"@SwagLabs"})
    public void loginToSwagLabsTestValid17()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //AppiumDriver driver = this.getiosDriver();
        AppiumDriver driver = (AppiumDriver) this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;
        if (type.equals("ios")) {
            page = new SwagLabsPage(driver);
        } else {  // for now - it is also ios page
            page = new SwagLabsPage(driver);
        }

        // tap on the username
        page.tapOnUsername();

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }
    @Test(groups = {"@SwagLabs"})
    public void loginToSwagLabsTestValid18()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //AppiumDriver driver = this.getiosDriver();
        AppiumDriver driver = (AppiumDriver) this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;
        if (type.equals("ios")) {
            page = new SwagLabsPage(driver);
        } else {  // for now - it is also ios page
            page = new SwagLabsPage(driver);
        }

        // tap on the username
        page.tapOnUsername();

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }
    @Test(groups = {"@SwagLabs"})
    public void loginToSwagLabsTestValid19()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //AppiumDriver driver = this.getiosDriver();
        AppiumDriver driver = (AppiumDriver) this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;
        if (type.equals("ios")) {
            page = new SwagLabsPage(driver);
        } else {  // for now - it is also ios page
            page = new SwagLabsPage(driver);
        }

        // tap on the username
        page.tapOnUsername();

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }
    @Test(groups = {"@SwagLabs"})
    public void loginToSwagLabsTestValid20()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //AppiumDriver driver = this.getiosDriver();
        AppiumDriver driver = (AppiumDriver) this.getDriver();
        String type = this.getDriverType().toLowerCase();

        // init
        SwagLabsPage page;
        if (type.equals("ios")) {
            page = new SwagLabsPage(driver);
        } else {  // for now - it is also ios page
            page = new SwagLabsPage(driver);
        }

        // tap on the username
        page.tapOnUsername();

        // Login
        page.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(page.isOnProductsPage());
    }
    @Test(groups = {"@SwagLabs-webview"})
    public void webViewSwagLabsTest()
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        AppiumDriver driver = this.getiosDriver();

        // init
        SwagLabsPage swagPage = new SwagLabsPage(driver);

        // Login
        swagPage.login("standard_user", "secret_sauce");

        // Verificsation
        Assert.assertTrue(swagPage.isOnProductsPage());

        // Go to web view
        swagPage.clickMenu();
        swagPage.selectWebViewItem();
        swagPage.setWebURL("https://www.saucedemo.com");

        swagPage.loginWebView();
    }

    @Test(groups = {"@SwagLabsInstallApp"})
    public void iosInstallApp() {
        // for ios real device
        IOSDriver driver = this.getiosDriver();
        driver.context("NATIVE_APP");

        //String BUNDLE_ID = "org.reactjs.native.example.SwagLabsMobileApp";
        String BUNDLE_ID = "io.cloudgrey.the-app";

        //String APP_V1_0_0 = "https://github.com/saucelabs/sample-app-mobile/releases/download/2.3.0/iOS.RealDevice.SauceLabs.Mobile.Sample.app.2.3.0.ipa";
        String APP_V1_0_0 = "https://github.com/cloudgrey-io/the-app/releases/download/v1.10.0/TheApp-v1.10.0.ipa";

        String appUpgradeVersion = APP_V1_0_0;

        HashMap<String, String> bundleArgs = new HashMap<>();
        bundleArgs.put("bundleId", BUNDLE_ID);

        HashMap<String, String> installArgs = new HashMap<>();
        installArgs.put("app", appUpgradeVersion);

        driver.executeScript("mobile: installApp", installArgs);

        driver.executeScript("mobile: launchApp", bundleArgs);

        By usernameEdit = By.id("test-Username");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameEdit)).click();

        driver.findElement(usernameEdit).sendKeys("eyal 123");
    }

    @Test(groups = {"@ios-app-upgrades"})
    public void Edition006_iOS_Upgrade() {
        // for ios simulator

        IOSDriver driver = this.getiosDriver();
        driver.context("NATIVE_APP");

        String BUNDLE_ID = "io.cloudgrey.the-app";

        String APP_V1_0_0 = "https://github.com/cloudgrey-io/the-app/releases/download/v1.0.0/TheApp-v1.0.0.app.zip";
        String APP_V1_0_1 = "https://github.com/cloudgrey-io/the-app/releases/download/v1.0.1/TheApp-v1.0.1.app.zip";
        String APP_V1_0_2 = "https://github.com/cloudgrey-io/the-app/releases/download/v1.0.2/TheApp-v1.0.2.app.zip";

        By msgInput = By.xpath("//XCUIElementTypeTextField[@name=\"messageInput\"]");
        By savedMsg = MobileBy.AccessibilityId("savedMessage");
        By saveMsgBtn = MobileBy.AccessibilityId("messageSaveBtn");
        By echoBox = MobileBy.AccessibilityId("Echo Box");

        String TEST_MESSAGE = "Hello World";
        String appUpgradeVersion = APP_V1_0_0;

        HashMap<String, String> bundleArgs = new HashMap<>();
        bundleArgs.put("bundleId", BUNDLE_ID);

        HashMap<String, String> installArgs = new HashMap<>();
        installArgs.put("app", appUpgradeVersion);

        driver.executeScript("mobile: installApp", installArgs);

        driver.executeScript("mobile: launchApp", bundleArgs);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(echoBox)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(msgInput)).sendKeys(TEST_MESSAGE);
        wait.until(ExpectedConditions.presenceOfElementLocated(saveMsgBtn)).click();
        String savedText = wait.until(ExpectedConditions.presenceOfElementLocated(savedMsg)).getText();
        Assert.assertEquals(savedText, TEST_MESSAGE);

    }
}