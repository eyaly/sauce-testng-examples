package listeners;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class BaseTestListener implements ITestListener {

    // private DeviceUtils.RunType runType;
    final String CAP_PREFIX = "cap:";
    final String SAUCE_PREFIX = "sauce:";

    private RunType runType;

    public enum RunType { LOCAL, SAUCE, TO }

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static ThreadLocal<AndroidDriver> androidDriver = new ThreadLocal<AndroidDriver>();
    private static ThreadLocal<IOSDriver> iosDriver = new ThreadLocal<IOSDriver>();
    private static ThreadLocal<String> sessionId = new ThreadLocal<>();
    private static ThreadLocal<String> driverType = new ThreadLocal<String>();;

    public String getDriverType() { return driverType.get().toLowerCase();}

    public  WebDriver getWebDriver() {
        return webDriver.get();
    }

    public  AndroidDriver getAndroidDriver() {
        return androidDriver.get();
    }

    public  IOSDriver getiosDriver() {
        return iosDriver.get();
    }

    public WebDriver getDriver(){
        switch (getDriverType()) {
            case "desktop":
                return getWebDriver();
            case "android":
                return getAndroidDriver();
            case "ios":
                return getiosDriver();
            default:
                return getWebDriver();
        }
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        String testName = iTestResult.getName();
        System.out.println("Sauce - In Hook onTestStart. Test name: " + testName);

        // Get all test parameter
        Map<String, String> allParameters = iTestResult.getTestContext().getCurrentXmlTest().getAllParameters();

        // Set driver type
        String platform = getPlatform(allParameters);

        switch(platform.toLowerCase()) {
            case "android":
                driverType.set("android");
                break;
            case "ios":
                driverType.set("ios");
                break;
            default:
                driverType.set("desktop");
        }

        MutableCapabilities capabilities = new MutableCapabilities();

        // Add the parameters to the capabilities
        capabilities = addDriverCapabilities(capabilities,allParameters,testName);

        // For W3C add sauce:option

        // Add test name
        capabilities.setCapability("name", testName);

        switch(runType) {
            case LOCAL:
                createLocalDriver(capabilities);
                break;
            case SAUCE:
                createSauceDriver(capabilities, testName);
                break;
            case TO:
                createTestObjectDriver(capabilities);
                break;
        }

        // update test name and tags
        try {
            if (runType.equals(RunType.SAUCE)) {
              //  ((JavascriptExecutor) getDriver()).executeScript("sauce:job-name=" + iTestResult.getName());
                String[] tags = iTestResult.getTestContext().getAllTestMethods()[0].getGroups();
                String strTags = String.join(",", tags);
                ((JavascriptExecutor) getDriver()).executeScript("sauce:job-tags=" + strTags);
            }
        } catch (Exception e){
            System.out.println("Sauce - In Hook onTestStart. Problem to update test details");
        }
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Sauce - In Hook onTestSuccess");

        try {
            if (!runType.equals(RunType.LOCAL)) {
                updateTestResult(iTestResult);
            }
        }
        finally {
            getDriver().quit();
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Sauce - In Hook onTestFailure");

        try {
            if (!runType.equals(RunType.LOCAL)) {
                updateTestResult(iTestResult);
            }
        }
        finally {
            getDriver().quit();
        }
    }

    private void updateTestResult(ITestResult iTestResult) {
        ((JavascriptExecutor)getDriver()).executeScript("sauce:job-result=" + (iTestResult.isSuccess() ? "passed" : "failed"));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Sauce - In Hook onTestSkipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Sauce - In Hook onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Sauce - In Hook onStart");

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("Sauce - In Hook onFinish");

    }


    private String getPlatform(Map<String, String> allParameters) {
        String platformVal = CAP_PREFIX + "platform";
        String platform;
        if (!allParameters.containsKey(platformVal)) {
            platformVal = CAP_PREFIX + "platformName";
        }

        platform = allParameters.get(platformVal).toLowerCase();
        return platform;
    }

    private String getBuild(String buildVal) {
        String newBuildVal = buildVal;
        String envBuildTag = "BUILD_TAG";

        if (buildVal.equals(envBuildTag)) {
            // Need to check if there is env with this name
            newBuildVal = System.getenv(envBuildTag);
        }

        return newBuildVal;
    }

    private void sendCommentToReport(String comment){
        if (runType.equals(RunType.SAUCE)) {
            ((JavascriptExecutor) getDriver()).executeScript("sauce:context=" + comment);
        }
    }

    private  void createLocalDriver(MutableCapabilities capabilities) {

        try {
            webDriver.set(new ChromeDriver());
        } catch (Exception e) {
            System.out.println("*** Problem to create the local driver " + e.getMessage());
            throw new RuntimeException(e);
        }


    }
    private  void createSauceDriver(MutableCapabilities capabilities, String testName) {
        String username = System.getenv("SAUCE_USERNAME");
        String accesskey = System.getenv("SAUCE_ACCESS_KEY");
        String euSeleniumURI = "@ondemand.eu-central-1.saucelabs.com:443";
       // String euSeleniumURI = "@ondemand.us-west-1.saucelabs.com:443";

        String SAUCE_REMOTE_URL = "https://" + username + ":" + accesskey + euSeleniumURI +"/wd/hub";

        try {
            switch (getDriverType()) {
                case "desktop":
                    System.out.println("*** Sauce - create webdriver for desktop " );
                    webDriver.set(new RemoteWebDriver(new URL(SAUCE_REMOTE_URL), capabilities));

                    String id = ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
                    sessionId.set(id);
                    System.out.println("*** Sauce - Session id for desktop is: " + id );
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    printSessionId(testName);
                    break;
                case "android":
                    androidDriver.set(new AndroidDriver(new URL(SAUCE_REMOTE_URL),capabilities));
                    id = ((RemoteWebDriver) getAndroidDriver()).getSessionId().toString();
                    sessionId.set(id);
                    System.out.println("*** Sauce - Session id for Android is: " + id );
                    break;
                case "ios":
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    System.out.println("*** Sauce - BEFORE creating driver " + dtf.format(now));
                    iosDriver.set(new IOSDriver(new URL(SAUCE_REMOTE_URL), capabilities));
                    now = LocalDateTime.now();
                    System.out.println("*** Sauce - AFTER creating driver " + dtf.format(now));
                    id = ((RemoteWebDriver) getiosDriver()).getSessionId().toString();
                    sessionId.set(id);
                    System.out.println("*** Sauce - Session id for iOS is: " + id );
                    break;
            }

        } catch (Exception e) {
            System.out.println("*** Problem to create the driver " + e.getMessage());
            sendCommentToReport(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private  void createSauceUPDriver(MutableCapabilities capabilities) {
        String username = System.getenv("SAUCE_USERNAME");
        String accesskey = System.getenv("SAUCE_ACCESS_KEY");
        String euSeleniumURI = "@ondemand.eu-central-1.saucelabs.com:443";

        String SAUCE_REMOTE_URL = "https://" + username + ":" + accesskey + euSeleniumURI +"/wd/hub";

        try {
            switch (getDriverType()) {
                case "android":
                    androidDriver.set(new AndroidDriver(new URL(SAUCE_REMOTE_URL),capabilities));
                    String id = ((RemoteWebDriver) getAndroidDriver()).getSessionId().toString();
                    sessionId.set(id);
                    System.out.println("*** Sauce - Session id for Android is: " + id );
                    break;
                case "ios":
                    iosDriver.set(new IOSDriver(new URL(SAUCE_REMOTE_URL), capabilities));
                    id = ((RemoteWebDriver) getiosDriver()).getSessionId().toString();
                    sessionId.set(id);
                    System.out.println("*** Sauce - Session id for iOS is: " + id );
                    break;
            }

        } catch (Exception e) {
            System.out.println("*** Problem to create the driver " + e.getMessage());
            sendCommentToReport(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private  void createTestObjectDriver(MutableCapabilities capabilities) {

        String SAUCE_REMOTE_URL = "https://eu1.appium.testobject.com/wd/hub";

        System.out.println("*** Sauce - createTestObjectDriver. driverType: " + driverType + " .URL: "+ SAUCE_REMOTE_URL);

        try {
            switch (getDriverType()) {
                case "android":
                    androidDriver.set(new AndroidDriver(new URL(SAUCE_REMOTE_URL),capabilities));
                    String id = ((RemoteWebDriver) getAndroidDriver()).getSessionId().toString();
                    sessionId.set(id);
                    System.out.println("*** Sauce - Session id for Android is: " + id );
                    break;
                case "ios":
                    iosDriver.set(new IOSDriver(new URL(SAUCE_REMOTE_URL), capabilities));
                    id = ((RemoteWebDriver) getiosDriver()).getSessionId().toString();
                    sessionId.set(id);
                    System.out.println("*** Sauce - Session id for iOS is: " + id );
                    break;
            }
        } catch (Exception e) {
            System.out.println("*** Problem to create the driver " + e.getMessage());
            sendCommentToReport(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public MutableCapabilities addDriverCapabilities(MutableCapabilities capabilities,Map<String, String> driverParams, String testName){
        String api = driverParams.get("API").toLowerCase();
        boolean w3c = Boolean.parseBoolean(driverParams.getOrDefault("W3C", "false"));
        switch (api.toLowerCase()) {
            case "local":
                runType = RunType.LOCAL;
                addLocalCap(capabilities, driverParams);
                break;
            case "testobject":
                runType = RunType.TO;
                setDriverCapabilities(capabilities, driverParams);
                break;
            case "sauce":
                runType = RunType.SAUCE;
                if (w3c) {
                    addW3CCap(capabilities, driverParams, testName);
                } else {
                setDriverCapabilities(capabilities, driverParams);
                }
                break;
        }

        return capabilities;
    }

    private void addLocalCap(MutableCapabilities capabilities, Map<String, String> driverParams) {

        String browser = driverParams.get("browser").toLowerCase();
        if (browser.equals("chrome")) {
            System.out.println("*** Sauce - add Chrome local capabilities ***");
            String driverPath = driverParams.get("webdriver.chrome.driver");
            System.setProperty("webdriver.chrome.driver",driverPath);
        }
    }

    private  void addW3CCap(MutableCapabilities capabilities, Map<String, String> driverParams, String testName) {

        String browser = driverParams.get("browser").toLowerCase();
        if (browser.equals("chrome")) {
            System.out.println("*** Sauce - Add chrome W3C driver ***");
            ChromeOptions chromeOpts = new ChromeOptions();
            chromeOpts.setExperimentalOption("w3c", true);
            capabilities.merge(chromeOpts);
            capabilities.setCapability("browserName", browser);
        }
        else if (browser.equals("firefox")) {
            System.out.println("*** Sauce - Add firefox W3C driver ***");
            FirefoxOptions firefoxOpts = new FirefoxOptions();
            capabilities.merge(firefoxOpts);
            capabilities.setCapability("browserName", browser);
        }
        else if (browser.equals("safari")) {
            System.out.println("*** Sauce - Add Safari W3C driver ***");
            SafariOptions safaruOpts = new SafariOptions();
            capabilities.merge(safaruOpts);
            capabilities.setCapability("browserName", browser);
        }

        else if (browser.equals("microsoftedge")) {
            System.out.println("*** Sauce - Add Edge W3C driver ***");
            EdgeOptions edgeOpts = new EdgeOptions();
            capabilities.merge(edgeOpts);
            capabilities.setCapability("browserName", browser);
        }

        setDriverCapabilities(capabilities, driverParams);

        if (runType.equals(RunType.SAUCE)) {
            MutableCapabilities sauceOptions = new MutableCapabilities();
            driverParams.forEach((k, v) -> {
                if (k.startsWith(SAUCE_PREFIX)) {
                    // remove the prefix
                    String capability = k.replace(SAUCE_PREFIX, "");
                    sauceOptions.setCapability(capability, v);
                }
            });
            sauceOptions.setCapability("name", testName);
            capabilities.setCapability("sauce:options", sauceOptions);
        }

        //return capabilities;
    }

    private  void setDriverCapabilities(MutableCapabilities capabilities, Map<String, String> driverParams) {
        driverParams.forEach((k,v)->{

            if(k.startsWith(CAP_PREFIX)){
                // remove the prefix
                String capability =  k.replace(CAP_PREFIX,"");
                if (v.equals("true") || v.equals("false")){
                    // boolean
                    capabilities.setCapability(capability, Boolean.parseBoolean(v));
                } else {
                    // Handle build capability that can be a env value
                    if (capability.toLowerCase().equals("build")){
                        String build = getBuild(v);
                        capabilities.setCapability(capability, build);
                    }
                    else{
                        capabilities.setCapability(capability, v);
                    }

                }
            }
        });
    }

    private void printSessionId(String testName) {

        String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s",
                (((RemoteWebDriver) getDriver()).getSessionId()).toString(), testName);
        System.out.println(message);
    }

}
