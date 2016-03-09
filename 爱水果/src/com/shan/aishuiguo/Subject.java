/**
 * 
 */
package com.shan.aishuiguo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangshan
 *
 * created on 2016-3-9下午5:09:20
 */
public class Subject {

	
	public Subject() {
		super();
		observers=new ArrayList<Observer>();
	}
	private List<Observer> observers;
	
	//注册观察者
	public void addObserver(Observer Observer){
		observers.add(Observer);
	}
	//注销观察者
	public void removeObserver(Observer observer){
		observers.remove(observer);
	}
	//通知观察者
	public void ontifyObserver(){
		for(Observer observer:observers){
			observer.update();
		}
	}
	
}
