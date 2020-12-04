package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocalhostPage extends BasePO {
    private String url = "http://localhost:3000/example-2";

    public String getUrl() {
        return url;
    }

    public LocalhostPage() {
        super();
    }
    public LocalhostPage(WebDriver driver) {
        super(driver);
    }

    public void navigate(){
        driver.get(url);
    }

    public void tpye(String strText){
        driver.findElement(By.id("main-input")).sendKeys("abcde");
    }

}
