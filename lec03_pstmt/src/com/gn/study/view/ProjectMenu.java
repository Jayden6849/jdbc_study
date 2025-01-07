package com.gn.study.view;

import java.util.Scanner;

import com.gn.study.controller.ProjectController;

public class ProjectMenu {
	private Scanner sc = new Scanner(System.in);	// 입력
	private ProjectController pc = new ProjectController();	// view <- controller
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== (주)ABC 프로젝트 관리 시스템 ===");
			System.out.println("1. 프로젝트 추가");
			System.out.println("2. 프로젝트 전체 조회");
			System.out.println("3. 프로젝트 이름 검색");
			System.out.println("4. 프로젝트 담당자 검색");
			System.out.println("5. 프로젝트 정보 수정");
			System.out.println("6. 프로젝트 삭제");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1:
					createProject();
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 0:
					System.out.println("이용해주셔서 감사합니다.");
					return;
				default:
					System.out.println("메뉴를 잘못 입력하셨습니다.");
			}
		}
	}
	
	public void createProject() {	// 프로젝트를 추가하는 메소드
		System.out.println("*** 프로젝트 추가 ***");
		System.out.println("'프로젝트명'과 '담당자이름'을 입력하세요. ");
		System.out.print("프로젝트명 : ");
		String projectName = sc.nextLine();
		System.out.print("담당자이름 : ");
		String managerName = sc.nextLine();
		
		int result = pc.insertProject(projectName, managerName);
		
		if(result > 0) {
			System.out.println("프로젝트 추가가 정상적으로 완료되었습니다.");
		} else {
			System.out.println("프로젝트 추가 중 오류가 발생하였습니다.");
		}
	}
}
