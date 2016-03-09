/**
 * 
 */
package com.aishuiguo.base;

import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * @author liangshan
 * 
 *         created on 2016-3-6下午1:52:28
 */
@SuppressWarnings("rawtypes")
public abstract class MyBaseAdapter<T> extends BaseAdapter {

	protected List<T> mData;

	/* 
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mData != null ? mData.size() : 0;
	}

	/* 
	 */
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mData.get(position);
	}

	/* 
	 */
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	/* 
	 */
	@SuppressWarnings({ "unchecked" })
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		BaseViewHolder viewHolder;
		if (convertView == null) {
			viewHolder = getViewHolder();
		} else {
			viewHolder = (BaseViewHolder) convertView.getTag();
		}
		viewHolder.setData(mData.get(position));
		viewHolder.refreshView();
		return viewHolder.getView();
	}

	public abstract BaseViewHolder getViewHolder();

}
