package com.gac.ywl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


/**
 * @title SPUtils.java
 * @package com.gac.footprint.base.utils
 * @description  {shareprefence集中处理}
 * @author gacmy
 * @date 2018/6/16 0016
 *
 */
public class SPUtils {


	private static SharedPreferences sPrefs;
	public static final String fileName = "gacmy";
	public static final String KEY_STARTUP="sp_startup";
	public static final String KEY_DICTIONARY="sp_dictionary";

	public static final String KEY_USERID="sp_userid";
	public static final String KEY_UNAME="sp_uname";
	public static final String KEY_SEX="sp_sex";
	public static final String KEY_NICKNAME="sp_nickname";
	public static final String KEY_ICON="sp_icon";
	public static final String KEY_MOBILE="sp_mobile";
	public static final String KEY_EMAIL="sp_email";
	public static final String KEY_ISWIFIAUTO="sp_iswifiauto";
	public static final String KEY_TIME_SETWIFIAUTO="sp_time_swa";
	public static final String KEY_ISPUSH1AUTO="sp_ispush1auto";
	public static final String KEY_ISPUSH2AUTO="sp_ispush2auto";
	public static final String KEY_PREVIOUS_LOGIN_TIME="sp_previous_login_time";
	public static final String KEY_BIRTHDAY="sp_birthday";
	public static final String KEY_COLLEGE="sp_college";
	public static final String KEY_TOUZI="sp_touzi";
	public static final String KEY_WALLETCOUNT="sp_walletCount";

	public static final String KEY_ABOUT_WECHAT ="sp_aboutwechat";
	public static final String KEY_ABOUT_MAIL ="sp_aboutmail";
	public static final String KEY_ABOUT_LOGO ="sp_aboutlogo";
	public static final String KEY_ABOUT_VERSION ="sp_aboutversion";
	public static final String KEY_ABOUT_APPLOG ="sp_aboutapplog";
	public static final String KEY_ABOUT_AGREEMENT ="sp_aboutagreement";
	public static final String KEY_ABOUT_BLANCEAGREEMENT ="sp_aboutba";
	public static final String KEY_ABOUT_WECHATAGREEMENT ="sp_aboutwca";
	public static final String KEY_ABOUT_PRIVACY ="sp_aboutprivacy";
	public static final String KEY_ISSETTIMER ="sp_issettimer";
	public static final String KEY_ISTHIRDLOGIN ="sp_isThirdLogin";
	public static final String KEY_PWD ="sp_pwd";

	public static final String KEY_PLAYLIST ="sp_playList";
	public static final String KEY_PLAYINGINDEX ="sp_playingIndex";
	public static final String KEY_AUDIOID ="sp_audioId";
	public static final String KEY_PLAYLONG ="sp_playLong";
	public static final String KEY_AUDIOLONG ="sp_audioLong";
	public static final String KEY_UPGRADE ="sp_upgrade";
	public static final String KEY_NEWVERSION ="sp_newVersion";
	public static final String KEY_APPSIZE ="sp_appSize";
	public static final String KEY_APPURL ="sp_appUrl";
	public static final String KEY_VERSIONNAME ="sp_versionName";

	public static final String KEY_BANNER ="sp_banner";
	public static final String KEY_USERINFO ="sp_userInfo";
	public static final String KEY_SPEED ="sp_speed";

	public static final String KEY_PREVIOUS_AUDIOID ="sp_previous_audioid";
	public static final String KEY_BOOKID ="sp_bookId";

	private SPUtils() {
		sPrefs = Constants.sContext.getSharedPreferences(fileName,
				Context.MODE_WORLD_READABLE);
	}

	public static void init() {
		new SPUtils();
	}

	public static int getInt(String key, int defaultValue) {
		if (sPrefs == null) {
			init();
		}
		return sPrefs.getInt(key, defaultValue);
	}

	public static void setInt(String key, int value) {
		if (sPrefs == null) {
			init();
		}
		sPrefs.edit().putInt(key, value).commit();
	}

	public static boolean getBoolean(String key, boolean defaultValue) {
		if (sPrefs == null) {
			init();
		}
		return sPrefs.getBoolean(key, defaultValue);
	}

	public static void setBoolean(String key, boolean value) {
		if (sPrefs == null) {
			init();
		}
		sPrefs.edit().putBoolean(key, value).commit();
	}

	public static String getString(String key, String defaultValue) {
		if (sPrefs == null) {
			init();
		}
		return sPrefs.getString(key, defaultValue);
	}

	public static void setString(String key, String value) {
		if (sPrefs == null) {
			init();
		}
		sPrefs.edit().putString(key, value).commit();
	}

	public static void setLong(String key, long value) {
		if (sPrefs == null) {
			init();
		}
		sPrefs.edit().putLong(key, value).commit();
	}

	public static long getLong(String key) {
		if (sPrefs == null) {
			init();
		}
		long value=0l;
		try{
			value=sPrefs.getLong(key, 0l);
		}
		catch (Exception ex){
			value=sPrefs.getInt(key, 0);
		}
		return value;
	}

	public static void setFloat(String key, float value) {
		if (sPrefs == null) {
			init();
		}
		sPrefs.edit().putFloat(key, value).commit();
	}

	public static float getFloat(String key, float defaultValue) {
		if (sPrefs == null) {
			init();
		}
		return sPrefs.getFloat(key,defaultValue);
	}

	public static void removeKey(String key){
		if (sPrefs == null) {
			init();
		}
		boolean isRemove = sPrefs.edit().remove(key).commit();
		Log.i("db","removeKey "+key+" isRemove:"+isRemove);
	}
}
