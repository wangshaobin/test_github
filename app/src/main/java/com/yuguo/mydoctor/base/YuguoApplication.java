package com.yuguo.mydoctor.base;

import android.app.Application;

import com.google.gson.Gson;
import com.yuguo.mydoctor.base.utils.PrefUtils;
import com.yuguo.mydoctor.main.entity.User;

public class YuguoApplication extends Application {
	public static YuguoApplication hyrApplication;
	private User user;
    public static boolean isCop = true;

	public void onCreate() {
		hyrApplication = this;
		super.onCreate();
	}

	public static YuguoApplication getApplication() {
		return hyrApplication;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 返回用户信息
	 * 
	 * @return
	 */
	public User getUser() {
		if (user == null) {
			String json = PrefUtils.getStringPreference(this, PrefUtils.CONFIG,
                    PrefUtils.KEY_USER_JSON, "");
			try {
				User u = new Gson().fromJson(json, User.class);
				return u;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return user;
	}
}
