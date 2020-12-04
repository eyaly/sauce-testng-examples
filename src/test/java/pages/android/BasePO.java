package pages.android;

import io.appium.java_client.AppiumDriver;

public class BasePO {
    protected AppiumDriver driver;

    public BasePO(){

    }
    public BasePO(AppiumDriver driver) {
        this.driver = driver;
    }

}
