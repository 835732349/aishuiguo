package com.shan.aishuiguo;

import java.util.ArrayList;

import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.aishuiguo.base.BaseActivity;
import com.aishuiguo.viewholder.HomeHeadHolder;

public class FruitDetailActivity extends BaseActivity {

	// 水果的图片
	private ViewPager mViewPager;
	// 水果描述
	private TextView mFruitDesc;
	private ArrayList<String> d;

	/* 
	 */
	@Override
	public void initView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_fruit_detail);
		mViewPager = (ViewPager) findViewById(R.id.vp_page);
		mFruitDesc = (TextView) findViewById(R.id.tv_fruitDesc);

	}

	/* 
	 */
	@Override
	public void initData() {
		// TODO Auto-generated method stub
		d = new ArrayList<String>();
		d.add("http://192.168.191.1:8088/test/01.jpg");
		d.add("http://192.168.191.1:8088/test/02.jpg");
		d.add("http://192.168.191.1:8088/test/03.jpg");
		HomeHeadHolder homeHeadHolder = new HomeHeadHolder();
		homeHeadHolder.setData(d);
	}

	/* 
	 */
	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

}
