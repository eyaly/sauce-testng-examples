package tests.web;

import listeners.BaseTestListener;
import org.testng.annotations.Test;
import pages.web.LocalhostPage;

public class locallhosTest extends BaseTestListener {

    @Test(groups = { "@local" })
    public void openLocalhostWeb() {

        LocalhostPage localhostPage = new LocalhostPage(this.getDriver());
        localhostPage.navigate();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}