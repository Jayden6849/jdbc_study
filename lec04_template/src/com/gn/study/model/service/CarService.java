package com.gn.study.model.service;

import static com.gn.study.common.JDBCTemplate.close;
import static com.gn.study.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.gn.study.model.dao.CarDao;
import com.gn.study.model.vo.Car;

// DB에 접속 -> Connection 객체 생성
public class CarService {
	private CarDao cd = new CarDao();
	
	public int insertCarOne(Car car) {
		Connection conn = getConnection();
		
		int result = cd.insertCarOne(car, conn);
		close(conn);
		
		return result;
	}
	
	public List<Car> selectCarAll() {
		Connection conn = getConnection();
		
		List<Car> list = cd.selectCarAll(conn);
		close(conn);
		
		return list;
	}
	
	public Car selectCarByModelNo(int modelNo) {
		Connection conn = getConnection();
		
		Car car = cd.selectCarByModelNo(modelNo, conn);
		close(conn);
		
		return car;
	}
	public Car selectCarByModelName(String modelName) {
		Connection conn = getConnection();
		
		Car car = cd.selectCarByModelName(modelName, conn);
		close(conn);
		
		return car;
	}
	public List<Car> selectCarByModelPrice(int modelPrice) {
		Connection conn = getConnection();
		
		List<Car> list = cd.selectCarByModelPrice(modelPrice, conn);
		close(conn);
		
		return list;
	}
	public List<Car> selectCarByModelDate(String modelDate) {
		Connection conn = getConnection();
		
		List<Car> list = cd.selectCarByModelDate(modelDate, conn);
		close(conn);
		
		return list;
	}
	
	public int updateCarInfo(int carNo, String carModel, int carPrice, String carDate) {
		Connection conn = getConnection();
		
		int result = cd.updateCarInfo(carNo, carModel, carPrice, carDate, conn);
		close(conn);
		
		return result;
	}
	
	public int deleteCarOne(int carNo) {
		Connection conn = getConnection();
		
		int result = cd.deleteCarOne(carNo, conn);
		close(conn);
		
		return result;
	}
}
