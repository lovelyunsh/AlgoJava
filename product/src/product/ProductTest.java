package product;


import java.util.Scanner;

public class ProductTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductDAO Mgr = ProductDAO.makeMgr();
		
		gg:while (true) {
			System.out.println("#########################################");
			System.out.println("1.상품추가 2.모든 상품 보기 3.상품번호로 검색 4.상품명으로 검색 5.TV만 보기 6.냉장고만 보기 7.삭제  8.가격 바꾸기 0.끝내기");
			boolean flag;
			int choice = sc.nextInt();
			int changePrice;
			switch (choice) {
			case 1:
				System.out.println("1. 냉장고 2. TV ");
				int N = sc.nextInt();
				System.out.print("상품 번호 :");
				int no = sc.nextInt();
				System.out.print("상품 이름 :");
				String name = sc.next();
				System.out.print("상품 가격 :");
				int price = sc.nextInt();
				System.out.print("상품 수량 :");
				int stock = sc.nextInt();
				
				if(N==1) {
					System.out.print("용량 : ");
					int volume = sc.nextInt();
					Refrigerator p = new Refrigerator(price, no, name, stock,volume);
					Mgr.add(p);

				}
				else if(N==2) {
					System.out.print("인치 : ");
					int inch = sc.nextInt();
					TV p = new TV(price, no, name, stock,inch);
					Mgr.add(p);
				}
				break;
			case 2:
				flag = true;
				for(Product p : Mgr.searchAll()) {
					flag = false;
					System.out.println(p);
				}
				if(flag)
					System.out.println("출력 할 거 없어여");
				break;
			case 3:
				System.out.print("상품 번호 :");
				int No = sc.nextInt();
				if(Mgr.searchByNo(No) != null)
					System.out.println(Mgr.searchByNo(No));
				else
					System.out.println("출력 할 거 없어여");
				break;
			case 4:
				flag = true;
				System.out.print("상품명 :");
				for(Product p : Mgr.searchByName(sc.next())) {
					flag = false; 
					System.out.println(p);
				}
				if(flag)
					System.out.println("출력 할 거 없어여");
				break;
			case 5:
				flag = true;
				for(Product p : Mgr.searchTV()) {
					flag = false;
					System.out.println(p);
				}
				if(flag)
					System.out.println("출력 할 거 없어여");
				break;
			case 6:
				flag = true;
				for(Product p : Mgr.searchRefrigerator()) {
					flag = false;
					System.out.println(p);
				}
				if(flag)
					System.out.println("출력 할 거 없어여");
				break;
			case 7:
				System.out.print("상품 번호 :");
				No = sc.nextInt();
				if(Mgr.delete(No))
					System.out.println("삭제완료");
				else
					System.out.println("삭제할게 없어요");
				break;
			case 8:
				System.out.print("상품 번호 :");
				No = sc.nextInt();
				System.out.print("바꿀 가격 :");
				changePrice = sc.nextInt();
				if(Mgr.changePrice(No, changePrice))
					System.out.println("성공");
				else
					System.out.println("실패 해당 번호상품이 없어여");
				break;
			case 0:
				break gg;

			default:
				break;
			}
		}
	}

}
