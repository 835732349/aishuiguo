/**
 * 
 */
package com.aishuiguo.base;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.aishuiguo.utils.CommonUtils;
import com.shan.aishuiguo.R;

/**
 * @author liangshan
 * 
 *         created on 2016-2-24下午10:45:32 封装内容的页面，根据状态控制显示的内容
 */
public abstract class ContentPage extends FrameLayout {
	// 正在加载
	protected final static int STATE_LOADING = 0;
	// 加载失败
	protected final static int STATE_ERROR = 1;
	// 返回数据为空
	protected final static int STATE_EMPTY = 2;
	// 加载成功
	protected final static int STATE_SUCCESS = 3;

	// 当前请求状态
	private int current_state;
	private FrameLayout.LayoutParams param;

	private View loadingView;
	private View errorView;
	private View emptyView;
	private View successView;

	public ContentPage(Context context) {
		super(context);
		param = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.MATCH_PARENT);

		initView();
		showPage();
	}

	/**
	 * 初始化界面
	 */
	private void initView() {
		// 给状态赋初值
		current_state = STATE_LOADING;

		// 正在加载
		loadingView = CommonUtils.inflate(R.layout.layout_loading);
		addView(loadingView, param);
		// 加载失败
		errorView = CommonUtils.inflate(R.layout.layout_error);
		errorView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 重试时,再次加载数据
				loadAndRefresh();
			}
		});
		addView(errorView, param);
		// 数据为空
		emptyView = CommonUtils.inflate(R.layout.layout_empty);
		addView(emptyView, param);

	}

	/**
	 * 加载数据并更新界面
	 */
	public void loadAndRefresh() {
		// 每次加载数据前，改变当前状态，并更新界面
		current_state = STATE_LOADING;
		showPage();

		// 在子线程中获取网络数据
		new Thread(new Runnable() {

			@Override
			public void run() {
				// 获取网络数据
				ResultState onLoadState = onLoad();
				current_state = onLoadState.getValue();
				showPageSafe();
			}
		}).start();
	}

	/**
	 * 安全显示界面的方法
	 */
	protected void showPageSafe() {
		CommonUtils.runInMainThread(new Runnable() {

			@Override
			public void run() {
				showPage();
			}
		});
	}

	/**
	 * 根据当前网络访问的状态，决定View的显示和隐藏
	 */
	private void showPage() {
		if (loadingView != null) {
			loadingView
					.setVisibility(current_state == STATE_LOADING ? View.VISIBLE
							: View.GONE);
		}

		if (emptyView != null) {
			emptyView.setVisibility(current_state == STATE_EMPTY ? View.VISIBLE
					: View.GONE);
		}

		if (errorView != null) {
			errorView.setVisibility(current_state == STATE_ERROR ? View.VISIBLE
					: View.GONE);
		}

		if (current_state == STATE_SUCCESS) {
			// 如果当前已有successView，则从ContentPage中移除
			if (successView != null) {
				removeView(successView);
			}

			successView = onCreateSuccessView();
			addView(successView, param);
		}

		if (successView != null) {
			successView
					.setVisibility(current_state == STATE_SUCCESS ? View.VISIBLE
							: View.GONE);
		}
	}

	// 因为在每个子Fragment中，加载成功对应的界面都可能不同，
	// 对父类来说是未知，那么就交给子类去完成
	protected abstract View onCreateSuccessView();

	/**
	 * 获取网络数据 同理，每个子Fragment加载的数据不同，返回的状态也可能不同， 对父类来说是未知，那么就交给子类去完成
	 */
	protected abstract ResultState onLoad();

	public enum ResultState {
		STATE_RESULT_LOADING(0), STATE_RESULT_ERROR(1), STATE_RESULT_EMPTY(2), STATE_RESULT_SUCCESS(
				3);

		private final int value;

		private ResultState(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}
}
