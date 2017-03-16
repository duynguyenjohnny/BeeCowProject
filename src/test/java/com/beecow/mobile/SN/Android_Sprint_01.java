package com.beecow.mobile.SN;

import com.beecow.component.BaseTest;
import com.beecow.screen.ActivityFirstScreen;
import com.beecow.screen.ActivitySecondScreen;
import com.beecow.screen.HomeScreen;
import com.beecow.screen.MarketScreen;
import com.beecow.utils.Helper;
import com.beecow.utils.TestLink;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Android_Sprint_01 extends BaseTest {

    String className = this.getClass().getSimpleName();
    private ActivityFirstScreen firstScreen;
    private ActivitySecondScreen secondScreen;
    private HomeScreen homeScreen;
    private MarketScreen marketScreen;

    static String SNPropertiesFileSprint1 = "SN.properties";

//    // DATA TEST
//    String cats[] = {"Sport", "Computer", "Meal Deals"};
//    String reverse_cats[] = {"Meal Deals", "Computer", "Sport"};
//    String single_cat[] = {"Meal Deals"};
//    String double_cats[] = {"Meal Deals", "Health & Beauty"};
//    String catList[] = {"Men's Fashion", "Women's Fashion", "Mobile & Tablet", "Computer", "Camera & TV", "Home & Living", "Mom & Kids", "Health & Beauty", "Sport", "Meal Deals", "Spa Deals", "Entertainment Deals", "Travel Deals"};
//    String inds[] = {"Consulting", "Design", "Education"};
//    String indList[] = {"Accounting & Auditing Services", "Advertising & Public RelationstAds & PR", "Agriculture/Forestry/Fishing", "Airlines & Aviation", "Architecture", "Automotive", "Banking", "Beauty/Cosmetics", "Biotechnology/Pharmaceuticals", "Broadcasting/Music/Film", "Chemical/Petro-chemical", "Clothing & Textile Manufacturing", "Computer/IT", "Construction", "Consulting", "Design", "Distribution/Logistics", "Education", "Energy/Utilities", "Engineering", "Financial Services", "Food/Beverage Production", "Government", "Healthcare Services", "Hotels/Lodging", "Import/Export/Trade", "Insurance", "Internet Services", "Legal Services", "Manufacturing", "Medical/Hospital", "NGO/INGO/Non-profit", "Performing Arts/Fine Arts", "Personal & Household Services", "Printing/Publishing", "Real Estate/Property", "Recruitment Agencies", "Restaurant/Food Services", "Retail", "Security/Surveillance", "Social Services", "Sports/Physical Recreation", "Telecommunications Services", "Tourism/Travel Services", "Transportation & Storage"};

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp(SNPropertiesFileSprint1);

        firstScreen = new ActivityFirstScreen(driver);
        secondScreen = new ActivitySecondScreen(driver);
        homeScreen = new HomeScreen(driver);
    }

    /*
     AND_SN_TC_1 Verify adding/removing single category in first launching
     AND_SN_TC_2 Verify adding/removing multiple categories in first launching
     AND_SN_TC_3 Verify adding categories feature only appear in first launching
     AND_SN_TC_4 Verify adding categories feature does not appear in second launching
     AND_SN_TC_5 Verify navigation between tabs on Main Frame
     AND_SN_TC_6:Verify in some "scroll-able" lists, user can touch on icon to move on top.
     AND_SN_TC_7:Verify swipe between tabs on Main Frame
     AND_SN_TC_8:Verify adding/removing single job in first launching
     AND_SN_TC_9:Verify adding/removing multiple Jobs in first launching
     AND_SN_TC_10:Verify adding jobs feature only appears in first launching
     AND_SN_TC_11:Verify adding jobs feature does not appear in second launching
     */
    @Test
    public void AND_SN_TC_01() throws Exception, TestLinkAPIException {
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            //AddingandRemove_SingleCategory();
            // Assert.assertEquals(,true);
            System.out.println("Begin Select categories for first launching");
            firstScreen.selectCategories(ActivityFirstScreen.cats);
            System.out.println("Remove some categories");
            firstScreen.selectCategories(ActivityFirstScreen.reverse_cats);
            System.out.println("Add single category");
            firstScreen.selectCategories(ActivityFirstScreen.single_cat);
            System.out.println("Click button Next to go second launching");
            firstScreen.clickButtonNext();
            System.out.println("Add double categories");
            firstScreen.selectCategories(ActivityFirstScreen.single_cat);
            firstScreen.selectCategories(ActivityFirstScreen.double_cats);
            System.out.println("Click button Next to go second launching");
            firstScreen.clickButtonNext();
            System.out.println("Add triple categories");
            firstScreen.selectCategories(ActivityFirstScreen.double_cats);
            firstScreen.selectCategories(ActivityFirstScreen.reverse_cats);
            System.out.println("Click button Next to go second launching");
            firstScreen.clickButtonNext();
            //assert second screen appear
            Assert.assertEquals(true, firstScreen.verifyScreenAppear("Looking for job? Choose an industry"));
            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-1", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_01.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-1", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            //throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_02() throws Exception, TestLinkAPIException {
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
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-2", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_01.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-2", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            //throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_03() throws Exception, TestLinkAPIException {
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
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-3", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_01.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-3", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            // throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_04() throws Exception, TestLinkAPIException {
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
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-4", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_01.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-4", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            //throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_05() throws Exception, TestLinkAPIException {
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
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-5", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_01.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-5", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            //throw new Exception("Failed: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Test
    public void AND_SN_TC_06() throws Exception, TestLinkAPIException {
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
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-6", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_01.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-6", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            //throw new Exception("Failed: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Test
    public void AND_SN_TC_07() throws Exception, TestLinkAPIException {
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
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-7", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_01.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-7", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            //throw new Exception("Failed: " + ex.getMessage());
            ex.printStackTrace();
        }
    }


    @Test
    public void AND_SN_TC_08() throws Exception, TestLinkAPIException {
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
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-8", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_01.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-8", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            //throw new Exception("Failed: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Test
    public void AND_SN_TC_09() throws Exception, TestLinkAPIException {
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
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-9", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_01.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-9", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            //throw new Exception("Failed: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Test
    public void AND_SN_TC_10() throws Exception, TestLinkAPIException {
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
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-10", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_01.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-10", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            //throw new Exception("Failed: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Test
    public void AND_SN_TC_11() throws Exception, TestLinkAPIException {
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
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-11", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_01.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-11", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            //throw new Exception("Failed: " + ex.getMessage());
            ex.printStackTrace();
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

    @Override
    protected void initData() {

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
