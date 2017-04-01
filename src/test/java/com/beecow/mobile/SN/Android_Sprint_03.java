package com.beecow.mobile.SN;

import com.beecow.component.BaseTest;
import com.beecow.screen.ActivityFirstScreen;
import com.beecow.screen.ActivitySecondScreen;
import com.beecow.screen.HomeScreen;
import com.beecow.screen.MarketScreen;
import com.beecow.utils.APIData;
import com.beecow.utils.APIUtil;
import com.beecow.utils.SwipeFunctions;
import com.beecow.utils.TestLink;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

import java.io.File;

import static com.beecow.utils.Helper.addLog;


public class Android_Sprint_03 extends BaseTest {

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

     Home - Photo's gestures
     AND_SN_TC_34:Verify touch a photo to enter full screen mode - single photo posting
     AND_SN_TC_35:Verify actions in full screen mode - single photo posting
     AND_SN_TC_36:Verify touch a photo to enter full screen mode - multiple photos posting
     AND_SN_TC_37:Verify actions in full screen mode - multiple photos posting

     Home - Status: link and text
     AND_SN_TC_38:Verify displaying of link and test - Link has thumbnail photo
     AND_SN_TC_39:Verify displaying of link and test - Link has no thumbnail photo
     AND_SN_TC_40:Verify displaying of link and test - more than 1 Link

     Home - Status: Photos and link and text
     AND_SN_TC_41:Verify posting single photo and link and texts
     AND_SN_TC_42:Verify posting multi photos and link and texts

     Home - Selling: Selling product by shop
     AND_SN_TC_43:Verify selling product by shop on posting - Product with discount
     AND_SN_TC_44:Verify selling product by shop on posting - Product without discount

     Home - Selling: Selling product by user
     AND_SN_TC_45:Verify selling product by user on posting

     */
    @Test
    public void AND_SN_TC_34() throws Exception, TestLinkAPIException {
        addLog("AND_SN_TC_34:Verify touch a photo to enter full screen mode - single photo posting");
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            Thread.sleep(1000);
            firstScreen.selectFirstAndSecondLaunching();
            Thread.sleep(1000);
            System.out.println("Create a post as status type");
            String requestBodyStatus = jsonData.get(APIData.ADD_NEW_STATUS).toString();
            JSONObject poststatus = APIUtil.sendPost(APIData.POST_STATUS_CA, requestBodyStatus);
            //System.out.println(poststatus);
            //api.poststatuspuretext();
            Thread.sleep(3000);
            Assert.assertEquals(poststatus.get("content").toString(), "@1111 Automation Add New Status Pure Text");
            //requestResult.get("Response Code").toString();
            //api.postnewfeeds();
            Thread.sleep(2000);
            JSONObject collectpost = APIUtil.sendPost(APIData.POST_FEEDS_CA, "");
            //Assert.assertEquals(collectpost.get("content").toString(), "200");
            Thread.sleep(2000);

            homeScreen.swipe(6, 6, 6, 12, 100);
            Assert.assertEquals(true, getHelper().isElementById(homeScreen.colordot));
            Assert.assertEquals(true, getHelper().isElementById(homeScreen.uploadtime));

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-12", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-12", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new AssertionError("Failed: " + ex.getMessage());
        } catch (Exception ex){
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-12", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_13() throws Exception, TestLinkAPIException {
        addLog("AND_SN_TC_13 Verify upload time notification should appear and display \"Just now\"");
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            //da check o AND_SN_TC_12
            Thread.sleep(3000);
            Assert.assertEquals(true, true);

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-13", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-13", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new AssertionError("Failed: " + ex.getMessage());
        } catch (Exception ex){
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-13", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new Exception("Failed: " + ex.getMessage());
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
            long expectdate = current - (600000);

            String CreateDate10minutes = homeScreen.getDatefromMili(expectdate, "yyyy-MM-dd_HH:mm:ss/").toString();
            String newText = CreateDate10minutes.replace("_", "T");
            // Date Expect time with format yyyy-MM-ddTHH:mm:ssZ
            String ExpectDate10minutes = newText.replace("/", "Z");
            //DateTimeFormatter currentdate = DateTimeFormat.forPattern("yyyy-MM-ddTHH:mm:ssZ");
            //DateTimeFormatter  expectdate = currentdate - 600000;
            //Calendar date = Calendar.getInstance();
            /*
            currentdate - x = createdate
            2017-02-10T07:51:27Z
            1489569579141
            1489568979141
            */

            String request = "{\"title\": \"Automation time upload 1 to 59 minutes\",\"content\": \"@1111 Automation time upload 1 to 59 minutes\",\"author\": {\"userId\": 2,\"displayName\": \"Long Long\",\"avatarUrl\": \"feed/images/feed3048\"},\"statusType\": \"TEXT\",\"mentionedUsers\": [{\"userId\": 1111,\"displayName\": \"Long Nguyen\",\"avatarUrl\": \"feed/images/feed3048\",\"mentioned\": true}],\"createdDate\":";
            String requestBodyStatus = request + "\"" + ExpectDate10minutes + "\"}";
            System.out.print(requestBodyStatus);
            JSONObject poststatus = APIUtil.sendPost(APIData.POST_STATUS_CA, requestBodyStatus);
            Thread.sleep(3000);
            String id = poststatus.get("id").toString();

            Thread.sleep(3000);
            JSONObject collectpost = APIUtil.sendPost(APIData.POST_FEEDS_CA, "");
            Thread.sleep(3000);
            String getfeeds = APIUtil.sendGetString(APIData.GET_FEEDS_CA);
            System.out.println("Getfeeds "+ getfeeds);
            Assert.assertTrue(getfeeds.contains("\"feedId\":" +id));

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-14", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-14", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new AssertionError("Failed: " + ex.getMessage());
        } catch (Exception ex){
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-14", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_15() throws Exception, TestLinkAPIException {
        addLog("AND_SN_TC_15 Verify upload time notification should appear and display \"1 hr\" to \"24 hrs\"");
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
            //swipeFunctions.SwipexPath("Full-Day participating");
            //getHelper().byLocator(UISelectorType.TEXT_CONTAINS.toString(), "Full-Day participating");


            //Verify upload time notification display "x hr(s)" when user posts status on x =1 to 23 hours 59 minutes later.
            long current = System.currentTimeMillis();
            // 10800000 = 3hrs
            long expectdate = current - (10800000);
            String CreateDate10minutes = homeScreen.getDatefromMili(expectdate, "yyyy-MM-dd_HH:mm:ss/").toString();
            String newText = CreateDate10minutes.replace("_", "T");
            // Date Expect time with format yyyy-MM-ddTHH:mm:ssZ
            String ExpectDate10minutes = newText.replace("/", "Z");

            String request = "{\"title\": \"Automation time upload 1 hour to 23 hours 59 minutes\",\"content\": \"@1111 Automation time upload 1 hour to 23 hours 59 minutes\",\"author\": {\"userId\": 2,\"displayName\": \"Long Long\",\"avatarUrl\": \"feed/images/feed3048\"},\"statusType\": \"TEXT\",\"mentionedUsers\": [{\"userId\": 1111,\"displayName\": \"Long Nguyen\",\"avatarUrl\": \"feed/images/feed3048\",\"mentioned\": true}],\"createdDate\":";
            String requestBodyStatus = request + "\"" + ExpectDate10minutes + "\"}";
            System.out.print(requestBodyStatus);
            JSONObject poststatus = APIUtil.sendPost(APIData.POST_STATUS_CA, requestBodyStatus);
            Thread.sleep(3000);
            String id = poststatus.get("id").toString();

            Thread.sleep(3000);
            JSONObject collectpost = APIUtil.sendPost(APIData.POST_FEEDS_CA, "");
            Thread.sleep(3000);
            String getfeeds = APIUtil.sendGetString(APIData.GET_FEEDS_CA);
            System.out.println("Getfeeds "+ getfeeds);
            Assert.assertTrue(getfeeds.contains("\"feedId\":" +id));

            //Verify upload time notification display as "Yesterday" when user posts status on x = 24hours later.
            long current1 = System.currentTimeMillis();
            // 86400000 = 24hrs
            long expectdate1 = current - (86400000);
            String CreateDate10minutes1 = homeScreen.getDatefromMili(expectdate1, "yyyy-MM-dd_HH:mm:ss/").toString();
            String newText1 = CreateDate10minutes1.replace("_", "T");
            // Date Expect time with format yyyy-MM-ddTHH:mm:ssZ
            String ExpectDate10minutes1 = newText1.replace("/", "Z");

            String request1 = "{\"title\": \"Automation time upload 24 hours and later\",\"content\": \"@1111 Automation time upload 24 hours and later\",\"author\": {\"userId\": 2,\"displayName\": \"Long Long\",\"avatarUrl\": \"feed/images/feed3048\"},\"statusType\": \"TEXT\",\"mentionedUsers\": [{\"userId\": 1111,\"displayName\": \"Long Nguyen\",\"avatarUrl\": \"feed/images/feed3048\",\"mentioned\": true}],\"createdDate\":";
            String requestBodyStatus1 = request1 + "\"" + ExpectDate10minutes1 + "\"}";
            System.out.print(requestBodyStatus);
            JSONObject poststatus1 = APIUtil.sendPost(APIData.POST_STATUS_CA, requestBodyStatus1);
            Thread.sleep(3000);
            String id1 = poststatus1.get("id").toString();

            Thread.sleep(3000);
            JSONObject collectpost1 = APIUtil.sendPost(APIData.POST_FEEDS_CA, "");
            Thread.sleep(3000);
            String getfeeds1 = APIUtil.sendGetString(APIData.GET_FEEDS_CA);
            System.out.println("Getfeeds "+ getfeeds1);
            Assert.assertTrue(getfeeds1.contains("\"feedId\":" +id1));


            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-15", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-15", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new AssertionError("Failed: " + ex.getMessage());
        } catch (Exception ex){
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-15", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_16() throws Exception, TestLinkAPIException {
        addLog("AND_SN_TC_16 Verify upload time notification should appear and display \"Yesterday at hh:mm\"");
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            //open application , make sure first launching
            Thread.sleep(2000);
            Assert.assertEquals(true, true);

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-16", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-16", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new AssertionError("Failed: " + ex.getMessage());
        } catch (Exception ex){
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-16", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_17() throws Exception, TestLinkAPIException {
        addLog("AND_SN_TC_17 Verify upload time notification should appear and display\"x d\"");
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            //open application , make sure first launching
            Thread.sleep(3000);
            firstScreen.selectFirstAndSecondLaunching();
            Thread.sleep(2000);
            long current = System.currentTimeMillis();
            // 432000000 = 5 days
            long expectdate = current - (432000000);
            String CreateDate10minutes = homeScreen.getDatefromMili(expectdate, "yyyy-MM-dd_HH:mm:ss/").toString();
            String newText = CreateDate10minutes.replace("_", "T");
            // Date Expect time with format yyyy-MM-ddTHH:mm:ssZ
            String ExpectDate10minutes = newText.replace("/", "Z");

            String request = "{\"title\": \"Automation time upload 2 to 10 days\",\"content\": \"@1111 Automation time upload 2 to 10 days\",\"author\": {\"userId\": 2,\"displayName\": \"Long Long\",\"avatarUrl\": \"feed/images/feed3048\"},\"statusType\": \"TEXT\",\"mentionedUsers\": [{\"userId\": 1111,\"displayName\": \"Long Nguyen\",\"avatarUrl\": \"feed/images/feed3048\",\"mentioned\": true}],\"createdDate\":";
            String requestBodyStatus = request + "\"" + ExpectDate10minutes + "\"}";
            System.out.print(requestBodyStatus);
            JSONObject poststatus = APIUtil.sendPost(APIData.POST_STATUS_CA, requestBodyStatus);
            Thread.sleep(2000);
            String id = poststatus.get("id").toString();

            Thread.sleep(2000);
            JSONObject collectpost = APIUtil.sendPost(APIData.POST_FEEDS_CA, "");
            Thread.sleep(2000);
            String getfeeds = APIUtil.sendGetString(APIData.GET_FEEDS_CA);
            System.out.println("Getfeeds "+ getfeeds);
            Assert.assertTrue(getfeeds.contains("\"feedId\":" +id));

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-17", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-17", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new AssertionError("Failed: " + ex.getMessage());
        } catch (Exception ex){
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-17", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_18() throws Exception, TestLinkAPIException {
        addLog("AND_SN_TC_18 Verify upload time notification should appear and display \"Mmm dd\"");
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            //open application , make sure first launching
            Thread.sleep(2000);
            firstScreen.selectFirstAndSecondLaunching();
            Thread.sleep(2000);
            long current = System.currentTimeMillis();
            // 3628800000 = 42 days , add L to end of number to reach max long
            long fourtytwodays = 3628800000L;
            long expectdate = current - fourtytwodays;
            String CreateDate10minutes = homeScreen.getDatefromMili(expectdate, "yyyy-MM-dd_HH:mm:ss/").toString();
            String newText = CreateDate10minutes.replace("_", "T");
            // Date Expect time with format yyyy-MM-ddTHH:mm:ssZ
            String ExpectDate10minutes = newText.replace("/", "Z");

            String request = "{\"title\": \"Automation time upload 11 to 365 days\",\"content\": \"@1111 Automation time upload 11 to 365 days\",\"author\": {\"userId\": 2,\"displayName\": \"Long Long\",\"avatarUrl\": \"feed/images/feed3048\"},\"statusType\": \"TEXT\",\"mentionedUsers\": [{\"userId\": 1111,\"displayName\": \"Long Nguyen\",\"avatarUrl\": \"feed/images/feed3048\",\"mentioned\": true}],\"createdDate\":";
            String requestBodyStatus = request + "\"" + ExpectDate10minutes + "\"}";
            System.out.print(requestBodyStatus);
            JSONObject poststatus = APIUtil.sendPost(APIData.POST_STATUS_CA, requestBodyStatus);
            Thread.sleep(2000);
            String id = poststatus.get("id").toString();

            Thread.sleep(2000);
            JSONObject collectpost = APIUtil.sendPost(APIData.POST_FEEDS_CA, "");
            Thread.sleep(2000);
            String getfeeds = APIUtil.sendGetString(APIData.GET_FEEDS_CA);
            System.out.println("Getfeeds "+ getfeeds);
            Assert.assertTrue(getfeeds.contains("\"feedId\":" +id));

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-18", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-18", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new AssertionError("Failed: " + ex.getMessage());
        } catch (Exception ex){
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-18", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new Exception("Failed: " + ex.getMessage());
        }
    }


    @Test
    public void AND_SN_TC_19() throws Exception, TestLinkAPIException {
        addLog("AND_SN_TC_19 Verify upload time notification should appear and display as \"Mmm dd, yyyy\" for last year backwards");
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            //open application , make sure first launching
            Thread.sleep(3000);
            firstScreen.selectFirstAndSecondLaunching();
            Thread.sleep(2000);
            long current = System.currentTimeMillis();
            // 3628800000 = 42 days , add L to end of number to reach max long
            double fourtytwodays = 6.3072e+10;
            long expectdate = current - (long) fourtytwodays;
            String CreateDate10minutes = homeScreen.getDatefromMili(expectdate, "yyyy-MM-dd_HH:mm:ss/").toString();
            String newText = CreateDate10minutes.replace("_", "T");
            // Date Expect time with format yyyy-MM-ddTHH:mm:ssZ
            String ExpectDate10minutes = newText.replace("/", "Z");

            String request = "{\"title\": \"Automation time upload more than 365 days\",\"content\": \"@1111 Automation time upload more than 365 days\",\"author\": {\"userId\": 2,\"displayName\": \"Long Long\",\"avatarUrl\": \"feed/images/feed3048\"},\"statusType\": \"TEXT\",\"mentionedUsers\": [{\"userId\": 1111,\"displayName\": \"Long Nguyen\",\"avatarUrl\": \"feed/images/feed3048\",\"mentioned\": true}],\"createdDate\":";
            String requestBodyStatus = request + "\"" + ExpectDate10minutes + "\"}";
            System.out.print(requestBodyStatus);
            JSONObject poststatus = APIUtil.sendPost(APIData.POST_STATUS_CA, requestBodyStatus);
            Thread.sleep(2000);
            String id =  poststatus.get("id").toString();
            System.out.print("getID " + id);

            Thread.sleep(2000);
            JSONObject collectpost = APIUtil.sendPost(APIData.POST_FEEDS_CA, "");
            Thread.sleep(2000);
            // getfeeds = APIUtil.sendGet(APIData.GET_FEEDS_CA);
            String getfeeds = APIUtil.sendGetString(APIData.GET_FEEDS_CA);
            System.out.println("Getfeeds "+ getfeeds);
            Assert.assertTrue(getfeeds.contains("\"feedId\":" +id));

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-19", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-19", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new AssertionError("Failed: " + ex.getMessage());
        } catch (Exception ex){
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-19", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_20() throws Exception, TestLinkAPIException {
        addLog("AND_SN_TC_20 Verify input texts below 5 rows");
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            Thread.sleep(3000);
            firstScreen.selectFirstAndSecondLaunching();
            Thread.sleep(2000);

            String request = "{\"title\": \"Automation Verify input texts below 5 rows\",\"content\": \"@1111 Automation Verify input texts below 5 rows\",\"author\": {\"userId\": 2,\"displayName\": \"Long Long\",\"avatarUrl\": \"feed/images/feed3048\"},\"statusType\": \"TEXT\",\"mentionedUsers\": [{\"userId\": 1111,\"displayName\": \"Long Nguyen\",\"avatarUrl\": \"feed/images/feed3048\",\"mentioned\": true}]}";
            JSONObject poststatus = APIUtil.sendPost(APIData.POST_STATUS_CA, request);
            Thread.sleep(3000);
            String id = poststatus.get("id").toString();

            Thread.sleep(3000);
            JSONObject collectpost = APIUtil.sendPost(APIData.POST_FEEDS_CA, "");
            Thread.sleep(3000);
            String getfeeds = APIUtil.sendGetString(APIData.GET_FEEDS_CA);
            System.out.println("Getfeeds "+ getfeeds);
            Assert.assertTrue(getfeeds.contains("\"feedId\":" +id));


            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-20", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-20", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new AssertionError("Failed: " + ex.getMessage());
        } catch (Exception ex){
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-20", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_21() throws Exception, TestLinkAPIException {
        addLog("AND_SN_TC_21 Verify input texts within 5 to 15 rows");
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            //open application , make sure first launching appears
            Thread.sleep(3000);
            firstScreen.selectFirstAndSecondLaunching();
            Thread.sleep(2000);

            String request = "{\"title\": \"Automation Verify input within 5 to 15 rows texts\",\"content\": \"@1111 Automation Verify input within 5 to 15 rows texts Automation Verify input within 5 to 15 rows texts Automation Verify input within 5 to 15 rows texts Automation Verify input within 5 to 15 rows texts Automation Verify input within 5 to 15 rows texts Automation Verify input within 5 to 15 rows texts\",\"author\": {\"userId\": 2,\"displayName\": \"Long Long\",\"avatarUrl\": \"feed/images/feed3048\"},\"statusType\": \"TEXT\",\"mentionedUsers\": [{\"userId\": 1111,\"displayName\": \"Long Nguyen\",\"avatarUrl\": \"feed/images/feed3048\",\"mentioned\": true}]}";
            JSONObject poststatus = APIUtil.sendPost(APIData.POST_STATUS_CA, request);
            Thread.sleep(2000);
            String id = poststatus.get("id").toString();

            Thread.sleep(2000);
            JSONObject collectpost = APIUtil.sendPost(APIData.POST_FEEDS_CA, "");
            Thread.sleep(2000);
            String getfeeds = APIUtil.sendGetString(APIData.GET_FEEDS_CA);
            System.out.println("Getfeeds "+ getfeeds);
            Assert.assertTrue(getfeeds.contains("\"feedId\":" +id));


            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-21", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-21", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new AssertionError("Failed: " + ex.getMessage());
        } catch (Exception ex){
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-21", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_22() throws Exception, TestLinkAPIException {
        addLog("AND_SN_TC_22 Verify input texts more than 15 rows");
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            Thread.sleep(2000);
            firstScreen.selectFirstAndSecondLaunching();
            Thread.sleep(2000);

            String request = "{\"title\": \"Automation Verify input texts more than 15 rows\",\"content\": \"@1111 Automation Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows Verify input texts more than 15 rows\",\"author\": {\"userId\": 2,\"displayName\": \"Long Long\",\"avatarUrl\": \"feed/images/feed3048\"},\"statusType\": \"TEXT\",\"mentionedUsers\": [{\"userId\": 1111,\"displayName\": \"Long Nguyen\",\"avatarUrl\": \"feed/images/feed3048\",\"mentioned\": true}]}";
            JSONObject poststatus = APIUtil.sendPost(APIData.POST_STATUS_CA, request);
            Thread.sleep(2000);
            String id = poststatus.get("id").toString();

            Thread.sleep(2000);
            JSONObject collectpost = APIUtil.sendPost(APIData.POST_FEEDS_CA, "");
            Thread.sleep(2000);
            String getfeeds = APIUtil.sendGetString(APIData.GET_FEEDS_CA);
            System.out.println("Getfeeds "+ getfeeds);
            Assert.assertTrue(getfeeds.contains("\"feedId\":" +id));

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-22", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-22", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new AssertionError("Failed: " + ex.getMessage());
        } catch (Exception ex){
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-22", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new Exception("Failed: " + ex.getMessage());
        }
    }

    @Test
    public void AND_SN_TC_23() throws Exception, TestLinkAPIException {
        addLog("AND_SN_TC_23:Verify mention friend feature on posting status");
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        try {
            Thread.sleep(3000);
            firstScreen.selectFirstAndSecondLaunching();
            Thread.sleep(2000);

            String request = "{\"title\": \"Automation Verify mention friend feature on posting status\",\"content\": \"@1111 Automation Verify mention friend feature on posting status\",\"author\": {\"userId\": 2,\"displayName\": \"Long Long\",\"avatarUrl\": \"feed/images/feed3048\"},\"statusType\": \"TEXT\",\"mentionedUsers\": [{\"userId\": 1111,\"displayName\": \"Long Nguyen\",\"avatarUrl\": \"feed/images/feed3048\",\"mentioned\": true}]}";
            JSONObject poststatus = APIUtil.sendPost(APIData.POST_STATUS_CA, request);
            Thread.sleep(3000);
            String id = poststatus.get("id").toString();

            Thread.sleep(3000);
            JSONObject collectpost = APIUtil.sendPost(APIData.POST_FEEDS_CA, "");
            Thread.sleep(3000);
            String getfeeds = APIUtil.sendGetString(APIData.GET_FEEDS_CA);
            System.out.println("Getfeeds "+ getfeeds);
            Assert.assertTrue(getfeeds.contains("\"feedId\":" +id));

            //update if pass to testlink
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-23", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException ex) {
            System.out.print("Can't update result to Testlink ");
        } catch (AssertionError ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-23", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
            throw new AssertionError("Failed: " + ex.getMessage());
        } catch (Exception ex){
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(Android_Sprint_03.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-23", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            ex.printStackTrace();
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

