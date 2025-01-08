package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.service.CarService;
import com.gn.study.model.vo.Car;

// View로부터 전달받은 데이터 가공 -> Service 전달
public class Controller {
	private CarService cs = new CarService();
	
	public int insertCarOne(String modelName, int modelPrice, String date) {
		Car car = new Car(modelName, modelPrice, date);
		
		return cs.insertCarOne(car);
	}
	
	public List<Car> selectCarAll() {
		return cs.selectCarAll();
	}

	public Car selectCarByModelNo(int modelNo) {
		return cs.selectCarByModelNo(modelNo);
	}
	
	public Car selectCarByModelName(String modelName) {
		return cs.selectCarByModelName(modelName);
	}
	
	public List<Car> selectCarByModelPrice(int modelPrice) {
		return cs.selectCarByModelPrice(modelPrice);
	}
	
	public List<Car> selectCarByModelDate(String modelDate) {
		return cs.selectCarByModelDate(modelDate);
	}
}
