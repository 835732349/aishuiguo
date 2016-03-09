package com.shan.aishuiguo;

import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.aishuiguo.base.BaseActivity;

public class ActiveActivity extends BaseActivity {

	private WebView mWebView;

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_active);
		mWebView = (WebView) findViewById(R.id.wv_active_view);
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		Intent intent = getIntent();
		String url = intent.getStringExtra("url");
		mWebView.loadUrl(url);
		mWebView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				// 返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
				view.loadUrl(url);
				return true;
			}
		});
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

}
