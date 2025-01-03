package com.gn.study.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gn.study.model.vo.Member;

public class MemberDao {
	public int insertMember(Member m) {
		Connection conn = null;
		Statement stmt = null;
		
		int result = 0;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pwd = "tiger";
			
			conn = DriverManager.getConnection(url, id, pwd);
			stmt = conn.createStatement();
		    
		    String sql = "INSERT INTO member (m_id ,m_pw ,m_name ,m_email ,m_phone ,m_gender)"
		    		+ " VALUES ('"+m.getMemberId() +"', '"+m.getMemberPw()+"', '"+m.getMemberName()+"', '"+m.getMemberEmail()+"', '"+m.getMemberPhone()+"', '"+m.getMemberGender()+"')";
			result = stmt.executeUpdate(sql);
		    
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
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
	public List<Member> selectMemberAll() {
		// 전체 멤버를 조회 -> List<Member> 형태로 리턴할 것임
		List<Member> list = new ArrayList<>();
		// DB에 SQL문 요청 후 반환
		
		
		return list;
	}
}
