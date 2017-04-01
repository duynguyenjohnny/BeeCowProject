package com.beecow.screen;

import com.beecow.component.CommonScreenObjects;
import io.appium.java_client.AppiumDriver;

import static com.beecow.model.ActivityFristElement.getBtnNext;
import static com.beecow.model.ActivityFristElement.getCategoryLocatorByText;
import static com.beecow.model.ActivitySecondElement.*;


public class ActivitySecondScreen extends CommonScreenObjects {



    public ActivitySecondScreen(AppiumDriver driver){
        super(driver);
    }
    public static String[] singleind = {"Architecture"};
    public static String[] inds = {"Automotive", "Architecture", "Airlines & Aviation"};
    public static String[] indList = {"Accounting & Auditing Services", "Advertising & Public RelationstAds & PR", "Agriculture/Forestry/Fishing", "Airlines & Aviation", "Architecture", "Automotive", "Banking", "Beauty/Cosmetics", "Biotechnology/Pharmaceuticals", "Broadcasting/Music/Film", "Chemical/Petro-chemical", "Clothing & Textile Manufacturing", "Computer/IT", "Construction", "Consulting", "Design", "Distribution/Logistics", "Education", "Energy/Utilities", "Engineering", "Financial Services", "Food/Beverage Production", "Government", "Healthcare Services", "Hotels/Lodging", "Import/Export/Trade", "Insurance", "Internet Services", "Legal Services", "Manufacturing", "Medical/Hospital", "NGO/INGO/Non-profit", "Performing Arts/Fine Arts", "Personal & Household Services", "Printing/Publishing", "Real Estate/Property", "Recruitment Agencies", "Restaurant/Food Services", "Retail", "Security/Surveillance", "Social Services", "Sports/Physical Recreation", "Telecommunications Services", "Tourism/Travel Services", "Transportation & Storage"};


    public void clickButtonNext(){
        getHelper().findElement(getBtnNext()).click();
    }

    public void selectIndustry(String indName) {
        getHelper().findElement(getIndustryLocatorByText(indName)).click();
    }

    public void selectIndustries(String indus[]) {
        for (int i=0; i < indus.length; i++)
            selectIndustry(indus[i]);
    }

    public void clickButtonDone(){
        getHelper().findElement(getBtnDone()).click();
    }

    public void verifySecondScreenShouldContainIndustry(String indName){
        getHelper().isElementPresent(getCategoryLocatorByText(indName));
    }



    public void verifySecondScreenShouldContainIndustries(String indus[]) {
        for (int i=0; i < indus.length; i++)
            verifySecondScreenShouldContainIndustry(indus[i]);
    }
}
