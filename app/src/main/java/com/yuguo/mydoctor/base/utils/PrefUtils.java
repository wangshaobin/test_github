package com.yuguo.mydoctor.base.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * SharedPreferences工具类
 * 
 * @author wangshaobin
 * 
 */
public class PrefUtils {
	/**
	 * SharedPreferences配置文件：config
	 */
	public static final String CONFIG = "yg_config";

	/**
	 * APP配置：md5
	 */
	public static final String KEY_APP_MD5 = "key_app_md5";
	/**
	 * APP配置：请求URL
	 */
	public static final String KEY_APP_REQUEST_URL = "key_app_requesturl";
	/**
	 * APP配置：offline
	 */
	public static final String KEY_APP_OFFLINE = "key_app_offline";
	/**
	 * APP配置：deleted
	 */
	public static final String KEY_APP_DELETED = "key_app_deleted";
	/**
	 * APP配置：md5
	 */
	public static final String KEY_APP_DEBUG = "key_app_debug";

	/**
	 * 城市字典更新时间
	 */
	public static final String KEY_SYS_DICT_CITY_UPDATETIME = "key_sys_dict_city_updatetime";
    public static final String KEY_SYS_DICT_SYNC = "key_sys_dict_sync";
    public static final String KEY_SYS_CITY_SYNC = "key_sys_city_sync";

	/**
	 * 第一次登录
	 */
	public static final String KEY_FIRST_LOGIN = "key_first_login";

    /**
     * 第一次使用应用
     */
    public static final String KEY_FIRST_USE = "key_first_use";


    /**
	 * 上次登录手机号码
	 */
	public static final String KEY_PHONE_NUMBER = "phone_number";
	/**
	 * 上次登录手机序列号
	 */
	public static final String KEY_SIM_SERIAL_NUMBER = "sim_serial_number";

	public static final String KEY_ID = "id";
	public static final String KEY_TOKEN = "token";
	/**
	 * 登录返回用户信息
	 */
	public static final String KEY_USER_JSON = "key_user_json";

	public static void saveStringPreferences(Context context, String name,
			String key, String value) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(
				name, Context.MODE_MULTI_PROCESS);
		Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}

	public static String getStringPreference(Context context, String name,
			String key, String defaultValue) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(
				name, Context.MODE_MULTI_PROCESS);
		return sharedPreferences.getString(key, defaultValue);
	}

	public static boolean getBooleanPreference(Context context, String name,
			String key, boolean defaultValue) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(
				name, Context.MODE_MULTI_PROCESS);
		return sharedPreferences.getBoolean(key, defaultValue);
	}

	public static void setLongPreference(Context context, String name,
			String key, long value) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(
				name, Context.MODE_MULTI_PROCESS);
		Editor editor = sharedPreferences.edit();
		editor.putLong(key, value);
		editor.commit();
	}

	public static long getLongPreference(Context context, String name,
			String key, long defaultValue) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(
				name, Context.MODE_MULTI_PROCESS);
		return sharedPreferences.getLong(key, defaultValue);
	}

	public static int getIntPreference(Context context, String name,
			String key, int defaultValue) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(
				name, Context.MODE_MULTI_PROCESS);
		return sharedPreferences.getInt(key, defaultValue);
	}

	public static void saveBooleanPreferences(Context context, String name,
			String key, boolean value) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(
				name, Context.MODE_MULTI_PROCESS);
		Editor editor = sharedPreferences.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	public static void saveIntPreferences(Context context, String name,
			String key, int value) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(
				name, Context.MODE_MULTI_PROCESS);
		Editor editor = sharedPreferences.edit();
		editor.putInt(key, value);
		editor.commit();
	}
}
