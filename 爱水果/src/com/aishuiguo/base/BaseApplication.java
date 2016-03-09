/**
 * 
 */
package com.aishuiguo.base;

import java.util.HashMap;
import java.util.Map;

import com.aishuiguo.bean.Fruit;
import com.shan.aishuiguo.Subject;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

/**
 * @author liangshan
 * 
 *         created on 2016-2-24下午10:21:39
 */
public class BaseApplication extends Application {
	// 上下文对象
	private static Context context;
	// 主线程Id
	private static int mainThreadId;
	// 主线程handler
	private static Handler mainHandler;
	private static Thread mainThread;
	// 购物车
	private static Map<String, Fruit> shoppingCar;
	// 用于注册观察者
	public  static Subject subject;
	//总价
	public static float totalPrice;

	/* 
	 */
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		context = getApplicationContext();
		mainThreadId = Process.myTid();
		mainHandler = new Handler();
		mainThread = Thread.currentThread();
		shoppingCar = new HashMap<String, Fruit>();
		subject = new Subject();
	}

	// 提供上下文对象
	public static Context getContext() {
		return context;
	}

	// 获取主线程的Id
	public static int getMainThreadId() {
		return mainThreadId;
	}

	// 获取主线程的handler
	public static Handler getMainHandler() {
		return mainHandler;
	}

	// 获取主线程
	public static Thread getMainThread() {
		return mainThread;
	}
	
	public static  void putShoppingCar(String id,Fruit fruit){
		shoppingCar.put(id, fruit);
		subject.ontifyObserver();
	}
	
	public static Fruit getShoppingCar(String id){
		return shoppingCar.get(id);
	}
}
