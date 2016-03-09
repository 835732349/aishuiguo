/**
 * 
 */
package com.aishuiguo.base;

import android.view.View;

/**
 * @author liangshan
 * 
 *         created on 2016-3-6下午1:55:25
 */
public abstract class BaseViewHolder<T> {

	protected T mData;
	// viewHolder的view
	protected View rootView;

	public BaseViewHolder() {
		// TODO Auto-generated constructor stub
		rootView = initView();
	}

	public View getView() {
		// TODO Auto-generated method stub
		rootView.setTag(this);
		return rootView;
	}

	// 初始化View
	public abstract View initView();

	public abstract void refreshView();

	public T getData() {
		return mData;
	}

	public void setData(T mData) {
		this.mData = mData;
	}

}
