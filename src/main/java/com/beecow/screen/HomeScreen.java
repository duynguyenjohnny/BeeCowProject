package com.beecow.screen;

import com.beecow.component.CommonScreenObjects;
import com.beecow.utils.Utils;
import com.gargoylesoftware.htmlunit.html.Keyboard;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by PhuocHa on 01/10/2017.
 */

public class HomeScreen extends CommonScreenObjects {

    //ID resources
    public static String colordot = "com.mediastep.beecow:id/social_item_status_bar_ivStatus";
    public static String uploadtime = "com.mediastep.beecow:id/social_item_status_bar_tvCreateTime";


    public FooterComponent footerComponent;

    public HomeScreen(AppiumDriver driver) {
        super(driver);
        footerComponent = new FooterComponent(driver);
    }

    public void clickMarketTabView() {
        footerComponent.clickMarketTabView();
    }

    public void clickMoreTabView() {
        footerComponent.clickMoreTabView();
    }

    public void clickMessagesTabView() {
        footerComponent.clickMessagesTabView();
    }

    public void clickHomeTabView() {
        footerComponent.clickHomeTabView();
    }

    public void clickCupidTabView() {
        footerComponent.clickCupidTabView();
    }

    public static String getDatefromMili(long milliSeconds, String dateFormat) {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    /**
     * Swipe on the screen base on start coordinate and end coordinate
     *
     * @param startX   Start X coordinate - range 1-> 5
     * @param startY   Start X coordinate - range 1-> 10
     * @param endX     End X coordinate - range 1-> 5
     * @param endY     End Y coordinate - range 1-> 10
     * @param duration how fast it swipe, in mili-seconds
     * @throws Exception swipe down homeScreen.swipe(6,16,6,4,500);
     *                   swipe up homeScreen.swipe(6,4,6,16,500);
     *                   swipe left homeScreen.swipe(8,8,2,8,500);
     *                   swipe right homeScreen.swipe(2,8,8,8,500);
     */
    public void swipe(int startX, int startY, int endX, int endY, int duration) throws Exception {
        try {

            //Verify input parameters
            if (startX < 0 || startX > 10) {
                Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
                throw new Exception("[SwipeDown] Input parameter failed: startX must be in range 1 -> 10, your input is [" + startX + "]");
            }
            if (startY < 0 || startY > 20) {
                Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
                throw new Exception("[SwipeDown] Input parameter failed: startY must be in range 1 -> 20, your input is [" + startY + "]");
            }
            if (endX < 0 || endX > 10) {
                Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
                throw new Exception("[SwipeDown] Input parameter failed: endX must be in range 1 -> 10, your input is [" + endX + "]");
            }
            if (endY < 0 || endY > 20) {
                Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
                throw new Exception("[SwipeDown] Input parameter failed: endY must be in range 1 -> 20, your input is [" + endY + "]");
            }
            Dimension dimensions = driver.manage().window().getSize();

            int screenWidth = dimensions.getWidth();
            int screenHeight = dimensions.getHeight();

            int actualStartX = screenWidth / 10 * startX;
            int actualStartY = screenHeight / 20 * startY;
            int actualEndX = screenWidth / 10 * endX;
            int actualEndY = screenHeight / 20 * endY;
            System.out.println("Screen Width x Height (" + screenWidth + "," + screenHeight + ")");
            System.out.println("Start coordinate: [" + actualStartX + "," + actualStartY + "], End coordinate: [" + actualEndX + "," + actualEndY + "]");
            if (Utils.getInstance().isAndroidDevice()) {
                ((AndroidDriver) driver).swipe(actualStartX, actualStartY, actualEndX, actualEndY, duration);
            } else if (Utils.getInstance().isIosDevice()) {
                ((IOSDriver) driver).swipe(actualStartX, actualStartY, actualEndX, actualEndY, duration);
            }
        } catch (NoSuchElementException noElement) {
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            throw new Exception("[SwipeDown] Can't find Element: " + noElement.getMessage());
        } catch (Exception ex) {
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            throw new Exception("[SwipeDown] FAILED: " + ex.getMessage());
        }
    }

    public void srolltotext(String id) {
//        MobileElement element = (MobileElement) driver.findElementById("com.mediastep.beecow:id/fragment_social_content_view");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        HashMap<String,String> scrollObject = new HashMap<String, String>();
//        scrollObject.put("direction","down");
//        scrollObject.put("element", ((RemoteWebElement)element).getId());
//        scrollObject.put("text",text);
        //js.executeScript("mobile: scroll", scrollObject);
//        TouchAction action = null;
//        boolean token = false;
//        while (!token) {
//            try {
//                if (driver.findElementById(id).isDisplayed()) {
//                    token = true;
//                    driver.findElement(By.id(id)).click();
//                    //driver.findElement(By.id("com.mediastep.beecow:id/social_gallery_item_iv1")).click();
//                }
//            } catch (Exception e) {
//                action.press(600, 600).waitAction(300).moveTo(200, 200).release()
//                        .perform();
//
//            }
//        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,0)");
        do {
            try {
                driver.findElement(By.id(id)).click();
                break;
            } catch (Exception e) {
                js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0, 200)");

            }
        } while (true);
    }

    public void selectFeedByName(String nameText) {

//        driver.findElement(By
//
//                .id("com.mediastep.beecow:id/fragment_social_content_view"))
//
//                .click();
        do {

            try {
                //"//text[@value='We’ve requested more details about the prototype from Oculus. It looks like the gloves have a slim form-factor']"
                //driver.findElement(By.xpath("//*[@content-desc='TextClock']")).click();
                driver.findElement(By.name(nameText)).click();
                break;

            } catch (NoSuchElementException e) {

                Dimension dimensions = driver.manage().window().getSize();

                System.out.println(dimensions);

                Double screenHeightStart = dimensions.getHeight() * 0.5;

                int scrollStart = screenHeightStart.intValue();

                Double screenHeightEnd = dimensions.getHeight() * 0.2;

                int scrollEnd = screenHeightEnd.intValue();

                driver.swipe(0, scrollStart, 0, scrollEnd, 250);

            }

        } while (true);

    }

}
