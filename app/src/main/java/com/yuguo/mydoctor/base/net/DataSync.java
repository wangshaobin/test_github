package com.yuguo.mydoctor.base.net;

import android.content.Context;

import com.chinaway.framework.swordfish.network.http.Response;
import com.chinaway.framework.swordfish.network.http.VolleyError;
import com.chinaway.framework.swordfish.network.http.Response.ErrorListener;
import com.chinaway.framework.swordfish.network.http.Response.Listener;
import com.yuguo.mydoctor.base.utils.RequestUtils;
import com.yuguo.mydoctor.base.common.Urls;

import java.util.HashMap;
import java.util.Map;

public class DataSync {
	private Context mContext;

	public interface DataSyncListener {
		void onResponse(Object response);

		void onErrorResponse(VolleyError error);
	}

	public DataSync(Context context) {
		mContext = context;
	}

	/**
	 * 根据tag取消网络请求
	 * 
	 * @param tag
	 */
	public void cancelRequest(Object tag) {
		RequestUtils.getRequestQueue(mContext).cancelAll(tag);
	}

    /**
     * 获取APP配置信息
     *
     * @param params
     * @param listener
     * @param errorListener
     */
	public void syncAppConfig(Map<String, String> params, Listener<String> listener,
			ErrorListener errorListener) {
		RequestUtils.createRequest(mContext, Urls.BASE_MOP_URL,
				Urls.METHOD_GET_CONFIG_BY_ID, true, params, false, listener,
                errorListener);
	}

	/**
	 * 登出
	 * 
	 * @param appkey
	 *            应用ID？
	 * @param phone
	 *            用户号码
	 * @param dataSyncListener
	 */
	public void loginOut(String appkey, String phone,
			final DataSyncListener dataSyncListener) {
		Response.Listener<String> listener = new Response.Listener<String>() {

			@Override
			public void onResponse(String response) {
				if (dataSyncListener != null) {
					dataSyncListener.onResponse(response);
				}
			}
		};
		ErrorListener errListener = new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				if (dataSyncListener != null) {
					dataSyncListener.onErrorResponse(error);
				}
			}
		};
		Map<String, String> params = new HashMap<String, String>();
		params.put("appkey", appkey);
		params.put("phone", phone);
		params.put("status", "0");// 状态，0：登录
		RequestUtils.createRequest(mContext, Urls.BASE_MOP_URL,
				Urls.METHOD_LOGSTATUS, true, params, false, listener,
				errListener);
	}

    /**
     * 验证版本并获取最新应用地
     *
     * @param params
     * @param listener
     * @param errorListener
     */
	public void checkVersion(Map<String, String> params, Listener<String> listener,
			ErrorListener errorListener) {
		RequestUtils.createRequest(mContext, Urls.BASE_MOP_URL,
				Urls.METHOD_GET_UPGRADE_BY_ID, true, params, false, listener,
				errorListener);
	}

	/********************************************************************************/

    /**
     * 获取短信验证码
     *
     * @param params
     * @param listener
     * @param errorListener
     */
	public void captchaCreate(Map<String, String> params, Listener<String> listener,
			ErrorListener errorListener) {
		RequestUtils.createRequest(mContext, Urls.getMopHostUrl(),
				Urls.METHOD_CAPTCHA_CREATE, true, params, true, listener,
				errorListener);
	}
}