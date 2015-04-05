package com.yuguo.mydoctor.base.utils;

import android.content.Context;

import com.chinaway.framework.swordfish.network.http.AuthFailureError;
import com.chinaway.framework.swordfish.network.http.DefaultRetryPolicy;
import com.chinaway.framework.swordfish.network.http.Request.Method;
import com.chinaway.framework.swordfish.network.http.RequestQueue;
import com.chinaway.framework.swordfish.network.http.Response.ErrorListener;
import com.chinaway.framework.swordfish.network.http.Response.Listener;
import com.chinaway.framework.swordfish.network.http.toolbox.SignGenerator;
import com.chinaway.framework.swordfish.network.http.toolbox.StringRequest;
import com.chinaway.framework.swordfish.network.http.toolbox.Volley;
import com.chinaway.framework.swordfish.util.TimeUtils;
import com.yuguo.mydoctor.base.YuguoApplication;
import com.yuguo.mydoctor.base.common.Constants;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class RequestUtils {
	private static final int DEFAULT_REQUEST_TIMEOUT = 20 * 1000;
	private static final int DEFAULT_REQUEST_RETRY_COUNT = 0;

	private static RequestQueue mRequestQueue;

	public static RequestQueue getRequestQueue(Context context) {
		if (mRequestQueue == null) {
			mRequestQueue = Volley.newRequestQueue(context);
		}
		return mRequestQueue;
	}

	public static void createRequest(final Context context, String url,
			final String method, final boolean beforeLogin,
			final Map<String, String> dataParams, final boolean jsonFormat,
			Listener<String> listener, ErrorListener errListener) {
		StringRequest request = new StringRequest(Method.POST, url, listener,
				errListener) {

			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				if (dataParams == null) {
					throw new AuthFailureError("缺少参数！");
				} else {
					if (jsonFormat) {
						return buildParams(context, method, beforeLogin,
								dataParams);
					} else {
						dataParams.put("method", method);
						return dataParams;
					}
				}
			}

		};
		request.setRetryPolicy(new DefaultRetryPolicy(DEFAULT_REQUEST_TIMEOUT,
				DEFAULT_REQUEST_RETRY_COUNT,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
		request.setShouldCache(false);

		getRequestQueue(context).add(request);
	}

	private static Map<String, String> buildParams(Context context,
			String method, boolean beforeLogin, Map<String, String> dataParams) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("method", method);
		String app_key = beforeLogin ? Constants.DEAD_APP_KEY
				: YuguoApplication.hyrApplication.getUser().getId();
		params.put("app_key", app_key);
		params.put("clienttype", "manager");
		params.put("timestamp", TimeUtils.getTime());
		if (dataParams.size() > 0) {
			try {
				params.put("data", URLEncoder.encode(
						new JSONObject(dataParams).toString(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		String sign = beforeLogin ? "" : SignGenerator.createSign(params,
                YuguoApplication.hyrApplication.getUser().getToken());
		params.put("sign", sign);
		return params;
	}

	public static void cancelRequest(Object tag) {
		mRequestQueue.cancelAll(tag);
	}
}
