package com.gn.study.view;

import java.util.List;
import java.util.Scanner;

import com.gn.study.controller.MemberController;
import com.gn.study.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== 회원 관리 프로그램 ===");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 아이디 검색");
			System.out.println("4. 회원 이름으로 키워드 검색");
			System.out.println("5. 회원 정보 수정");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 0:
				System.out.println("잘가요~안녕~");
				sc.close();
				return;
			case 1:
				createMember();
				break;
			case 2:
				selectMemberAll();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				System.out.println("올바른 메뉴를 선택해주세요");
				continue;
			}
		}
	}
	
	// 회원 정보 추가
	public void createMember() {
		System.out.println("=== 회원 정보 추가 ===");
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String memberPw = sc.nextLine();
		System.out.print("이름 : ");
		String memberName = sc.nextLine();
		System.out.print("이메일 : ");
		String memberEmail = sc.nextLine();
		System.out.print("전화번호(-빼고 입력) : ");
		String memberPhone = sc.nextLine();
		System.out.print("성별 : ");
		String memberGender = sc.nextLine();
		
		int result = mc.insertMember(memberId, memberPw, memberName, memberEmail, memberPhone, memberGender);
		if(result > 0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}
	// 전체 회원 조회
	public void selectMemberAll() {
		System.out.println("=== 회원 전체 조회 ===");
		List<Member> list = mc.selectMemberAll();
		// 만약 list가 비어있다면?
		if(list.isEmpty()) System.out.println("조회된 결과가 없습니다.");
		else {
			for(Member l : list) {
				System.out.println(l);
			}
		}
	}
}
