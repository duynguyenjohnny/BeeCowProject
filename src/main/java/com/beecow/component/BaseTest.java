package com.beecow.component;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import com.beecow.utils.CommandPrompt;
import com.beecow.utils.Helper;
import com.beecow.utils.Result;
import com.beecow.utils.Utils;

import static com.beecow.component.Constant.*;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * Created by HangPham on 12/18/2016.
 */
public class BaseTest {
    public AppiumDriver driver;
    private CommandPrompt cp;
    public String localApp = APP_PATH;

    public Helper getHelper(){
        return new Helper(driver);
    }
    public Result getResult(){
        return new Result();
    }
    @BeforeSuite
    public void runCommandToLaunchAppium() throws IOException, InterruptedException {
        cp=new CommandPrompt();
        if(Utils.getInstance().isAndroidDevice()||Utils.getInstance().isWebAndroidDevice()) {
            cp.runCommand("\"C:\\Program Files (x86)\\Appium\\node.exe\" \"C:\\Program Files (x86)\\Appium\\node_modules\\appium\\lib\\server\\main.js\" --address 127.0.0.1 --port 4723 --app E:\\WorkSP\\test-mobile-qa\\beecow-ProjectMobile\\BeeCow.apk --pre-launch --platform-name Android --platform-version 19 --automation-name Appium --log-no-color");
        }
        if(Utils.getInstance().isIosDevice()){
            cp.runCommand("");
        }
        if(Utils.getInstance().isWebIOSDevice()){
            //open new terminal
            Runtime.getRuntime().exec("/usr/bin/open -a Terminal /path/to/the/executable");
        }
        Thread.sleep(20000);
    }
    @BeforeMethod
    public void setUp() throws Exception {
        initDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    private void initDriver() throws Exception {
        DesiredCapabilities capabilities = getPlatform_capabilities();
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = buildDriver(url, capabilities);
        driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
    }

    private AppiumDriver buildDriver(URL url, DesiredCapabilities capabilities) throws Exception {
        if (Utils.getInstance().isAndroidDevice()) {
            return new AndroidDriver(url, capabilities);
        }
        if (Utils.getInstance().isIosDevice()) {
            return new IOSDriver(url, capabilities);
        }
        if (Utils.getInstance().isWebAndroidDevice()){
            return new AndroidDriver(url,capabilities);
        }
        if (Utils.getInstance().isWebIOSDevice()){
            return new IOSDriver(url,capabilities);
        }
        throw new Exception("the driver does not find");
    }

    private DesiredCapabilities getPlatform_capabilities() throws Exception {
        if (Utils.getInstance().isAndroidDevice()) {
            return getAndroid_capability();
        }
        if (Utils.getInstance().isIosDevice()) {
            return getiOS_capability();
        }
        if (Utils.getInstance().isWebAndroidDevice()){
            return getWebAndroid_capability();
        }
        if (Utils.getInstance().isWebIOSDevice()){
            return getWebIOS_capability();
        }
        throw new Exception("does not find the platform correspon");
    }

    private DesiredCapabilities getAndroid_capability() {
        String userDir = System.getProperty("user.dir");
        String appPath = Paths.get(userDir, localApp).toAbsolutePath().toString();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.APP, appPath);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "K153XB1X6B250744");//ASUS_T00N
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
//        capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, APP_PACKAGE_LIVE);
        return capabilities;
    }

    private DesiredCapabilities getiOS_capability() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //real device
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iphone");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0.2");
        //simulator
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6s");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.2");

        capabilities.setCapability(MobileCapabilityType.APP, "apppath");
        capabilities.setCapability("bundleId","");
        capabilities.setCapability(MobileCapabilityType.UDID, "");

        capabilities.setCapability("noReset",true);
        capabilities.setCapability("fullReset",false);
        return capabilities;
    }
    private DesiredCapabilities getWebAndroid_capability(){
        DesiredCapabilities capabilities=DesiredCapabilities.chrome();
        capabilities.setBrowserName("Chrome");
        return capabilities;
    }
    private DesiredCapabilities getWebIOS_capability(){
        DesiredCapabilities capabilities=DesiredCapabilities.safari();
        capabilities.setBrowserName("Safari");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"");
        capabilities.setCapability(MobileCapabilityType.UDID,"");
        return capabilities;
    }
}