package com.beecow.utils;


import java.util.Calendar;

public class APIData {

    //status service
    public static final String GET_STATUS_CA = "http://api.mediastep.ca/statusservices/api/status";
    public static final String POST_STATUS_CA = "http://api.mediastep.ca/statusservices/api/status";
    public static final String GET_STATUS_COM = "http://api.mediastep.com/statusservices/api/status";
    public static final String POST_STATUS_COM = "http://api.mediastep.com/statusservices/api/status";
//    public static String DELETE_STATUS(String StatusID){
//        return "http://devportal.dts.com/saap/api/delDevice/" + StatusID ;
//    }


    //status feeds
    public static final String GET_FEEDS_CA = "http://api.mediastep.ca/feedservices/api/feeds";
    public static final String POST_FEEDS_CA = "http://api.mediastep.ca/feedservices/api/feeds/collect";
    public static final String GET_FEEDS_COM = "http://api.mediastep.com/feedservices/api/feeds";
    public static final String POST_FEEDS_COM = "http://api.mediastep.com/feedservices/api/feeds/collect";
    // Response message
    //public static final String ERROR_MESSAGE = "You don't have permission.";
    //public static final String ERROR_MESSAGE_CHANGE_USER_OWN_EMAIL = "{\"su\":false,\"dtsUser\":false}";

    // Request method
    public static final String GET_METHOD = "GET";
    public static final String POST_METHOD = "POST";
    public static final String PUT_METHOD = "PUT";
    public static final String DELETE_METHOD = "DELETE";


    // Json data file
    public static final String JSON_DATA_FILE = "JsonData.json";

    // Json data key
    public static final String ADD_NEW_STATUS = "add new status";
    public static final String PUBLISHED_PRODUCT_DATA = "published product data";
    public static final String GLOBAL_PROMOTION_DATA = "global promotion data";
    public static final String ADD_GLOBAL_PROMOTION_DATA = "add promotion";
    public static final String EDIT_GLOBAL_PROMOTION_DATA = "edit promotion";
    public static final String LOG_IN = "login";

//    public enum TuningAction {
//        DTS_REQUEST_PENDING("dts_request_pending"), DTS_TUNING_UPLOAD("dts_tuning_upload"), DTS_APPROVE("dts_approved"),
//        PENDING_DTS_REVIEW("pending_dts_review"), DTS_DECLINE("dts_declined"), PARTNER_DECLINE("partner_declined"),
//        PARTNER_REQUEST_DECLINE_REVISE("partner_request_declined_revised_tuning"), PARTNER_REQUEST_REVISE("partner_request_revised_tuning"),
//        PARTNER_REMOVE("partner_removed"), PARTNER_TUNING_UPLOAD("partner_tuning_upload"), PENDING_PARTNER_UPLOAD("pending_partner_review"),
//        UNSUBMIT("Unsubmitted"), APPROVE("Approved"), REVOKE("Revoked");
//
//        private String action;
//        TuningAction(String action){
//            this.action = action;
//        }
//
//        public String getName() {
//            return this.action;
//        }
//
//        public static String[] getNames() {
//            TuningAction[] actions = values();
//            String[] result = new String[actions.length];
//            for (int i = 0; i < actions.length; i++) {
//                result[i] = actions[i].getName();
//            }
//            return result;
//        }
//    }

//    public enum MarketingAction {
//        APPROVED("Approved"), DECLINED("Declined"), REVOKED("Revoked"), REQUEST_REVIEW("dts_mkt_request_review");
//
//        private String action;
//        MarketingAction(String action){
//            this.action = action;
//        }
//
//        public String getName() {
//            return this.action;
//        }
//
//        public static String[] getNames() {
//            MarketingAction[] actions = values();
//            String[] result = new String[actions.length];
//            for (int i = 0; i < actions.length; i++) {
//                result[i] = actions[i].getName();
//            }
//            return result;
//        }
//    }

}