package com.beecow.component;

/**
 * Created by HangPham on 12/17/2016.
 */
public class Constant {
    public static final int TIME_OUT =10;
    public static final String URL_ADDRESS="http://127.0.0.1:4723/wd/hub";
    public static final String APP_PATH="c:\\Jenkins\\workspace\\BeeCow-QAAndroid\\BeeCow_1.0_DEBUG_17Jan2017.apk";//com.android.chrome.apk//FoodyVN.apk
    public static final String APP_PACKAGE_LIVE = "com.mediastep.beecow";

//"C:\Program Files (x86)\Appium\node.exe" "C:\Program Files (x86)\Appium\node_modules\appium\lib\server\main.js" --address 127.0.0.1 --port 4723 --avd Nexus4
    public static final MOBILE_PLATFORM TYPE_PLATFORM = MOBILE_PLATFORM.ANDROID;
    public enum MOBILE_PLATFORM{
        ANDROID,
        IOS,
        CHROME_AND,
        SAFARI_IOS
    }

    //integration testLink
//    public static final String TEST_PROJECT = "Market_Android";
//    public static final String TEST_PLAN = "Market_Android_Plan_01";
 //   public static final String TEST_BUILD = "Market_Android_Build_01";
    public static final String DEVKEY ="bed1de6a318ab11678ee0b96272eefba";
    public static final String URL ="http://192.168.1.124/testlink/lib/api/xmlrpc/v1/xmlrpc.php";

    //integration testLink for Cupid project
  //  public static final String TEST_CUPID_PROJECT = "DAT";
  //  public static final String TEST_CUPID_PLAN = "TestPlan_DAT";
  //  public static final String TEST_CUPID_BUILD = "Build_Cupid_Sprint_1";

    //Cupid Constant


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
}
