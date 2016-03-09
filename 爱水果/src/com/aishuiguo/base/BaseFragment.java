/**
 * 
 */
package com.aishuiguo.base;

import java.util.List;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aishuiguo.base.ContentPage.ResultState;
import com.aishuiguo.utils.CommonUtils;

/**
 * @author liangshan
 * 
 *         created on 2016-2-24下午10:33:46
 */
public abstract class BaseFragment extends Fragment {

	private ContentPage contentPage;

	/* 
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if (contentPage == null) {
			contentPage = new ContentPage(CommonUtils.getContext()) {

				@Override
				protected View onCreateSuccessView() {
					// TODO Auto-generated method stub
					return BaseFragment.this.createView();
				}

				@Override
				protected ResultState onLoad() {
					// TODO Auto-generated method stub
					return BaseFragment.this.onLoad();
				}

			};
		} else {
			CommonUtils.removeParentFromSelf(contentPage);
		}
		return contentPage;
	}

	public void onLoadRefresh() {
		if (contentPage != null) {
			contentPage.loadAndRefresh();
		}
	}

	@SuppressWarnings("rawtypes")
	public ResultState check(List data) {
		if (data != null) {
			if (data.size() == 0) {
				return ResultState.STATE_RESULT_EMPTY;
			} else {
				return ResultState.STATE_RESULT_SUCCESS;
			}

		} else {
			return ResultState.STATE_RESULT_ERROR;
		}
	}
	/* 
	 */
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		onLoadRefresh();
	}

	public abstract ResultState onLoad();

	public abstract View createView();
}
