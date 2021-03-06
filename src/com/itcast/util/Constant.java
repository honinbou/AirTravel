package com.itcast.util;

import android.os.Environment;

public class Constant
{
  public static String ACTIVE_UID;

  public static final String DENSITY = "density";
  public static final String FORMAT = "format";
  public static final String FORMATVALUE = "json";
  public static final String HMAC_SHA1 = "HmacSHA1";
  public static final int HOME = 1;
  public static final String IMEI = "imei";
  public static final String IMSI = "imsi";
  public static final String LANGUAGE = "language";
  public static final String LOCAL_PATH_SHOPCAR = "/itcast/shopcar/";
  public static final int MIN_SPACE_FOR_VERSION_UPDATA = 10485760;
  public static final String MODEL = "model";
  public static final int MORE = 5;
  public static final String NAME = "name";
  public static final int NEED_SYNCHRO_SHOPCAR = 0;
  public static final String NICK_NAME = "nick_name";
  public static final int NO_NEED_SYNCHRO_SHOPCAR = 1;
  public static final String PAGESIZE = "10";
  public static final String PLATFORM_NAME = "platformn";
  public static final String POINT = "point";
  public static final String SDPATH;
  public static final int SEARCH = 3;
  public static final int SHOPCAR = 4;
  public static int SHOPCAR_NUM = 0;
  public static final String SIGN = "sign";
  public static final String SINGMETHOD = "sign_method";
  public static final String SINGMETHODVALUE = "md5";
  public static final String SMS_CENTER_NUMBER = "sms_center_number";
  public static final String SOURCE = "source";
  public static final String SOURCE_CODE = "source";
  public static final String SYNCHRO_SHOPCAR_FLAG = "synchroShopcarFlag";
  public static final String T = "t";
  public static final int TIMEOUT_TIME = 30000;
  public static final String VER = "ver";
  public static final String VERVALUE = "1.0";
  public static final String WELCOME_IMG_NAME = "welcomeImgName";
  public static final String X_RESOLUTION = "xResolution";
  public static final String Y_RESOLUTION = "yResolution";
  public final static int FAILED = -1;
  public final static int SUCCESS = 1;
  public final static int NET_FAILED = 2;
  public final static int TIME_OUT = 3;
  public static int defaultIndex;
  public static boolean exit = true;
  public static int selectedHome;
  public static String selectedNum;
  public static String FLAG;
  

  static
  {
    int i = 0;
    defaultIndex = 1;
    selectedHome = i;
    selectedNum = "0";
    SDPATH = Environment.getExternalStorageDirectory().getPath();
    ACTIVE_UID = "uid";
    SHOPCAR_NUM = i;
  }
}