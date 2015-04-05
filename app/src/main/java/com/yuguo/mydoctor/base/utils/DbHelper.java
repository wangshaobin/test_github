package com.yuguo.mydoctor.base.utils;

import com.chinaway.framework.swordfish.DbUtils;
import com.chinaway.framework.swordfish.exception.DbException;
import com.yuguo.mydoctor.base.YuguoApplication;

public class DbHelper {
	/**
	 * 视数据库的用途不同，分为用户库（业务数据）和系统库（配置或字典）
	 */
	public static final short DB_TYPE_SYS = 0;
	public static final short DB_TYPE_USER = 1;

	/**
	 * 不同分类的库版本，需分开管理，方便升级维护
	 */
	public static final int DB_VERSION_SYS = 1;
	public static final int DB_VERSION_USER = 12;

	/**
	 * 获取数据库操作的帮助类
	 * 
	 * @param dbType
	 *            数据库类型
	 * @return
	 */
	public synchronized static DbUtils getDbUtils(short dbType) {

		String dbName = "";
		int dbVersion = 1;
		switch (dbType) {
		case DB_TYPE_SYS:
			dbName = "yg1.0_sys";
			dbVersion = DB_VERSION_SYS;
			break;
		case DB_TYPE_USER:
			String phone = "";
			if (YuguoApplication.hyrApplication.getUser() == null) {
				phone = "error";
			} else {
				phone = YuguoApplication.hyrApplication.getUser().getPhone();
			}
			dbName = "yg1.0_" + phone;
			dbVersion = DB_VERSION_USER;
			break;
		default:
			break;
		}
		DbUtils dbUtils = DbUtils.create(YuguoApplication.hyrApplication, dbName,
				dbVersion, new DbUtils.DbUpgradeListener() {

					@Override
					public void onUpgrade(DbUtils db, int oldVersion,
							int newVersion) {
						try {
							db.dropDb();
						} catch (DbException e) {
							e.printStackTrace();
						}
					}
				});
		dbUtils.configAllowTransaction(true);
		dbUtils.configDebug(false);
		return dbUtils;
	}
}