/**
 * 
 */
package com.aishuiguo.viewholder;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.aishuiguo.base.BaseViewHolder;
import com.aishuiguo.utils.BitmapHelper;
import com.aishuiguo.utils.CommonUtils;
import com.lidroid.xutils.BitmapUtils;
import com.shan.aishuiguo.ActiveActivity;
import com.shan.aishuiguo.R;

/**
 * @author liangshan
 * 
 *         created on 2016-3-6下午11:34:06
 */

public class HomeHeadHolder extends BaseViewHolder<List<String>> {

	public static final long DELAYED_TIME = 3000;
	private RelativeLayout relativeLayout;
	private ViewPager viewPager;
	private List<String> picList;
	private List<View> viewList = new ArrayList<View>();

	@Override
	public View initView() {
		// 加载view，xml--->view
		relativeLayout = new RelativeLayout(CommonUtils.getContext());

		AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
				AbsListView.LayoutParams.MATCH_PARENT,
				CommonUtils.getDimens(R.dimen.home_list_header_height));
		relativeLayout.setLayoutParams(layoutParams);

		viewPager = new ViewPager(CommonUtils.getContext());
		RelativeLayout.LayoutParams rlParams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.MATCH_PARENT);
		relativeLayout.addView(viewPager, rlParams);

		return relativeLayout;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void refreshView() {
		picList = getData();
		// 创建轮播图对应点所在布局的操作，将点加入
		LinearLayout linearLayout = new LinearLayout(CommonUtils.getContext());

		// 由相对布局给线性布局宽高，所在位置的规则
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		// 设置线性布局在相对布局的右下角
		params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		relativeLayout.addView(linearLayout, params);

		viewList.clear();
		for (int i = 0; i < picList.size(); i++) {
			View view = new View(CommonUtils.getContext());
			if (i == 0) {
				view.setBackgroundResource(R.drawable.indicator_selected);
			} else {
				view.setBackgroundResource(R.drawable.indicator_normal);
			}
			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
					CommonUtils.dip2px(6), CommonUtils.dip2px(6));
			layoutParams.setMargins(0, 0, CommonUtils.dip2px(6),
					CommonUtils.dip2px(6));
			linearLayout.addView(view, layoutParams);

			// 循环过程中添加对应的点
			viewList.add(view);
		}
		// 给viewpager设置数适配器操作
		viewPager.setAdapter(new MyAdapter());
		viewPager.setCurrentItem(1000 * picList.size());
		// 监听对应的选中界面操作

		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int arg0) {
				int index = arg0 % picList.size();
				for (int i = 0; i < viewList.size(); i++) {
					if (i == index) {
						viewList.get(index).setBackgroundResource(
								R.drawable.indicator_selected);
					} else {
						viewList.get(i).setBackgroundResource(
								R.drawable.indicator_normal);
					}
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

		new RunnableTask().start();
	}

	class RunnableTask implements Runnable {
		public void start() {
			CommonUtils.removeCallback(this);
			CommonUtils.postDelayed(this, DELAYED_TIME);
		}

		@Override
		public void run() {
			// 维护viewpager指向下一个界面
			int position = viewPager.getCurrentItem();
			viewPager.setCurrentItem(position + 1);
			// 维护一个任务，
			CommonUtils.removeCallback(this);
			CommonUtils.postDelayed(this, DELAYED_TIME);
		}
	}

	class MyAdapter extends PagerAdapter implements OnClickListener {
		private BitmapUtils bitmapUtils;

		@Override
		public int getCount() {
			return Integer.MAX_VALUE;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			ImageView imageView =new ImageView(CommonUtils.getContext());
			bitmapUtils = BitmapHelper.getBitmapUtils();
			bitmapUtils.display(imageView, mData.get(position % mData.size()));
			imageView.setClickable(true);
			imageView.setOnClickListener(this);
			container.addView(imageView);
			return imageView;
		}

		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

		/* 
		 */
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(CommonUtils.getContext(),ActiveActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.putExtra("url", "http://www.baidu.com");
			CommonUtils.getContext().startActivity(intent);
		};
	}
}
