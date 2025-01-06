package com.gn.wmmusic.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class WmDao {
	public int signUp(String memId, String memPw, String memName) {
		Connection conn = null;
		Statement stmt = null;
		
		int result = 0;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			String id = "scott";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(url, id, pw);
			
			stmt = conn.createStatement();
			
			String SQL = "INSERT INTO wm_user (user_id, user_pw ,user_name) VALUES ('"+memId+"' ,'"+memPw+"' ,'"+memName+"')";
			result = stmt.executeUpdate(SQL);		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
