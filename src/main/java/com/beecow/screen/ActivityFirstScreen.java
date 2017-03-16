package com.beecow.screen;

import com.beecow.component.CommonScreenObjects;
import com.beecow.utils.Helper;
import com.beecow.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import static com.beecow.model.ActivityFristElement.*;
import static com.beecow.model.ActivitySecondElement.getBtnDone;
import static com.beecow.model.ActivitySecondElement.getIndustryLocatorByText;


public class ActivityFirstScreen extends CommonScreenObjects {

    public static Properties GLOBALPROPERTIES;
    public String GLOBALPROPERTIESFile = "Global.properties";
    // DATA TEST
    public static String[] cats = {"Sport", "Computer", "Meal Deals"};
    public static String[] reverse_cats = {"Meal Deals", "Computer", "Sport"};
    public static String[] single_cat = {"Meal Deals"};
    public static String[] double_cats = {"Meal Deals", "Health & Beauty"};
    public static String[] catList = {"Mobile & Tablet", "Computer", "Camera & TV", "Home & Living", "Mom & Kids", "Health & Beauty", "Sport", "Meal Deals", "Spa Deals", "Entertainment Deals", "Travel Deals"};
    public static String[] singleinds = {"Education"};
    public static String[] inds = {"Automotive", "Architecture", "Banking"};
    public static String[] indList = {"Accounting & Auditing Services", "Advertising & Public RelationstAds & PR", "Agriculture/Forestry/Fishing", "Airlines & Aviation", "Architecture", "Automotive", "Banking", "Beauty/Cosmetics", "Biotechnology/Pharmaceuticals", "Broadcasting/Music/Film", "Chemical/Petro-chemical", "Clothing & Textile Manufacturing", "Computer/IT", "Construction", "Consulting", "Design", "Distribution/Logistics", "Education", "Energy/Utilities", "Engineering", "Financial Services", "Food/Beverage Production", "Government", "Healthcare Services", "Hotels/Lodging", "Import/Export/Trade", "Insurance", "Internet Services", "Legal Services", "Manufacturing", "Medical/Hospital", "NGO/INGO/Non-profit", "Performing Arts/Fine Arts", "Personal & Household Services", "Printing/Publishing", "Real Estate/Property", "Recruitment Agencies", "Restaurant/Food Services", "Retail", "Security/Surveillance", "Social Services", "Sports/Physical Recreation", "Telecommunications Services", "Tourism/Travel Services", "Transportation & Storage"};

    private ActivitySecondScreen secondScreen;
    public ActivityFirstScreen(AppiumDriver driver){
        super(driver);
    }

    public Helper getHelper(){
        return new Helper(driver);
    }

    public void selectCategory(String catName) {
        getHelper().findElement(getCategoryLocatorByText(catName)).click();
    }
    public void selectIndustry(String indName) {
        getHelper().findElement(getIndustryLocatorByText(indName)).click();
    }

    public void selectCategories(String cats[]) {
        for (int i=0; i < cats.length; i++)
            selectCategory(cats[i]);
    }

    public void selectIndustries(String indus[]) {
        for (int i=0; i < indus.length; i++)
            selectIndustry(indus[i]);
    }

    public void clickButtonNext(){
        getHelper().findElement(getBtnNext()).click();
    }

    public void verifyFirstScreenShouldContainCategory(String catName){
        getHelper().isElementPresent(getCategoryLocatorByText(catName));
    }

    public void clickButtonDone(){
        getHelper().findElement(getBtnDone()).click();
    }

    public boolean verifyScreenAppear(String indName){
        getHelper().isElementPresent(getCategoryLocatorByText(indName));
        return true;
    }
    public void selectFirstAndSecondLaunching() {
        System.out.println("Begin Select categories for first launching");
        selectCategories(cats);
        System.out.println("Click button Next to go second launching");
        clickButtonNext();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Next select industries");
        selectIndustries(inds);
        System.out.println("Then click button Done");
        clickButtonDone();
        //System.out.println("Click Market Tab view to go Market Overview page");
        //homeScreen.clickMarketTabView();
    }

    public boolean isElementPresent(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='MyWebView']")));
        return true;
    }

    public void runbatfile(String path){
        final Runtime rt = Runtime.getRuntime();
        try {
            //Process p = rt.exec(“cmd /c start D:/Projects/beecow-QAAutomation/clearcache.bat”);
            Process p = rt.exec(path);
            //p.waitFor();
        } catch (final IOException e) {
            throw new RuntimeException("Failed to run bat file");
        }
    }

//    public void isElementPresent(String indName){
//        getHelper().isElementPresent(getCategoryLocatorByText(indName));
//        getHelper().isElementPresent(driver.findElementById());
//    }

    public void closeApp() {
        if(driver!=null){
            driver.closeApp();
        }
    }

    public void removeApp() {
        if(driver!=null){
            driver.removeApp(Utils.getPropertyValue(GLOBALPROPERTIES, "Android_AppPackage"));
            //driver.removeApp();
            //driver.installApp();
            //driver.resetApp();
        }
    }

    public void installandstartApp() {
        if(driver!=null){
            String Android_APKFile = Paths.get(".").toAbsolutePath().normalize().toString() + File.separator + Utils.getPropertyValue(GLOBALPROPERTIES, "Android_APKFile");
            String androidAPKFile = new File(Utils.getPropertyValue(GLOBALPROPERTIES, "Android_APKFile")).getAbsolutePath();
//            DesiredCapabilities capabilities = new DesiredCapabilities("appWaitActivity", null, null);
//            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
//            capabilities.setCapability(MobileCapabilityType.APP, androidAPKFile);
//            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Utils.getPropertyValue(GLOBALPROPERTIES, "Android_AppPackage"));
//            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, Utils.getPropertyValue(GLOBALPROPERTIES, "Android_AppActivity"));
            driver.installApp("D:\\Project\\beecow-QAAutomation\\Beecow.apk");
            driver.launchApp();
        }
    }

    public void startApp() {
        if(driver!=null){
//            DesiredCapabilities capabilities = new DesiredCapabilities("appWaitActivity", null, null);
//            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Utils.getPropertyValue(GLOBALPROPERTIES, "Android_AppPackage"));
//            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, Utils.getPropertyValue(GLOBALPROPERTIES, "Android_AppActivity"));
            driver.launchApp();
        }
    }

    public void verifyFirstScreenShouldContainCategories(String cats[]) {
        for (int i=0; i < cats.length; i++)
            verifyFirstScreenShouldContainCategory(cats[i]);
    }
}
