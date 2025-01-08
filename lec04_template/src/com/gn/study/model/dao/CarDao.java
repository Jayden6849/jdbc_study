package com.gn.study.model.dao;

import static com.gn.study.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.gn.study.model.vo.Car;

public class CarDao {
	public int insertCarOne(Car car, Connection conn) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			String sql = "INSERT INTO car (car_model ,car_price ,car_date) VALUES (?, ?, STR_TO_DATE(?, '%Y-%m-%d'))";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, car.getCarModel());
			pstmt.setInt(2, car.getCarPrice());
			pstmt.setString(3, car.getCarDate());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public List<Car> selectCarAll(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Car> list = null;
		
		try {
			String sql = "SELECT * FROM car";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			list = new ArrayList<>();
			while(rs.next()) {
				Car car = new Car();
				car.setCarNo(rs.getInt("car_no"));
				car.setCarModel(rs.getString("car_model"));
				car.setCarPrice(rs.getInt("car_price"));
				
				if(rs.getDate("car_date") != null) {
					car.setCarDate(sdf.format(rs.getDate("car_date")));
				} else {
					car.setCarDate("미정");
				}
				
				list.add(car);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
	public Car selectCarByModelNo(int modelNo, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Car car = null;
		
		try {
			String sql = "SELECT * FROM car WHERE car_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, modelNo);
			
			rs = pstmt.executeQuery();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			if(rs.next()) {
				car = new Car();
				car.setCarNo(rs.getInt("car_no"));
				car.setCarModel(rs.getString("car_model"));
				car.setCarPrice(rs.getInt("car_price"));
				
				if(rs.getDate("car_date") != null) {
					car.setCarDate(sdf.format(rs.getDate("car_date")));
				} else {
					car.setCarDate("미정");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return car;
	}
	
	public Car selectCarByModelName(String modelName, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Car car = null;
		
		try {
			String sql = "SELECT * FROM car WHERE car_model = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, modelName);
			
			rs = pstmt.executeQuery();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			if(rs.next()) {
				car = new Car();
				car.setCarNo(rs.getInt("car_no"));
				car.setCarModel(rs.getString("car_model"));
				car.setCarPrice(rs.getInt("car_price"));
				
				if(rs.getDate("car_date") != null) {
					car.setCarDate(sdf.format(rs.getDate("car_date")));
				} else {
					car.setCarDate("미정");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return car;
	}
	
	public List<Car> selectCarByModelPrice(int modelPrice, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Car> list = null;
		
		try {
			String sql = "SELECT * FROM car WHERE car_price = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, modelPrice);
			
			rs = pstmt.executeQuery();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			list = new ArrayList<>();
			while(rs.next()) {
				Car car = new Car();
				car.setCarNo(rs.getInt("car_no"));
				car.setCarModel(rs.getString("car_model"));
				car.setCarPrice(rs.getInt("car_price"));
				
				if(rs.getDate("car_date") != null) {
					car.setCarDate(sdf.format(rs.getDate("car_date")));
				} else {
					car.setCarDate("미정");
				}
				
				list.add(car);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
	public List<Car> selectCarByModelDate(String modelDate, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Car> list = null;
		
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			String sql = "SELECT * FROM car WHERE car_date = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, modelDate.formatted(dtf));
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rs.next()) {
				Car car = new Car();
				car.setCarNo(rs.getInt("car_no"));
				car.setCarModel(rs.getString("car_model"));
				car.setCarPrice(rs.getInt("car_price"));
				
				if(rs.getDate("car_date") != null) {
					car.setCarDate(sdf.format(rs.getDate("car_date")));
				} else {
					car.setCarDate("미정");
				}
				
				list.add(car);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
}
