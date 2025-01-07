package com.gn.supermarket.controller;

import com.gn.supermarket.model.dao.SmDao;
import com.gn.supermarket.model.vo.SmUser;

public class SmController {
	private SmDao sd = new SmDao();
	
	// 동일한 아이디가 있는지 체크하는 로직
	public SmUser chkUser(String id) {
		return sd.chkUser(id);
	}
	
	// 회원가입 로직 - sm_uwer테이블에 레코드를 추가
	public int insertUser(String id, String pw, String nickname) {
		return sd.insertUser(id, pw, nickname);
	}
}
