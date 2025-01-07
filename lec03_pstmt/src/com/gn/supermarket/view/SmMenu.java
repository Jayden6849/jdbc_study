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
			System.out.println("원하시는 메뉴를 선택해주세요 (종료:99)");
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
}
