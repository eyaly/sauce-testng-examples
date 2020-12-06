# Running TestNG Tests (Selenium and Appium) on Sauce Labs Platform
This project contains Java TestNG xamples for running Selenium and Appium tests on Sauce Labs platform:  
On Real Devices and VMs:  

The framework uses testNG xml file for parallel executions. All the tests in the same class will run in parallel on different devices 
## Important information
### Environment variables for Sauce Labs
The examples in this repository that can run on Sauce Labs use environment variables, make sure you've added the following

    # For Sauce Labs Real devices in the New UI
    export SAUCE_USERNAME=********
    export SAUCE_ACCESS_KEY=*******
    
### Demo app(s)
The Native demo app that has been used for these tests can be found [here](https://github.com/saucelabs/sample-app-mobile/releases).
Be aware of the fact that you need the build for the iOS real device. So please check the file you download.

> The advice is to download the files to an `apps` folder in the root of this folder.

### Upload apps to Sauce Storage
* If you want to use iOS real devices and Android real devices in the New Sauce Labs UI you need to upload the apps to the Sauce Storage.
For more information on this step please visit: [Application Storage](https://wiki.saucelabs.com/display/DOCS/Application+Storage).
* In the app capability you must use `storage:<app-id>` or `storage:filename=<file-name>`. For more information on this step please visit: [Application Storage](https://wiki.saucelabs.com/display/DOCS/Application+Storage).
* Change the value of appName in the native apps tests for Android and iOS according to your app name.
### Useful Links 
* How to upload the apps to the Sauce Storage and the app capability: [Application Storage](https://wiki.saucelabs.com/display/DOCS/Application+Storage).
* Appium Capabilities for Real Device Testing: [Appium Capabilities](https://wiki.saucelabs.com/display/DOCS/Appium+Capabilities+for+Real+Device+Testing).
* Sauce Labs Data Center Endpoints: [Data Center EndPoints](https://wiki.saucelabs.com/display/DOCS/Data+Center+Endpoints).
* How to set the pass/fail status of a test: [Annotating Tests with Selenium's JavaScript Executor](https://wiki.saucelabs.com/display/DOCS/Annotating+Tests+with+Selenium%27s+JavaScript+Executor).
## Run the testNG xml file
Folder test/resources/config contains testNG xml file. use parameter testngXmlFile to run a xml file. 
For Example:

    // If using the US DC
    mvn clean install -DtestngXmlFile=testng_web_demo.xml -Dregion=us
    
    // If using the EU DC
    mvn clean install -DtestngXmlFile=testng_web_demo.xml -Dregion=eu
    
> NOTE: Make sure you are in the folder `sauce-testng-example` when you execute this command