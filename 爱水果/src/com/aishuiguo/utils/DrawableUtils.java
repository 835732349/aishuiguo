package com.aishuiguo.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

public class DrawableUtils {
	public static GradientDrawable getDrawable(int rgb,int strokeColor,int radius) {
		GradientDrawable gradientDrawable = new GradientDrawable();
		//绘画过程中对应图片的随机色值
		gradientDrawable.setColor(rgb);
		//设置绘画的内容
		gradientDrawable.setGradientType(GradientDrawable.RECTANGLE);
		//设置对应的圆角的半径
		gradientDrawable.setCornerRadius(radius);
		//设置对应图片边缘的颜色和大小
		gradientDrawable.setStroke(1, strokeColor);
		
		return gradientDrawable;
	}
	
	public static StateListDrawable getStateListDrawable(Drawable normalDrawable,Drawable pressDrawable){
		StateListDrawable stateListDrawable = new StateListDrawable();
		//给当前的颜色选择器添加选中图片指向状态，未选中图片指向状态
		stateListDrawable.addState(new int[]{
				android.R.attr.state_enabled,android.R.attr.state_pressed}, pressDrawable);
		stateListDrawable.addState(new int[]{
				android.R.attr.state_enabled}, normalDrawable);
		stateListDrawable.addState(new int[]{}, normalDrawable);
		return stateListDrawable;
	}
}
