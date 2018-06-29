package com.scent.core.util;

public class Constants {
    public static final String CONTROL = "control";
    public static final String GET_POST_BY_ID = "control";
    public static final String DATE = "date";
    public static final String TIMEZONE_UTC = "UTC";
    public static final String TIMEZONE = "timezone";
    public static final String POST_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String GLOBAL_CONFIG = "GLOBAL";
    public static final int INFO_LOG_LEVEL = 400;
    public static final int DEBUG_LOG_LEVEL = 500;
    public static final String CASE_INSENSITIVE = "<script>(.*?)</script>";
    public static final String CASE_INSENSITIVE_MULTILINE_DOTALL_WITH_SINGLE_QUOTE = "src[\r\n]*=[\r\n]*\\\'(.*?)\\\'";
    public static final String CASE_INSENSITIVE_MULTILINE_DOTALL_WITH_DOUBLE_QUOTE = "src[\r\n]*=[\r\n]*\\\"(.*?)\\\"";
    public static final String SCRIPT_CASE_INSENSITIVE = "</script>";
    public static final String SCRIPT_CASE_INSENSITIVE_MULTILINE_DOTALL = "<script(.*?)>";
    public static final String EVAL_CASE_INSENSITIVE_MULTILINE_DOTALL = "eval\\((.*?)\\)";
    public static final String EXPRESSION_CASE_INSENSITIVE_MULTILINE_DOTALL = "expression\\((.*?)\\)";
    public static final String JAVA_SCRIPT_CASE_INSENSITIVE = "javascript:";
    public static final String VB_SCRIPT_CASE_INSENSITIVE = "vbscript:";
    public static final String ONLOAD_CASE_INSENSITIVE_MULTILINE = "onload(.*?)=";
    public static final String HTTP = "http://";
    public static final String HTTPS = "https://";
    public static final String AMPERSAND = "&";
    public static final String NULL_STRING = "\0";
    public static final String EMPTY = "";

    public static final String SHARED_LOCATION = "sharedLocation";

    public static final String YML_EXTENSION = ".yml";
    public static final String YAML_KEYS_FILE = "-keys.yml";
    public static final String PROP_POST_EXPIRY_DAY = "post.expiry.dayCount";
    public static final int INVALID_VAL = -999;


    //Logger Util
    public static final String LOG_CONTROLLER = "CONTROLLER";
    public static final String LOG_SERVICE = "SERVICE";
    public static final String LOG_REPOSITORY = "REPOSITORY";
    public static final String THREAD = "thread";
    public static final String CLIENT_IP = "clientip";

    public static final int TWO = 2;


    public static final String NULL = "null";
    public static final int INDEX_NOT_FOUND = -1;

    public static final String DOMAIN = "domain";
    public static final String URI = "uri";


    public static final String TYPE = "type";
    public static final String POINT = "Point";


    //Configuration properties
    public static final String MONGO_DB_PATH = "mongodb.path";
    public static final String MONGO_DB_NAME = "mongodb.database.name";

    //Event Data
    public static final String JSON_RESPONSE_FILTER = "jsonResponseFilter";
    public static final String PROP_POST_HOUR_DOWN_VOTE = "post.downvote.hour";
    public static final String PROP_POST_HOUR_UP_VOTE = "post.upvote.one.hour";
    public static final String PROP_POST_HOUR_UP_VOTE_1000 = "post.upvote.thousand.hour";
    public static final String PROP_POST_HOUR_UP_VOTE_2000 = "post.upvote.twothousands.hour";
    public static final String CURRENT_DATE = "currentDate";
    public static final String YEAR_FORMAT = "YYYY";
    public static final String YEAR = "year";
    public static final String ERROR_STATUS_KEY = "errorStatus";
    public static final String ERROR_STATUS_VALUE = "failed";

    public static final String EXCEPTION_TEXT = "errorMessage";
    public static final  String JSON_STATUS_CODE = "StatusCode";




    //Query param
    public static final String PRIVACY_TYPE = "privacyTypes";
    public static final String LOCATION_HIDDEN = "hideLocation";
    public static final String RADIUS ="radius";
    public static final String LIMIT = "limit";
    public static final String LONGITUDE = "longitude";
    public static final String LATITUDE = "latitude";
    public static final String LOCATION_NAME = "locationName";
    public static final String USER_ID = "userId";
    public static final String POST_TYPE = "postType";
    public static final String POST_ID = "postId";
    public static final String CONTENT = "content";
    public static final String USER_DATE = "userDate";
    public static final String VOTE_TYPE = "voteType";

    //List of posts
    public static final String LOCATION = "location";
    public static final String PRIVACY = "privacy";
    public static final String EXPIRY_DATE = "expiryDate";
    public static final String UP_VOTES = "upVotes";
    public static final String FLAG_TO_DELETE = "flagToDelete";

    //Special Characters
    public static final String UNDER_SCORE = "_";
    public static final String DOUBLE_QUOTE = "\"";
    public static final String COMMA = ",";
    public static final String EQUAL = "=";
    public static final String WHITESPACE = " ";
    public static final String SEPARATOR = "-";
    public static final String DOT = ".";
    public static final String FORWARD_SLASH = "/";

    public static final String VOTE = "vote";
    public static final String UP_VOTE = "upVote";
    public static final String DOWN_VOTE = "downVote";
    public static final String PARAM_VOTE = "paramVote";
    public static final int MINUS_ONE = -1;
    public static final int MINUS_TWO = -2;
    public static final int ONE = 1;
    public static final int ZERO = 0;

    //profile
    public static final String EMAIL_ID = "email";
    public static final String PASSWORD = "password";
    public static final String OLD_PASSWORD = "oldPassword";
    public static final String NEW_PASSWORD = "newPassword";
    public static final String MOBILE_NUIMBER = "mobile";
    public static final String LOGIN_TYPE = "loginType";
    public static final String SIGNUP_TYPE = "signupType";
    public static final String LOGIN_BY_MOBILE = "LoginByMobile";
    public static final String LOGIN_BY_EMAIL = "LoginByEmail";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String BIO = "bio";
    public static final String GENDER ="gender";
    public static final String REPORTER_USER_ID = "reporterUserId";

    //
    public static final String STATUS = "Status";
    public static final String FAILED = "Failed";
    public static final String STAUS_CODE = "StatusCode";
    public static final String DATA = "Data";
    public static final String SUCCESS = "Success";
    public static final String ACCOUNT_CREATION_FAILED_CODE = "AC001";
    public static final String ACOUNT_ALREADY_EXISTS_CODE = "AC002";



}
