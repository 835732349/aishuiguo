package com.shan.aishuiguo;

import java.util.Map;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.aishuiguo.adapter.MainFragmentAdapter;
import com.aishuiguo.base.BaseActivity;
import com.aishuiguo.base.BaseFragment;
import com.aishuiguo.fragment.CategoryFramgent;
import com.aishuiguo.fragment.HomeFramgent;
import com.aishuiguo.fragment.PersonFramgent;
import com.aishuiguo.fragment.ShoppingCarFramgent;
import com.aishuiguo.utils.CommonUtils;

public class MainActivity extends BaseActivity {

	private RadioGroup mTabButtonGroup;
	private ViewPager mViewPager;
	// 存放底部TabRadioButton
	private RadioButton[] mRadioButtons;
	// 标题
	private TextView mTitle;
	// 标题文本
	private String mTitleTexts[];
	// fragment数组；
	private BaseFragment[] mFragments;

	// 创建fragment
	private void createFramgents() {
		mFragments = new BaseFragment[4];
		mFragments[0] = new HomeFramgent();
		mFragments[1] = new CategoryFramgent();
		mFragments[2] = new ShoppingCarFramgent();
		mFragments[3] = new PersonFramgent();
	}

	/* 
	 */
	@Override
	public void initView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_main);
		mTabButtonGroup = (RadioGroup) findViewById(R.id.rg_tab_buttons);
		mTitle = (TextView) findViewById(R.id.tv_title);
		mViewPager = (ViewPager) findViewById(R.id.vp_page);
		// 获取底部Tab按钮的标题
		mRadioButtons = new RadioButton[mTabButtonGroup.getChildCount()];
		// 把底部的TabButton都放进一个数组里
		for (int i = 0; i < mRadioButtons.length; i++) {
			mRadioButtons[i] = (RadioButton) mTabButtonGroup.getChildAt(i);
		}
	}

	/* 
	 */
	@Override
	public void initData() {
		// TODO Auto-generated method stub
		// 获取标题文本
		mTitleTexts = CommonUtils.getStringArray(R.array.titleTexts);
		createFramgents();
		// 设置首页的标题
		mTitle.setText(mTitleTexts[0]);
		// 加载首页的fragment内容
	}

	/* 
	 */
	@Override
	public void initListener() {
		// 为viewpager设置适配器
		mViewPager.setAdapter(new MainFragmentAdapter(
				getSupportFragmentManager(), mFragments));
		// 将底部的菜单和Viewpager关联起来
		mTabButtonGroup
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						// TODO Auto-generated method stub
						for (int i = 0; i < mRadioButtons.length; i++) {
							if (checkedId == mRadioButtons[i].getId()) {
								mViewPager.setCurrentItem(i);
							}
						}
					}
				});
		// 设置TabRadioButton的选中状态和Viewpager的当前页面相对应
		mViewPager.addOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				mRadioButtons[position].setChecked(true);
				// 设置当前的标题
				mTitle.setText(mTitleTexts[position]);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

}
