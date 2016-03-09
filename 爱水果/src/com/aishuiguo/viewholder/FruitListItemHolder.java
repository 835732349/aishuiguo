/**
 * 
 */
package com.aishuiguo.viewholder;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.aishuiguo.base.BaseApplication;
import com.aishuiguo.base.BaseViewHolder;
import com.aishuiguo.bean.Fruit;
import com.aishuiguo.utils.BitmapHelper;
import com.aishuiguo.utils.CommonUtils;
import com.lidroid.xutils.BitmapUtils;
import com.shan.aishuiguo.R;

/**
 * @author liangshan
 * 
 *         created on 2016-3-6下午2:12:11
 */
public class FruitListItemHolder extends BaseViewHolder<Fruit> {

	// 购买的数量
	private int mBuyNum = 0;
	// 显示水果名称的textView
	private TextView mFruitName;
	// 销量
	private TextView mFruitSallVolume;
	// 水果的价格
	private TextView mFruitPrice;
	// 购买数量
	private TextView mBuyNumView;
	// 添加购买数量按钮
	private ImageView mAddButton;
	// 减少购买数量按钮
	private ImageView mReduceButton;
	// 水果的图片
	private ImageView mFruitPic;

	/* 
	 */
	@Override
	public View initView() {
		// TODO Auto-generated method stub
		View view = CommonUtils.inflate(R.layout.layout_fruit_item);
		mFruitName = (TextView) view.findViewById(R.id.tv_fruit_name);
		mFruitPrice = (TextView) view.findViewById(R.id.tv_fruit_price);
		mFruitSallVolume = (TextView) view
				.findViewById(R.id.tv_fruit_sale_volume);
		mBuyNumView = (TextView) view.findViewById(R.id.tv_buy_num);
		mAddButton = (ImageView) view.findViewById(R.id.iv_add);
		mReduceButton = (ImageView) view.findViewById(R.id.iv_reduce);
		mFruitPic = (ImageView) view.findViewById(R.id.iv_fruit_image);
		initListener();
		return view;
	}

	private void initListener() {
		// TODO Auto-generated method stub

		// 给加按钮绑定监听事件
		mAddButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				addBuyNum();

			}
		});
		// 给减按钮绑定监听事件
		mReduceButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				reduceBuyNum();
			}
		});
	}

	protected void reduceBuyNum() {
		// TODO Auto-generated method stub
		mBuyNum--;
		BaseApplication.totalPrice = BaseApplication.totalPrice
				- mData.getPrice();
		setBuyNum(mBuyNum);
	}

	// 添加购买数量
	protected void addBuyNum() {
		// TODO Auto-generated method stub
		mBuyNum++;
		// 计算总价
		BaseApplication.totalPrice = BaseApplication.totalPrice
				+ mData.getPrice();
		setBuyNum(mBuyNum);
	}

	private void setBuyNum(int number) {
		// TODO Auto-generated method stub
		// 更新购物车里的商品数量
		mData.setBuyNum(mBuyNum);
		BaseApplication.putShoppingCar(mData.getId(), mData);
		mBuyNumView.setText("" + mBuyNum);
		// 根据是否有购买数量判断减按钮和数量控件是否显示
		if (mBuyNum > 0) {
			mBuyNumView.setVisibility(View.VISIBLE);
			mReduceButton.setVisibility(View.VISIBLE);
		} else {
			mBuyNumView.setVisibility(View.GONE);
			mReduceButton.setVisibility(View.GONE);
		}

	}

	/* 
	 */
	@Override
	public void refreshView() {
		// TODO Auto-generated method stub
		// 设置水果的名称
		mFruitName.setText(mData.getName());
		// 设置水果的销量
		mFruitSallVolume.setText(mData.getSaleVolume() + "");
		// 设置水果的价格
		mFruitPrice.setText(mData.getPrice() + "");
		// 设置水果的图片
		BitmapUtils bitmapUtils = BitmapHelper.getBitmapUtils();
		bitmapUtils.display(mFruitPic, mData.getPictureUrl());
		// 查找购物车是否已有该商品
		Fruit fruit = BaseApplication.getShoppingCar(mData.getId());
		if (fruit == null) {
			mBuyNum = 0;
		} else {
			mBuyNum = fruit.getBuyNum();
		}
		// 设置购买数量
		setBuyNum(mBuyNum);
	}
}
