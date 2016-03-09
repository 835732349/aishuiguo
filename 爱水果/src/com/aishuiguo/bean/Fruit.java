/**
 * 
 */
package com.aishuiguo.bean;

import java.nio.Buffer;

/**
 * @author liangshan
 * 
 *         created on 2016-3-8下午2:26:39
 */
public class Fruit {

	// 水果产品的编号
	private String id;
	// 水果的单价
	private float price;
	// 水果的名字
	private String name;
	// 销量
	private int saleVolume;

	// 水果的图片url
	private String pictureUrl;

	// 购买的水果数量
	private int buyNum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Fruit() {
	}

	public Fruit(String id, float price, String name, int saleVolume,
			String pictureUrl,int buyNum) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
		this.saleVolume = saleVolume;
		this.pictureUrl = pictureUrl;
		this.buyNum=buyNum;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSaleVolume() {
		return saleVolume;
	}

	public void setSaleVolume(int saleVolume) {
		this.saleVolume = saleVolume;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public int getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
}
