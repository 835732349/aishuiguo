/**
 * 
 */
package com.aishuiguo.adapter;

import com.aishuiguo.base.BaseFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * @author liangshan
 * 
 *         created on 2016-2-24下午11:33:37
 */
public class MainFragmentAdapter extends FragmentPagerAdapter {
	// homefragment、cateGoryFragment、shoppingCarFragment、personFragment共4个
	private BaseFragment [] fragments;

	public MainFragmentAdapter(FragmentManager fm,BaseFragment[] fragments) {
		super(fm);
		this.fragments=fragments;
		// TODO Auto-generated constructor stub
	}

	/* 
	 */
	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return fragments[arg0];
	}

	/* 
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragments.length;
	}

}
