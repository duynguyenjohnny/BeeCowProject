package com.beecow.screen;

import com.beecow.component.CommonScreenObjects;
import com.beecow.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * Created by PhuocHa on 01/10/2017.
 */

public class HomeScreen extends CommonScreenObjects
{

    //ID resources
    public static String colordot = "com.mediastep.beecow:id/social_item_status_bar_ivStatus";


    public FooterComponent footerComponent;
    public HomeScreen(AppiumDriver driver){
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

    /**
     * Swipe on the screen base on start coordinate and end coordinate
     * @param startX Start X coordinate - range 1-> 5
     * @param startY Start X coordinate - range 1-> 10
     * @param endX End X coordinate - range 1-> 5
     * @param endY End Y coordinate - range 1-> 10
     * @param duration how fast it swipe, in mili-seconds
     * @throws Exception
     * swipe down homeScreen.swipe(6,16,6,4,500);
     * swipe up homeScreen.swipe(6,4,6,16,500);
     * swipe left homeScreen.swipe(8,8,2,8,500);
     * swipe right homeScreen.swipe(2,8,8,8,500);
     */
    public void swipe(int startX, int startY, int endX, int endY, int duration) throws Exception{
        try{

            //Verify input parameters
            if (startX < 0 || startX > 10){
                Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
                throw new Exception("[SwipeDown] Input parameter failed: startX must be in range 1 -> 10, your input is [" + startX + "]");
            }
            if (startY < 0 || startY > 20){
                Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
                throw new Exception("[SwipeDown] Input parameter failed: startY must be in range 1 -> 20, your input is [" + startY + "]");
            }
            if (endX < 0 || endX > 10){
                Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
                throw new Exception("[SwipeDown] Input parameter failed: endX must be in range 1 -> 10, your input is [" + endX + "]");
            }
            if (endY < 0 || endY > 20){
                Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
                throw new Exception("[SwipeDown] Input parameter failed: endY must be in range 1 -> 20, your input is [" + endY + "]");
            }
            Dimension dimensions = driver.manage().window().getSize();

            int screenWidth = dimensions.getWidth();
            int screenHeight = dimensions.getHeight();

            int actualStartX = screenWidth/10*startX;
            int actualStartY = screenHeight/20*startY;
            int actualEndX = screenWidth/10*endX;
            int actualEndY = screenHeight/20*endY;
            System.out.println("Screen Width x Height (" + screenWidth + "," + screenHeight + ")");
            System.out.println("Start coordinate: [" + actualStartX + "," + actualStartY + "], End coordinate: [" + actualEndX + "," + actualEndY + "]");
            if (Utils.getInstance().isAndroidDevice()){
                ((AndroidDriver)driver).swipe(actualStartX,actualStartY,actualEndX,actualEndY,duration);
            }else if(Utils.getInstance().isIosDevice()){
                ((IOSDriver)driver).swipe(actualStartX,actualStartY,actualEndX,actualEndY,duration);
            }
        }catch (NoSuchElementException noElement){
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            throw new Exception("[SwipeDown] Can't find Element: " + noElement.getMessage());
        }catch (Exception ex){
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            throw new Exception("[SwipeDown] FAILED: " + ex.getMessage());
        }
    }

}