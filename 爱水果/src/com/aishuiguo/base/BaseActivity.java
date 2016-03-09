/**
 * 
 */
package com.aishuiguo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * @author liangshan
 * 
 *         created on 2016-3-6上午10:32:50
 */
public abstract class BaseActivity extends FragmentActivity {

	/* 
	 */
	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		initView();
		initData();
		initListener();
	}

	//初始化view
	public abstract void initView();

	//初始化数据
	public abstract void initData();

	//设置监听器
	public abstract void initListener();

}
