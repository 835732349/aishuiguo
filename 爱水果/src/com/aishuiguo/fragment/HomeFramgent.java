/**
 * 
 */
package com.aishuiguo.fragment;

import java.util.ArrayList;
import java.util.List;

import android.R.bool;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.aishuiguo.adapter.HomeFragmentAdapter;
import com.aishuiguo.base.BaseApplication;
import com.aishuiguo.base.BaseFragment;
import com.aishuiguo.base.ContentPage.ResultState;
import com.aishuiguo.bean.Fruit;
import com.aishuiguo.utils.CommonUtils;
import com.aishuiguo.viewholder.HomeHeadHolder;
import com.shan.aishuiguo.Observer;
import com.shan.aishuiguo.R;

/**
 * @author liangshan
 * 
 *         created on 2016-2-24下午11:41:30
 */
public class HomeFramgent extends BaseFragment implements Observer {

	private List<Fruit> list;
	private ArrayList<String> d;
	private View mGotoShoppingCarBar;
	private Button mGotoPay;
	private TextView mTotalPrice;

	/* 
	 */
	@Override
	public ResultState onLoad() {
		// TODO Auto-generated method stub
		list = new ArrayList<Fruit>();
		list.add(new Fruit("sp01", 34, "法国葡萄", 23,
				"http://192.168.191.1:8088/test/test.png", 0));
		list.add(new Fruit("sp02", 34, "台湾青枣", 23,
				"http://192.168.191.1:8088/test/test.png", 0));
		list.add(new Fruit("sp03", 34, "凤梨", 23,
				"http://192.168.191.1:8088/test/test.png", 0));
		list.add(new Fruit("sp04", 34, "法国葡萄", 23,
				"http://192.168.191.1:8088/test/test.png", 0));
		list.add(new Fruit("sp05", 34, "法国葡萄", 23,
				"http://192.168.191.1:8088/test/test.png", 0));
		list.add(new Fruit("sp06", 34, "贡品梨", 23,
				"http://192.168.191.1:8088/test/test.png", 0));
		list.add(new Fruit("sp07", 34, "贡品梨", 23,
				"http://192.168.191.1:8088/test/test.png", 0));
		list.add(new Fruit("sp08", 34, "贡品梨", 23,
				"http://192.168.191.1:8088/test/test.png", 0));
		list.add(new Fruit("sp09", 34, "贡品梨", 23,
				"http://192.168.191.1:8088/test/test.png", 0));
		list.add(new Fruit("sp10", 34, "贡品梨", 23,
				"http://192.168.191.1:8088/test/test.png", 0));
		list.add(new Fruit("sp11", 34, "贡品梨", 23,
				"http://192.168.191.1:8088/test/test.png", 0));

		d = new ArrayList<String>();
		d.add("http://192.168.191.1:8088/test/01.jpg");
		d.add("http://192.168.191.1:8088/test/02.jpg");
		d.add("http://192.168.191.1:8088/test/03.jpg");
		return ResultState.STATE_RESULT_SUCCESS;
	}

	/* 
	 */
	@Override
	public View createView() {
		// TODO Auto-generated method stub
		View view = CommonUtils.inflate(R.layout.layout_go_shoppingcar);
		mGotoPay = (Button) view.findViewById(R.id.btn_goto_pay);
		mTotalPrice = (TextView) view.findViewById(R.id.tv_total_price);
		SwipeRefreshLayout refreshLayout = (SwipeRefreshLayout) view
				.findViewById(R.id.srl_refresh_layout);
		ListView listView = (ListView) view.findViewById(R.id.lv_fruit_list);
		mGotoShoppingCarBar = view.findViewById(R.id.rl_goto_shoppingcar_bar);
		HomeHeadHolder homeHeadHolder = new HomeHeadHolder();
		homeHeadHolder.setData(d);
		homeHeadHolder.refreshView();
		listView.addHeaderView(homeHeadHolder.getView());
		listView.addHeaderView(CommonUtils
				.inflate(R.layout.layout_home_category));
		listView.setAdapter(new HomeFragmentAdapter(list));
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(CommonUtils.getContext(), "点击了" + position,
						Toast.LENGTH_SHORT).show();
			}
		});
		

		// 注册观察者
		BaseApplication.subject.addObserver(this);

		return view;
	}

	/* 
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (mGotoShoppingCarBar != null) {
			if (BaseApplication.totalPrice > 0) {
				mGotoShoppingCarBar.setVisibility(View.VISIBLE);
				//显示总价格
				mTotalPrice.setText("总价："+BaseApplication.totalPrice + "元");
			} else {
				mGotoShoppingCarBar.setVisibility(View.GONE);
			}
		}
	}
	
	/* 重写该函数，移除观察者
	 */
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		BaseApplication.subject.removeObserver(this);
	}
}
