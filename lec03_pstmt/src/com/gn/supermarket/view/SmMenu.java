package com.gn.supermarket.view;

import java.util.Scanner;

import com.gn.supermarket.controller.SmController;
import com.gn.supermarket.model.vo.SmUser;

public class SmMenu {
	private Scanner scan = new Scanner(System.in);
	private SmController sc = new SmController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("*** 환영합니다. 우리동네 슈퍼마켓입니다 ***");
			System.out.println("원하는 메뉴를 선택해주세요 (종료:99)");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.print("메뉴 선택 : ");
			int menu = scan.nextInt();
			scan.nextLine();
			
			switch(menu) {
			case 99:
				System.out.print("프로그램 종료");
				scan.close();
				return;
			case 1:
				signUp();
				break;
			case 2:
				logIn();
				break;
			default:
				System.out.println("올바른 메뉴를 선택해주세요");
				continue;
			}
		}
	}
	
	public void signUp() {
		System.out.println("*** 회원가입 ***");
		System.out.print("아이디 : ");
		String id = scan.nextLine();
		System.out.print("비밀번호 : ");
		String pw = scan.nextLine();
		System.out.print("닉네임 : ");
		String nickname = scan.nextLine();
		
		SmUser su = sc.chkUser(id);
		
		if(su == null) {
			int result = sc.insertUser(id, pw, nickname);
			
			if(result > 0) {
				System.out.println("회원가입이 성공적으로 완료되었습니다");
			} else {
				System.out.println("회원가입 중 문제가 발생했습니다");
			}
		} else {
			System.out.println("이미 동일한 아이디가 존재합니다");
		}
	}
	
	public void logIn() {
		System.out.println("*** 로그인 ***");
		System.out.print("아이디 : ");
		String id = scan.nextLine();
		System.out.print("비밀번호 : ");
		String pw = scan.nextLine();
		
		SmUser su = sc.selectByIdAndPw(id, pw);
		
		if(su != null) {
			if("admin".equals(su.getUserId())) {
				// 관리자 메뉴로 이동
				adminMenu();
			} else {
				// 사용자 메뉴로 이동
				System.out.println("'" + su.getUserNickname() + "'님 환영합니다!");
				userMenu();
			}
		} else {
			System.out.println("아이디와 비밃번호를 다시 확인해주세요.");
			return;
		}
	}
	
	public void adminMenu() {
		while(true) {
			System.out.println("*** 관리자 메뉴 ***");
			System.out.println("수행할 작업을 선택하세요 (로그아웃: 99)");
			System.out.println("1. 제품 등록");
			System.out.println("2. 제품 입고");
			System.out.println("3. 판매 현황");
			System.out.print("메뉴 선택 : ");
			int menu = scan.nextInt();
			scan.nextLine();
			
			switch(menu) {
			case 99:
				System.out.println("로그아웃 되었습니다.");
				return;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				System.out.println("올바른 메뉴를 선택해주세요.");
				continue;
			}
		}
	}
	
	public void userMenu() {
		while(true) {
			System.out.println("*** 회원 메뉴 ***");
			System.out.println("원하는 메뉴를 선택해주세요 (로그아웃 : 99)");
			System.out.println("1. 제품 구매");
			System.out.println("2. 개인 정보 수정");
			System.out.println("3. 탈퇴");
			System.out.print("메뉴 선택 : ");
			int menu = scan.nextInt();
			scan.nextLine();
			
			switch(menu) {
			case 99:
				System.out.println("로그아웃 되었습니다.");
				return;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				System.out.println("올바른 메뉴를 선택해주세요.");
				continue;
			}
		}
	}
}
