package com.beecow.mobile.SN;

import com.beecow.component.BaseTest;
import com.beecow.screen.ActivityFirstScreen;
import com.beecow.screen.ActivitySecondScreen;
import com.beecow.screen.HomeScreen;
import com.beecow.screen.MarketScreen;
import com.beecow.utils.API;
import com.beecow.utils.Helper;
import com.beecow.utils.TestLink;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

import java.io.File;


public class Android_Sprint_02 extends BaseTest {

    String className = this.getClass().getSimpleName();
    private ActivityFirstScreen firstScreen;
    private ActivitySecondScreen secondScreen;
    private HomeScreen homeScreen;
    private API api;
    private MarketScreen marketScreen;

    static String SNPropertiesFileSprint2 = "SN.properties";

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp(SNPropertiesFileSprint2);

        firstScreen = new ActivityFirstScreen(driver);
        secondScreen = new ActivitySecondScreen(driver);
        homeScreen = new HomeScreen(driver);
    }

    /*
     AND_SN_TC_12:Verify color dot appears and displays orange color
     AND_SN_TC_13 Verify adding/removing multiple categories in first launching
     AND_SN_TC_14 Verify adding categories feature only appear in first launching
     AND_SN_TC_15 Verify adding categories feature does not appear in second launching
     */
    @Test
    public void AND_SN_TC_012() throws Exception, TestLinkAPIException {
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            firstScreen.selectFirstAndSecondLaunching();
            Thread.sleep(1000);
            System.out.println("Create a post as status type");
            api.poststatuspuretext();
            Thread.sleep(1000);
            api.postnewfeeds();
            Thread.sleep(2000);
            homeScreen.swipe(6,6,6,12,100);
            Assert.assertEquals(true,getHelper().isElementById(homeScreen.colordot));


            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-12", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (Exception ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_02.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-12", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_13() throws Exception, TestLinkAPIException {
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            //AddingandRemove_SingleCategory();
            // Assert.assertEquals(,true);
            System.out.println("Begin Select categories for first launching");
            firstScreen.selectCategories(ActivityFirstScreen.cats);
            System.out.println("Remove some categories");
            firstScreen.selectCategories(ActivityFirstScreen.reverse_cats);
            System.out.println("add multiple categories");
            firstScreen.selectCategories(ActivityFirstScreen.catList);
            System.out.println("Click button Next to go second launching");
            firstScreen.clickButtonNext();
            //verify app go to next screen
            Assert.assertEquals(true, firstScreen.verifyScreenAppear("Looking for job? Choose an industry"));
            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-13", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (Exception ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_02.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-13", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_14() throws Exception, TestLinkAPIException {
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            //open application , make sure first launching appears
            Thread.sleep(3000);
            Assert.assertEquals(true, firstScreen.verifyScreenAppear("Hello, what interests you most?"));
            firstScreen.selectFirstAndSecondLaunching();
            //exit application
//            firstScreen.closeApp();
//            //remove application
//            firstScreen.removeApp();
//            //install and start application
//            firstScreen.installandstartApp();
//            //assert first launching start
//            Assert.assertEquals(true, firstScreen.verifyScreenAppear("Hello, what interests you most?"));
//            firstScreen.selectFirstAndSecondLaunching();
//            //exit application
//            firstScreen.closeApp();
//            //clear cached application
//            firstScreen.runbatfile("D:/Projects/beecow-QAAutomation/clearcache.bat");
//            //start app
//            firstScreen.startApp();
//            Assert.assertEquals(true, firstScreen.verifyScreenAppear("Hello, what interests you most?"));
//            firstScreen.selectFirstAndSecondLaunching();

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-14", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (Exception ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_02.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-14", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_15() throws Exception, TestLinkAPIException {
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            //open application , make sure first launching
            Thread.sleep(3000);
            Assert.assertEquals(true, firstScreen.verifyScreenAppear("Hello, what interests you most?"));
            firstScreen.selectFirstAndSecondLaunching();
            //exit application
//            firstScreen.closeApp();
//            //start application
//            firstScreen.startApp();
//            //assert apps navigates user to Home
//            Assert.assertEquals(true, firstScreen.verifyScreenAppear("How are you today Thein?..."));

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-15", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (Exception ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_02.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-15", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            throw new Exception("Failed: " + ex.getMessage());
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
