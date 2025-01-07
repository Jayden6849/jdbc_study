package com.gn.supermarket.view;

import java.util.Scanner;

import com.gn.supermarket.controller.SmController;

public class SmMenu {
	private Scanner scan = new Scanner(System.in);
	private SmController sc = new SmController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("*** 환영합니다. 우리동네 슈퍼마켓입니다 ***");
			System.out.println("--- 원하시는 메뉴를 선택해주세요 (종료:99) ---");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.print("메뉴 선택 : ");
			int menu = scan.nextInt();
			scan.nextLine();
			
			switch(menu) {
			case 99:
				System.out.print("프로그램이 종료");
				scan.close();
				return;
			case 1:
				break;
			case 2:
				break;
			default:
				System.out.println("올바른 메뉴를 선택해주세요");
				continue;
			}
			
		}
	}
}
