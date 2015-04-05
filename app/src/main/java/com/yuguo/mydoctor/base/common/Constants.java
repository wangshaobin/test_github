package com.yuguo.mydoctor.base.common;

public class Constants {
	/**
	 * appkey
	 */
	public static final String APP_KEY = "EDCA315397C40BC24DA6F79FCC8FD5D9";
	/**
	 * 升级包缓存的名称
	 */
	public static final String UPDATE_PACKAGE_NAME = "hyr_upgrade.apk";

	/**
	 * 合作、交易、消息通知
	 */
	public static final String ACTION_PUSH_MESSAGE = "com.chinaway.lbs.action.PUSH_MESSAGE";
	public static final String MQTT_TOPIC_AUTH = "truck_auth";
	public static final String MQTT_TOPIC_WORK = "truck_work";
	public static final String MQTT_TOPIC_MESSAGE = "truck_message";
	public static final String MQTT_TOPIC_UPGRADE = "truck_upgrade";

	/**
	 * 数据操作结果
	 * */
	public static final int GET_CAPTCHA_SUC = 1;
	public static final int GET_CAPTCHA_FAILED = 2;
	public static final int LOGIN_SUC = 3;
	public static final int LOGIN_FAILED = 4;
	public static final int GET_TRUCK_LIST_SUC = 5;
	public static final int GET_TRUCK_LIST_FAILED = 6;
	public static final int GET_TRUCK_SHOW_SUC = 7;
	public static final int GET_TRUCK_SHOW_FAILED = 8;
	public static final int TRUCK_SAVE_SUC = 9;
	public static final int TRUCK_SAVE_FAILED = 10;
	public static final int TRUCK_DELETE_SUC = 111;
	public static final int TRUCK_DELETE_FAILED = 112;
	public static final int TRUCK_AUTH_SUC = 113;
	public static final int TRUCK_AUTH_FAILED = 114;
	public static final int TRUCK_DETAIL = 115;
	public static final int MULTIPLE_SELECT = 116;
	public static final int TASK_SAVE_SUC = 117;
	public static final int MESSAGE_SEND_SUC = 118;
	public static final int BID_CREATE_OK = 119;

	public static String DEAD_APP_KEY = "51522CC11D114BE5E1995F3F9AA5D22D";

}
