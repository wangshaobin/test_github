package com.yuguo.mydoctor.base.common;

import com.yuguo.mydoctor.base.utils.PrefUtils;
import com.yuguo.mydoctor.base.YuguoApplication;

public class Urls {

//	public static final String BASE_MOP_URL = BuildConfig.MOP_URL;
	public static final String BASE_MOP_URL = "http://hyr2.huoyunren.net:8100/api.php";
    public static final String BASE_HYR_MOBILE_URL = "http://test.mop.g7s.chinawayltd.com/api.php";

	public static final String getMopHostUrl() {
		return PrefUtils.getStringPreference(YuguoApplication.getApplication()
                        .getApplicationContext(), PrefUtils.CONFIG,
                PrefUtils.KEY_APP_REQUEST_URL, BASE_HYR_MOBILE_URL);
	}

	/*********************************************************************/

	public static final String METHOD_GET_CONFIG_BY_ID = "mop.applicationinfo.getConfigByID"; // 获取APP配置信息
	public static final String METHOD_GET_UPGRADE_BY_ID = "mop.applicationinfo.getUpgradeByID"; // 验证版本
	public static final String METHOD_CAPTCHA_CREATE = "hyr.mobile.captchaCreate"; // 获取验证码
	public static final String METHOD_LOGSTATUS = "mop.userlog.receiveLogStatus"; // 客户端登出
	public static final String METHOD_ERRORLOG_UPLOAD = "mop.errorlog.uploaderrorlog"; // 错误日志上传
	public static final String METHOD_SCAN_BY_CODE = "hyr.mobile.scanByCode"; // 二维码扫描

	/*********************************************************************/

	public static final String METHOD_USER_LOGIN = "hyr.mobile.userLogin"; // 用户登陆
	public static final String METHOD_USER_CREATE = "hyr.mobile.userCreate"; // 用户注册
	public static final String METHOD_USER_EDIT = "hyr.mobile.userDoEditEnterpriseProfile"; // 管车客户端修改个人信息
	public static final String METHOD_USER_RELATION_SHOW = "hyr.mobile.userDoEditEnterpriseRelationShow"; // 管车用户修改隐私策略
    public static final String METHOD_USER_COMPLETE = "hyr.mobile.userHyrWizard"; // 完善资料
	public static final String METHOD_SYNC_DICT_LIST = "hyr.mobile.sysDictList"; // 同步字典列表
	public static final String METHOD_SYNC_CITY_LIST = "hyr.mobile.cityList"; // 同步城市列表
}
