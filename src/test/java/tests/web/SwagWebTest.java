package tests.web;

import listeners.BaseTestListener;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.web.SwagInventoryPage;
import pages.web.SwagLoginPage;

import java.util.HashMap;
import java.util.Map;


public class SwagWebTest extends BaseTestListener {

    @Test(groups = { "@Web", "@Web1" })
    public void loginTestValid() {

        SwagLoginPage loginPage = new SwagLoginPage(this.getDriver());
        loginPage.navigate();
        loginPage.login("standard_user", "secret_sauce");

        SwagInventoryPage inventoryPage = new SwagInventoryPage(this.getDriver());
        Assert.assertTrue(inventoryPage.isOnPage());
    }

    @Test(groups = { "@Web" , "@Login"})
    public void loginTestValidPerfGlitch() {

        SwagLoginPage loginPage = new SwagLoginPage(this.getDriver());
        loginPage.navigate();
        loginPage.login("performance_glitch_user", "secret_sauce");

        SwagInventoryPage inventoryPage = new SwagInventoryPage(this.getDriver());
        Assert.assertTrue(inventoryPage.isOnPage());
    }

    @Test(groups = { "@Web" })
    public void loginTestValidLockedOut() {

        SwagLoginPage loginPage = new SwagLoginPage(this.getDriver());
        loginPage.navigate();
        loginPage.login("locked_out_user", "secret_sauce");

        Assert.assertTrue(loginPage.epicSadFaceDisplayed());
    }

    @Test(groups = { "@Web" })
    public void loginTestValidProblem() {

        SwagLoginPage loginPage = new SwagLoginPage(this.getDriver());
        loginPage.navigate();
        loginPage.login("problem_user", "secret_sauce");

        SwagInventoryPage inventoryPage = new SwagInventoryPage(this.getDriver());
        Assert.assertTrue(inventoryPage.isOnPage());
    }

    @Test(groups = { "@Web" })
    public void loginTestInvalidUsername() {

        SwagLoginPage loginPage = new SwagLoginPage(this.getDriver());
        loginPage.navigate();
        loginPage.login("invalid_user", "secret_sauce");

        Assert.assertTrue(loginPage.isOnPage());
    }

    @Test(groups = { "@Web" })
    public void loginTestInvalidPassword() {

        SwagLoginPage loginPage = new SwagLoginPage(this.getDriver());
        loginPage.navigate();
        loginPage.login("standard_user", "invalid_password");

        Assert.assertTrue(loginPage.isOnPage());
    }

    @Test(groups = { "@WebError" })
    public void loginTestInvalidPasswordFailed() {

        SwagLoginPage loginPage = new SwagLoginPage(this.getDriver());
        loginPage.navigate();
        loginPage.login("standard_user", "invalid_password");
//        loginPage.login("standard_user", "secret_sauce");

        SwagInventoryPage inventoryPage = new SwagInventoryPage(this.getDriver());
        Assert.assertTrue(inventoryPage.isOnPage());
    }

    @Test(groups = { "@Intercept" })
    public void TestIntercept() {

        SwagLoginPage loginPage = new SwagLoginPage(this.getDriver());
        loginPage.navigate();
        System.out.println("Sauce - current URL: " + loginPage.getCurrentURL());
    try {
        Map<String, String> interceptMap = new HashMap<>();
        interceptMap.put("url", "https://www.saucedemo.com/inventory.html");
        interceptMap.put("redirect", "https://google.com");
        ((JavascriptExecutor) this.getDriver()).executeScript("sauce:intercept", interceptMap);
    }catch (Exception e) {
        System.out.println("*** Problem to create the intercept" + e.getMessage());

    }
        loginPage.login("standard_user", "secret_sauce");
        SwagInventoryPage inventoryPage = new SwagInventoryPage(this.getDriver());
        Assert.assertTrue(inventoryPage.isOnPage());
        System.out.println("Sauce - current URL: " + loginPage.getCurrentURL());
    }

    @Test(groups = { "@performance" })
    public void loginTestValidPerformance() {

        SwagLoginPage loginPage = new SwagLoginPage(this.getDriver());
        loginPage.navigate();
        loginPage.login("standard_user", "secret_sauce");

        SwagInventoryPage inventoryPage = new SwagInventoryPage(this.getDriver());
        Assert.assertTrue(inventoryPage.isOnPage());
    }

}