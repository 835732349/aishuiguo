/**
 * 
 */
package com.aishuiguo.base;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.shan.aishuiguo.R;

/**
 * @author liangshan
 * 
 *         created on 2016-3-7下午8:23:51
 */
public class BaseRefreshLayout extends SwipeRefreshLayout implements
		OnRefreshListener {

	public BaseRefreshLayout(Context context) {
		super(context);
		setColorSchemeResources(R.color.swiperefresh_color1,
				R.color.swiperefresh_color2, R.color.swiperefresh_color3,
				R.color.swiperefresh_color4);
	}

	/* 
	 */
	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		this.refresh();
	}

	public void refresh() {

	}

}
