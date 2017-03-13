package com.beecow.model;

import com.beecow.utils.Utils;


public class ActivityFristElement {

    public static String getActivityFirstPageLocator(){
        if(Utils.getInstance().isAndroidDevice()) return "resourceID::activity_first_launching_pager";
        return "ios";
    }

    public static String getCategoryLocatorByText(String value){
        if(Utils.getInstance().isAndroidDevice()) return "text::" + value + "";
        return "ios";
    }

    public static String getBtnNext(){
        if(Utils.getInstance().isAndroidDevice()) return "text::Next";
        return "ios";
    }
}

