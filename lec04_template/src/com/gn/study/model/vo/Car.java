package com.gn.study.model.vo;

public class Car {
	// field
	private int carNo;
	private String carModel;
	private int carPrice;
	private String carDate;
	
	// constructor
	public Car() {
		super();
	}
	public Car(String carModel, int carPrice, String carDate) {
		super();
		this.carModel = carModel;
		this.carPrice = carPrice;
		this.carDate = carDate;
	}
	public Car(int carNo, String carModel, int carPrice, String carDate) {
		super();
		this.carNo = carNo;
		this.carModel = carModel;
		this.carPrice = carPrice;
		this.carDate = carDate;
	}
	
	// getter, setter
	public int getCarNo() {
		return carNo;
	}
	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public int getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	public String getCarDate() {
		return carDate;
	}
	public void setCarDate(String carDate) {
		this.carDate = carDate;
	}
	
	@Override
	public String toString() {
		return "[번호=" + carNo + ", 모델=" + carModel + ", 가격=" + carPrice + ", 출시일=" + carDate
				+ "]";
	}
}
