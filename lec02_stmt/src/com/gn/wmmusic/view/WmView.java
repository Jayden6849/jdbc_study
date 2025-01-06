package com.gn.wmmusic.view;

import java.util.Scanner;

import com.gn.wmmusic.controller.WmController;

public class WmView {
	private Scanner sc = new Scanner(System.in);
	private WmController wc = new WmController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("====== 초기메뉴 ======");
			System.out.println("원하시는 메뉴를 선택해주세요 (종료 : 99)");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch(menu) {
			case 99:
				System.out.print("프로그램이 종료되었습니다");
				sc.close();
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
		System.out.println("------ 회원가입 ------");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		int result = wc.signUp(id, pw, name);
		
		if(result > 0) {
			System.out.println("회원가입이 완료되었습니다");
		} else {
			System.out.println("동일한 아이디가 존재합니다");
		}
	}
	public void logIn() {
		
	}
}
