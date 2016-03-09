/**
 * 
 */
package com.aishuiguo.adapter;

import java.util.List;

import com.aishuiguo.base.BaseViewHolder;
import com.aishuiguo.base.MyBaseAdapter;
import com.aishuiguo.bean.Fruit;
import com.aishuiguo.viewholder.FruitListItemHolder;

/**
 * @author liangshan
 * 
 *         created on 2016-3-6下午2:09:41
 */
public class HomeFragmentAdapter extends MyBaseAdapter<Fruit> {

	public HomeFragmentAdapter(List<Fruit> data) {
		// TODO Auto-generated constructor stub
		mData = data;

	}

	/* 
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public BaseViewHolder getViewHolder() {
		// TODO Auto-generated method stub
		return new FruitListItemHolder();
	}

}
