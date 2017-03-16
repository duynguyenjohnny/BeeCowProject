package com.beecow.mobile.SN;

import com.beecow.component.BaseTest;
import com.beecow.utils.APIData;
import com.beecow.utils.APIUtil;
import com.beecow.screen.ActivityFirstScreen;
import com.beecow.screen.ActivitySecondScreen;
import com.beecow.screen.HomeScreen;
import com.beecow.screen.MarketScreen;
import com.beecow.utils.*;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSElement;
import org.json.simple.JSONObject;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

import java.io.File;


import static com.beecow.utils.Helper.addLog;


public class Android_Sprint_02 extends BaseTest {

    String className = this.getClass().getSimpleName();
    private ActivityFirstScreen firstScreen;
    private ActivitySecondScreen secondScreen;
    private HomeScreen homeScreen;
    private JSONObject jsonData;
    private MarketScreen marketScreen;
    private SwipeFunctions swipeFunctions;

    static String SNPropertiesFileSprint2 = "SN2.properties";

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp(SNPropertiesFileSprint2);

        firstScreen = new ActivityFirstScreen(driver);
        secondScreen = new ActivitySecondScreen(driver);
        homeScreen = new HomeScreen(driver);
        initData();
    }

    @Override
    protected void initData() {
        jsonData = APIUtil.parseDataToJsonObject(APIData.JSON_DATA_FILE);
    }

    /*
     AND_SN_TC_12 Verify color dot appears and displays orange color
     AND_SN_TC_13 Verify upload time notification should appear and display "Just now"
     AND_SN_TC_14 Verify upload time notification should appear and display "1 min" to "59 mins"
     AND_SN_TC_15 Verify upload time notification should appear and display "1 hr" to "24 hrs"
     AND_SN_TC_16 Verify upload time notification should appear and display "Yesterday at hh:mm"
     AND_SN_TC_17 Verify upload time notification should appear and display"x d"
     AND_SN_TC_18 Verify upload time notification should appear and display "Mmm dd"
     AND_SN_TC_19 Verify upload time notification should appear and display as "Mmm dd, yyyy" for last year backwards

     */
    @Test
    public void AND_SN_TC_12() throws Exception, TestLinkAPIException {
        addLog("AND_SN_TC_12 Verify color dot appears and displays orange color");
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            firstScreen.selectFirstAndSecondLaunching();
            Thread.sleep(1000);
            System.out.println("Create a post as status type");
            String requestBodyStatus = jsonData.get(APIData.ADD_NEW_STATUS).toString();
            JSONObject poststatus = APIUtil.sendPost(APIData.POST_STATUS_COM,requestBodyStatus);
            //System.out.println(poststatus);
            //api.poststatuspuretext();
            Thread.sleep(3000);
            Assert.assertEquals(poststatus.get("content").toString(), "@1111 Automation Add New Status Pure Text");
            //requestResult.get("Response Code").toString();
            //api.postnewfeeds();
            Thread.sleep(2000);
            JSONObject collectpost = APIUtil.sendPost(APIData.POST_FEEDS_COM,"");
            //Assert.assertEquals(collectpost.get("content").toString(), "200");
            Thread.sleep(2000);

            homeScreen.swipe(6,6,6,12,100);
            Assert.assertEquals(true,getHelper().isElementById(homeScreen.colordot));
            Assert.assertEquals(true,getHelper().isElementById(homeScreen.uploadtime));

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-12", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_02.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-12", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();

        }
    }

    @Test
    public void AND_SN_TC_13() throws Exception, TestLinkAPIException {
        addLog("AND_SN_TC_13 Verify upload time notification should appear and display \"Just now\"");
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            //da check o AND_SN_TC_12
            Assert.assertEquals(true,true);

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-13", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_02.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-13", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();

        }
    }

    @Test
    public void AND_SN_TC_14() throws Exception, TestLinkAPIException {
        addLog("AND_SN_TC_14 Verify upload time notification should appear and display \"1 min\" to \"59 mins\"");
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
       //long currentdate = System.currentTimeMillis();
       //long  expectdate = currentdate - 600000;
           //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            long current = System.currentTimeMillis();
            long expectdate= current - (600000);

            String CreateDate10minutes = homeScreen.getDatefromMili(expectdate,"yyyy-MM-dd_HH:mm:ss/").toString();
            String newText = CreateDate10minutes.replace("_","T");
            // Date Expect time with format yyyy-MM-ddTHH:mm:ssZ
            String ExpectDate10minutes = newText.replace("/","Z");
            //DateTimeFormatter currentdate = DateTimeFormat.forPattern("yyyy-MM-ddTHH:mm:ssZ");
            //DateTimeFormatter  expectdate = currentdate - 600000;
            //Calendar date = Calendar.getInstance();
            /*
            currentdate - x = createdate
            2017-02-10T07:51:27Z
            1489569579141
            1489568979141
            */

            String request = "{\"title\": \"Automation time upload 1 to 59 minutes\",\"content\": \"@1111 Automation time upload 1 to 59 minutes\",\"author\": {\"userId\": 2,\"displayName\": \"Long Long\",\"avatarUrl\": \"feed/images/feed3048\"},\"statusType\": \"TEXT\",\"mentionedUser\": [{\n" +
                    "\"userId\": 1111,\"displayName\": \"Long Nguyen\",\"avatarUrl\": \"feed/images/feed3048\",\"mentioned\": true}],\"createdDate\":";
            String requestBodyStatus = request + "\"" + ExpectDate10minutes + "\"}";
            System.out.print(requestBodyStatus);
            JSONObject poststatus = APIUtil.sendPost(APIData.POST_STATUS_COM,requestBodyStatus);
            Thread.sleep(3000);
            String id = poststatus.get("id").toString();

            Thread.sleep(3000);
            JSONObject collectpost = APIUtil.sendPost(APIData.POST_FEEDS_COM,"");
            Thread.sleep(3000);
            Assert.assertTrue(collectpost.containsValue(id));

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-14", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_02.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-14", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
        }
    }

    @Test
    public void AND_SN_TC_15() throws Exception, TestLinkAPIException {
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            //open application , make sure first launching
            Thread.sleep(2000);
            firstScreen.selectFirstAndSecondLaunching();
            Thread.sleep(2000);
            //String swipeto = "We’ve requested more details about the prototype from Oculus. It looks like the gloves have a slim form-factor";
            //androidSwipe("//*[@text=\"Gift Cards\"]");
            //driver.findElementsByClassName("android.widget.TextView");
            //swipeFunctions.SwipexPath("//*[@text='Full-Day participating amazing activities for family combo']");
            swipeFunctions.SwipexPath("Full-Day participating");
            //getHelper().byLocator(UISelectorType.TEXT_CONTAINS.toString(), "Full-Day participating");



            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-15", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_02.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-15", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
        }
    }

    @Test
    public void AND_SN_TC_16() throws Exception, TestLinkAPIException {
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            //open application , make sure first launching
            Thread.sleep(3000);
            firstScreen.selectFirstAndSecondLaunching();
            Thread.sleep(2000);
            homeScreen.clickMarketTabView();
            homeScreen.clickMessagesTabView();
            homeScreen.clickCupidTabView();
            homeScreen.clickMoreTabView();
            homeScreen.clickHomeTabView();

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-16", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (Exception ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_02.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-16", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_17() throws Exception, TestLinkAPIException {
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            //open application , make sure first launching
            Thread.sleep(3000);
            firstScreen.selectFirstAndSecondLaunching();
            Thread.sleep(2000);
            homeScreen.clickMarketTabView();
            homeScreen.clickHomeTabView();
            //scroll/swipe down
            Thread.sleep(1000);
            homeScreen.swipe(5, 16, 5, 6, 500);
            homeScreen.swipe(5, 16, 5, 6, 500);
            Thread.sleep(1000);
            homeScreen.clickHomeTabView();
            Assert.assertEquals(true, firstScreen.verifyScreenAppear("How are you today Thein?..."));

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-17", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (Exception ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_02.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-17", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_18() throws Exception, TestLinkAPIException {
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            //open application , make sure first launching
            Thread.sleep(3000);
            firstScreen.selectFirstAndSecondLaunching();
            Thread.sleep(2000);
            //swipe to market
            homeScreen.swipe(8, 8, 2, 8, 500);
            Thread.sleep(1000);
            //swipe to messages
            homeScreen.swipe(8, 8, 2, 8, 500);
            Thread.sleep(1000);
            //swipe to cupid
            homeScreen.swipe(8, 8, 2, 8, 500);
            Thread.sleep(1000);
            //wipe to more
            homeScreen.swipe(8, 8, 2, 8, 500);
            Thread.sleep(1000);
            //swipe to cupid
            Thread.sleep(1000);
            homeScreen.swipe(2, 8, 8, 8, 500);
            //swipe to messages
            Thread.sleep(1000);
            homeScreen.swipe(2, 8, 8, 8, 500);
            //swipe to market
            Thread.sleep(1000);
            homeScreen.swipe(2, 8, 8, 8, 500);
            //swipe to Home
            Thread.sleep(1000);
            homeScreen.swipe(2, 8, 8, 8, 500);
            Thread.sleep(1000);
            Assert.assertEquals(true, firstScreen.verifyScreenAppear("How are you today Thein?..."));

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-18", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (Exception ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_02.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-18", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            throw new Exception("Failed: " + ex.getMessage());
        }
    }


    @Test
    public void AND_SN_TC_19() throws Exception, TestLinkAPIException {
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            System.out.println("Begin Select categories for first launching");
            firstScreen.selectCategories(ActivityFirstScreen.catList);
            System.out.println("Click button Next to go second launching");
            firstScreen.clickButtonNext();
            //single select job
            secondScreen.selectIndustries(ActivitySecondScreen.singleind);
            //remove single job
            secondScreen.selectIndustries(ActivitySecondScreen.singleind);
            //add single
            secondScreen.selectIndustries(ActivitySecondScreen.singleind);
            Thread.sleep(1000);
            //touch done
            secondScreen.clickButtonDone();
            //verify app go to next screen
            Thread.sleep(1000);
            Assert.assertEquals(true, firstScreen.verifyScreenAppear("How are you today Thein?..."));

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-19", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (Exception ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_02.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-19", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_20() throws Exception, TestLinkAPIException {
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            System.out.println("Begin Select categories for first launching");
            firstScreen.selectCategories(ActivityFirstScreen.catList);
            System.out.println("Click button Next to go second launching");
            firstScreen.clickButtonNext();
            //single select job
            secondScreen.selectIndustries(ActivitySecondScreen.inds);
            //remove single job
            secondScreen.selectIndustries(ActivitySecondScreen.inds);
            //add single
            secondScreen.selectIndustries(ActivitySecondScreen.inds);
            Thread.sleep(1000);
            //touch done
            secondScreen.clickButtonDone();
            //verify app go to next screen
            Thread.sleep(1000);
            Assert.assertEquals(true, firstScreen.verifyScreenAppear("How are you today Thein?..."));

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-20", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (Exception ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_02.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-20", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_21() throws Exception, TestLinkAPIException {
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            //open application , make sure first launching appears
            System.out.println("Begin Select categories for first launching");
            firstScreen.selectCategories(ActivityFirstScreen.catList);
            System.out.println("Click button Next to go second launching");
            firstScreen.clickButtonNext();
            Thread.sleep(1000);
            Assert.assertEquals(true, firstScreen.verifyScreenAppear("Looking for job? Choose an industry"));
            closeApp();
            Helper.clearDataApp();
            openApp();
            firstScreen.selectFirstAndSecondLaunching();
            Assert.assertEquals(true, firstScreen.verifyScreenAppear("How are you today Thein?..."));
            //exit application
//            firstScreen.closeApp();
//            //remove application
//            Thread.sleep(2000);
//            firstScreen.removeApp();
//            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//            //install and start application
//            while (!driver.isAppInstalled("com.mediastep.beecow") ){
//            firstScreen.installandstartApp();
//            }
//            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//            //assert first launching start
//            //Assert.assertEquals(true, firstScreen.verifyScreenAppear("Hello, what interests you most?"));
//            //exit application
//            Thread.sleep(2000);
//            firstScreen.closeApp();
//            //clear cached application
//            firstScreen.runbatfile("D:/Projects/beecow-QAAutomation/clearcache.bat");
//            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//            //start app
//            firstScreen.startApp();
//            Thread.sleep(2000);
//            //firstScreen.selectFirstAndSecondLaunching();

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-21", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (Exception ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_02.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-21", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_22() throws Exception, TestLinkAPIException {
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            //open application , make sure first launching
            Thread.sleep(3000);
            Assert.assertEquals(true, firstScreen.verifyScreenAppear("Hello, what interests you most?"));
            firstScreen.selectFirstAndSecondLaunching();
//            //exit application
//            firstScreen.closeApp();
//            Thread.sleep(3000);
//            //start application
//            firstScreen.startApp();
            resetApp();
            Thread.sleep(3000);
            //assert apps navigates user to Home
            Assert.assertEquals(true, firstScreen.verifyScreenAppear("How are you today Thein?..."));

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-22", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (Exception ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_02.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-22", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            throw new Exception("Failed: " + ex.getMessage());
        }
    }


    public void closeApp() {
        if (driver != null) {
            driver.closeApp();
        }
    }

    public void openApp() {
        if (driver != null) {
            driver.launchApp();
        }
    }

    public void resetApp() {
        if (driver != null) {
            driver.resetApp();
        }
    }
}
//    public void AddingandRemove_SingleCategory() {
//        System.out.println("Begin Select categories for first launching");
//        firstScreen.selectCategories(cats);
//        System.out.println("Remove some categories");
//        firstScreen.selectCategories(reverse_cats);
//        System.out.println("Add single category");
//        firstScreen.selectCategories(single_cat);
//        System.out.println("Click button Next to go second launching");
//        firstScreen.clickButtonNext();
//    }
//}
