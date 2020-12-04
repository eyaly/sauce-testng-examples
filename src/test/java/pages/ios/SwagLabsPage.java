package pages.ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;

import java.time.Duration;
import java.util.Set;

public class SwagLabsPage {

    By usernameEdit = By.id("test-Username");
    By passwordEdit = By.id("test-Password");
    By submitButton = By.id("test-LOGIN");
    By ProductTitle = By.xpath("//XCUIElementTypeStaticText[@name=\"PRODUCTS\"]\n");
    By testMenu = By.name("test-Menu");
    By testWebViewItem = By.name("test-WEBVIEW");
    By urlEdit = By.id("test-enter a https url here...");
    By goToSiteBtn = By.id("test-GO TO SITE");
    By usernameInputWeb = By.id("user-name");
    By passwordInputWeb = By.id("password");
    By submitButtonWeb = By.className("btn_action");

    public IOSDriver driver;

    public SwagLabsPage(AppiumDriver driver) {
        this.driver = (IOSDriver) driver;

    }

    public void login(String user, String pass) {
        try {
            driver.findElement(usernameEdit).click();
            driver.findElement(usernameEdit).sendKeys(user);

            driver.findElement(passwordEdit).click();
            driver.findElement(passwordEdit).sendKeys(pass);

            driver.findElement(submitButton).click();

        } catch (Exception e) {
            System.out.println("*** Problem to login: " + e.getMessage());
        }
    }

    public boolean isOnProductsPage() {
        return driver.findElement(ProductTitle).isDisplayed();
    }

    public void clickMenu() {
        driver.findElement(testMenu).click();
    }

    public void selectWebViewItem() {
        driver.findElement(testWebViewItem).click();
    }

    public void setWebURL(String urlText) {
        driver.findElement(urlEdit).click();
        driver.findElement(urlEdit).sendKeys(urlText);
        driver.findElement(goToSiteBtn).click();
    }

    public void loginWebView() {
        String currentContext = driver.getContext();
        System.out.println("*** current Context: " + currentContext);
        Set<String> contextNames = driver.getContextHandles();
        boolean bFoundWeb = false;
        for (int i = 1; i< 2; i++)
        {
            if (contextNames.size() == 1) {
                try {
                    System.out.println("i= " + i);
                    Thread.sleep(1000);
                    contextNames = driver.getContextHandles();
                } catch (InterruptedException e) {
                }
            }
            else {
                bFoundWeb = true;
                break;
            }
        }
        // print all contexts
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }

        //Object cont = ((JavascriptExecutor) driver).executeScript("mobile: getContexts");
        // Set the context to webview
        driver.context(contextNames.toArray()[1].toString()); // set context to WEBVIEW
        currentContext = driver.getContext();
        System.out.println("*** current Context: " + currentContext);
        driver.findElement(usernameInputWeb).sendKeys("eyal");
        // ... Need to add the webView test

        // Back to native app context
        driver.context("NATIVE_APP");
    }

    public void tapOnUsername(){

        Point location = driver.findElement(submitButton).getLocation();
        int x = location.getX()+ 20;
        int y = location.getY()+ 20;
        TouchAction touchAction = new TouchAction(driver);

        touchAction.tap(PointOption.point(x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                .tap(PointOption.point(x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                .tap(PointOption.point(x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                .tap(PointOption.point(x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                .tap(PointOption.point(x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                .tap(PointOption.point(x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                .tap(PointOption.point(x, y))
                .perform();
    }
}
