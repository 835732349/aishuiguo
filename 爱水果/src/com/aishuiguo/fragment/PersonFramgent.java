/**
 * 
 */
package com.aishuiguo.fragment;

import android.view.View;

import com.aishuiguo.base.BaseFragment;
import com.aishuiguo.base.ContentPage.ResultState;
import com.aishuiguo.utils.CommonUtils;
import com.shan.aishuiguo.R;

/**
 * @author liangshan
 * 
 *         created on 2016-2-24下午11:41:30
 */
public class PersonFramgent extends BaseFragment {

	/* 
	 */
	@Override
	public ResultState onLoad() {
		// TODO Auto-generated method stub
		return ResultState.STATE_RESULT_SUCCESS;
	}

	/* 
	 */
	@Override
	public View createView() {
		// TODO Auto-generated method stub
		View view=CommonUtils.inflate(R.layout.layout_person);
		return view;
	}

}
