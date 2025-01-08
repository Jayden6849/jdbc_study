package com.gn.study.view;

import java.util.List;
import java.util.Scanner;

import com.gn.study.controller.Controller;
import com.gn.study.model.vo.Car;

// 사용자가 보게될 화면을 구성
// 사용자에게 정보를 입력받아서 결과화면을 출력
public class Menu {
	private Scanner sc = new Scanner(System.in);
	private Controller controller = new Controller();
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== 자동차 정보 관리 시스템 ===");
			System.out.println("1. 추가");
			System.out.println("2. 목록 조회");
			System.out.println("3. 단일 조회");
			System.out.println("4. 수정");
			System.out.println("5. 삭제");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 0:
				System.out.println("프로그램이 종료되었습니다");
				sc.close();
				return;
			case 1:
				insertCarOne();
				break;
			case 2:
				selectCarAll();
				break;
			case 3:
				selectCarByModelName();
				break;
			case 4:
				updateCarInfo();
				break;
			case 5:
				deleteCarOne();
				break;
			default:
				System.out.println("올바른 값을 입력해주세요");
				continue;
			}
		}
	}
	
	public void insertCarOne() {
		System.out.println("*** 추가 ***");
		System.out.println("모델명, 가격, 출시일을 입력하세요.");
		System.out.println("다만, 출시일은 반드시 OOOO-OO-OO 형식으로 입력해주세요.");
		
		System.out.print("모델명 : ");
		String modelName = sc.nextLine();
		
		System.out.print("가격 : ");
		int modelPrice = sc.nextInt();
		sc.nextLine();
		
		String date = null;
		System.out.print("출시일 정보를 입력하시겠습니까?(Y/N) : ");
		String dateFlag = sc.nextLine();
		if("Y".equalsIgnoreCase(dateFlag)) {
			System.out.print("출시일 : ");
			date = sc.nextLine();
		}
		
		int result = controller.insertCarOne(modelName, modelPrice, date);
		
		dmlResultPrint(result, "추가");
	}
	
	public void dmlResultPrint(int result, String menuName) {
		if(result > 0) {
			System.out.println(menuName + "이(가) 정상적으로 완료되었습니다.");
		} else {
			System.out.println(menuName + " 중 오류가 발생하였습니다.");
		}
	}
	
	public void selectCarAll() {
		System.out.println("*** 목록 조회 ***");
		List<Car> list = controller.selectCarAll();
		printList(list);
	}
	
	public void printList(List<Car> list) {
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		} else {
			for(Car c : list) {
				System.out.println(c);
			}
		}
	}
	
	public void selectCarByModelName() {
		while(true) {
			System.out.println("*** 단일 조회 ***");
			System.out.println("검색 기준으로 삼고 싶은 항목을 선택하세요");
			System.out.println("1. 번호 / 2. 모델명 / 3. 가격 / 4. 출시일 / 0.종료");
			System.out.print("선택 : ");
			int flag = sc.nextInt();
			sc.nextLine();
			
			List<Car> list = null;
			Car car = null;
			
			switch(flag) {
			case 0:
				return;
			case 1:
				System.out.println("번호 기준으로 검색합니다.");
				System.out.print("번호 : ");
				int modelNo = sc.nextInt();
				sc.nextLine();
				
				car = controller.selectCarByModelNo(modelNo);
				
				printVo(car);
				break;
			case 2:
				System.out.println("모델명 기준으로 검색합니다.");
				System.out.print("모델명 : ");
				String modelName = sc.nextLine();
				
				car = controller.selectCarByModelName(modelName);
				
				printVo(car);
				break;
			case 3:
				System.out.println("가격 기준으로 검색합니다.");
				System.out.print("가격 : ");
				int modelPrice = sc.nextInt();
				sc.nextLine();
				
				list = controller.selectCarByModelPrice(modelPrice);
				
				printList(list);
				break;
			case 4:
				System.out.println("출시일 기준으로 검색합니다.");
				System.out.println("단, 출시일을 ");
				System.out.println("다만, 출시일은 반드시 OOOO-OO-OO 형식으로 입력해주세요.");
				System.out.print("출시일 : ");
				String modelDate = sc.nextLine();
				
				list = controller.selectCarByModelDate(modelDate);
				
				printList(list);
				break;
			default:
				System.out.println("올바른 기준을 선택해주세요.");
				continue;
			}
		}
	}
	
	public void printVo(Car car) {
		if(car != null) {
			System.out.println(car);
		} else {
			System.out.println("조회된 결과가 없습니다.");
		}
	}
	
	public void updateCarInfo() {
		System.out.println("=== 수정 ===");
		List<Car> list = controller.selectCarAll();
		printList(list);
		
		String flag = "";
		System.out.println("어떤 모델을 수정하시겠습니까?");
		System.out.print("번호 : ");
		int carNo = sc.nextInt();
		sc.nextLine();
		
		String carModel = null;
		int carPrice = -1;
		String carDate = null;
		
		System.out.print("모델명을 수정하시겠습니까?(Y/N) : ");
		flag = sc.nextLine();
		if("Y".equalsIgnoreCase(flag)) {
			System.out.print("모델명 : ");
			carModel = sc.nextLine();
			
			
		}
		
		System.out.print("가격을 수정하시겠습니까?(Y/N) : ");
		flag = sc.nextLine();
		if("Y".equalsIgnoreCase(flag)) {
			System.out.print("가격 : ");
			carPrice = sc.nextInt();
			sc.nextLine();
		}
		
		System.out.print("출시일을 수정하시겠습니까?(Y/N) : ");
		flag = sc.nextLine();
		if("Y".equalsIgnoreCase(flag)) {
			System.out.println("다만, 출시일은 반드시 OOOO-OO-OO 형식으로 입력해주세요.");
			System.out.print("출시일 : ");
			carDate = sc.nextLine();
		}
		
		int result = controller.updateCarInfo(carNo, carModel, carPrice, carDate);
		
		dmlResultPrint(result, "수정");
	}
	
	public void deleteCarOne() {
		System.out.println("=== 삭제 ===");
		System.out.println("삭제할 차량의 번호를 입력해주세요.");
		List<Car> list = controller.selectCarAll();
		printList(list);
		System.out.print("삭제할 차량의 번호 : ");
		int carNo = sc.nextInt();
		sc.nextLine();
		
		int result = controller.deleteCarOne(carNo);
		
		dmlResultPrint(result, "삭제");
	}
}
