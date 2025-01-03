package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.dao.MemberDao;
import com.gn.study.model.vo.Member;

public class MemberController {
	private MemberDao md = new MemberDao();
	
	public int insertMember(String memberId, String memberPw, String memberName, String memberEmail, String memberPhone, String memberGender) {
		Member m = new Member(memberId, memberPw, memberName, memberEmail, memberPhone, memberGender);
		int result = md.insertMember(m);
		return result;
	}
	public List<Member> selectMemberAll() {
		List<Member> list = md.selectMemberAll();
		
		return list;
	}
}
