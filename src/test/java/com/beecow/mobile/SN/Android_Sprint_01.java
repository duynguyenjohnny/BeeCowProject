package com.beecow.mobile.SN;

import com.beecow.component.BaseTest;
import com.beecow.screen.ActivityFirstScreen;
import com.beecow.screen.ActivitySecondScreen;
import com.beecow.screen.HomeScreen;
import com.beecow.screen.MarketScreen;
import com.beecow.utils.TestLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

import java.io.File;


public class SNTest extends BaseTest {

    String className = this.getClass().getSimpleName();
    private ActivityFirstScreen firstScreen;
    private ActivitySecondScreen secondScreen;
    private HomeScreen homeScreen;
    private MarketScreen marketScreen;
    
    static String marketPropertiesFile = "SN.properties";

    // DATA TEST
    String cats[] = {"Sport", "Computer", "Meal Deals"};
    String catList[] = {"Men's Fashion", "Women's Fashion", "Mobile & Tablet", "Computer", "Camera & TV", "Home & Living", "Mom & Kids", "Health & Beauty", "Sport", "Meal Deals", "Spa Deals", "Entertainment Deals", "Travel Deals"};
    String inds[] = {"Consulting", "Design", "Education"};
    String indList[] = {"Accounting & Auditing Services", "Advertising & Public RelationstAds & PR", "Agriculture/Forestry/Fishing", "Airlines & Aviation", "Architecture", "Automotive", "Banking", "Beauty/Cosmetics", "Biotechnology/Pharmaceuticals", "Broadcasting/Music/Film", "Chemical/Petro-chemical", "Clothing & Textile Manufacturing", "Computer/IT", "Construction", "Consulting", "Design", "Distribution/Logistics", "Education", "Energy/Utilities", "Engineering", "Financial Services", "Food/Beverage Production", "Government", "Healthcare Services", "Hotels/Lodging", "Import/Export/Trade", "Insurance", "Internet Services", "Legal Services", "Manufacturing", "Medical/Hospital", "NGO/INGO/Non-profit", "Performing Arts/Fine Arts", "Personal & Household Services", "Printing/Publishing", "Real Estate/Property", "Recruitment Agencies", "Restaurant/Food Services", "Retail", "Security/Surveillance", "Social Services", "Sports/Physical Recreation", "Telecommunications Services", "Tourism/Travel Services", "Transportation & Storage"};

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp(marketPropertiesFile);

        firstScreen = new ActivityFirstScreen(driver);
        secondScreen = new ActivitySecondScreen(driver);
        homeScreen = new HomeScreen(driver);
    }

    @Test
    public void SN_01() throws Exception, TestLinkAPIException {
        String sMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
        try{
            selectFirstSecondLaunchingAndGoToProfilePage();

            TestLink.updateResult(Testlink_ProjectName,Testlink_TestPlanName, "AND_SN_TC-45", Testlink_BuildName, null, TestLinkAPIResults.TEST_PASSED);
        }catch (TestLinkAPIException ex){
            System.out.print("Can't update result to Testlink ");
        }
        catch (Exception ex) {
            //Test failed
            getHelper().takeScreenshot("SN", className, "Failed_", sMethodName);
            System.out.println("Current working dir: " + new File(SNTest.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            TestLink.updateResult(Testlink_ProjectName, Testlink_TestPlanName, "AND_SN_TC-45", Testlink_BuildName, null, TestLinkAPIResults.TEST_FAILED);
            throw new Exception("Failed: " + ex.getMessage());
        }
    }

    public void selectFirstSecondLaunchingAndGoToProfilePage() {
        System.out.println("Begin Select categories for first launching");
        firstScreen.selectCategories(cats);
        System.out.println("Click button Next to go second launching");
        firstScreen.clickButtonNext();
        System.out.println("Next select industries");
        secondScreen.selectIndustries(inds);
        System.out.println("Then click button Done");
        secondScreen.clickButtonDone();
        System.out.println("Click Market Tab view to go Market Overview page");
        homeScreen.clickMarketTabView();
    }
}
