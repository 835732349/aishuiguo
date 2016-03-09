package com.aishuiguo.utils;

import com.lidroid.xutils.BitmapUtils;

public class BitmapHelper {
	private static BitmapUtils mBitmapUtils = null;
	private static Object LOCK = new Object();

	// 单例：饿汉式 懒汉式

	public static BitmapUtils getBitmapUtils() {
		// 双重判断
		if (mBitmapUtils == null) { // 提高效率
			synchronized (LOCK) {
				if (mBitmapUtils == null) { // 线程1，线程2 保证单例
					mBitmapUtils = new BitmapUtils(CommonUtils.getContext());
				}
			}
		}

		return mBitmapUtils;
	}
}
