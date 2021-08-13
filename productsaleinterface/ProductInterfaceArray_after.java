package productsaleinterface;

import java.util.Scanner;

interface ProductInter {
	//1.멤버변수(=필드) : 모두 상수
	//객체 생성없이 바로 메모리에 올라와 공유 가능, 값 변경 불가
	int TV=1, COMPUTER=2, AUDIO=3;
	
	//2.메서드 : 콘솔 창에 "구매자가 전자마트에 입장하셨습니다." 출력
	//반환값 : 없음, 매개변수 : 없음, 객체 생성없이 바로 메모리에 올라옴.
	static void buyerEnter(){
		System.out.println("구매자가 전자마트에 입장하셨습니다.");
	}
	
	//3.메서드 : 자식 클래스에서 반드시 재정의해야 하는 추상 메서드
	//반환값 : 없음, 매개변수 : 없음
	void menu();
}

abstract class Product {
	//1.멤버변수(=필드) 
	String makeCountry = "대한민국";//만든 국가로 "대한민국"으로 명시적 초기화 후 값 변경 불가
	int price;//제품 가격
	int bonusPoint;//제품을 구매하면 얻게 되는 보너스 포인트 점수

	//2.매개변수가 있는 생성자 - 가격이 있는 Product(=제품) 생성
	//매개변수(price)의 값으로 자신의 멤버변수(price)를 초기화함.
    //bonusPoint = (int)(price/10.0)
    //반환타입 : 없음, 매개변수 : 있음 (int price)
	public Product(int price) {
		super();
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}

	//3.메서드 : 자식 클래스에서 반드시 재정의해야 하는 추상 메서드
	//반환값 : 없음, 매개변수 : 없음
	 abstract void show();
}

//Product 클래스의 자손 클래스
class TV extends Product{
	//1.추가한 멤버변수(=필드)
	String makeCompany = "삼성";//만든 회사로 "삼성"으로 명시적 초기화 후 값 변경 불가

	//2.매개변수가 없는 생성자
    //부모인 Product 클래스의 생성자를 호출할 때 매개값으로 200 전달
	//반환타입 : 없음, 매개변수 : 없음
	public TV() {
		super(200);
	}
	//3.메서드 : 상속받은 show() 추상 메서드를 재정의함
	//호출하면 콘솔 창에 ‘TV 제조국, TV 제조사, TV 가격, TV 보너스포인트’를 출력
	//반환값 : 없음, 매개변수 : 없음
	@Override
	void show() {
		System.out.println("제조국 : " + makeCountry + ", 제조사 : " + makeCompany + ", 가격 : " + price + "만원, 보너스포인트 : " + bonusPoint + "\n");
	}
	//4.메서드 : 상속받은 toString() 메서드를 재정의함
	//호출하면 문자열 "TV"를 리턴
	//반환값 타입 : String, 매개변수 : 없음
	@Override
	public String toString() {
		return "TV";
	}
}

//Product 클래스의 자손 클래스
class Computer extends Product{
	//1.추가한 멤버변수(=필드)
	String brand = "LG 그램";//제품 이름으로 "LG 그램"으로 명시적 초기화 후 값 변경 불가

	//2.매개변수가 없는 생성자
    //부모인 Product 클래스의 생성자를 호출할 때 매개값으로 100 전달
	//반환타입 : 없음, 매개변수 : 없음
	public Computer() {
		super(100);
	}
	//3.메서드 : 상속받은 show() 추상 메서드를 재정의함
	//호출하면 콘솔 창에 ‘Computer 제조국, Computer 브랜드, Computer 가격, Computer 보너스포인트’를 출력
	//반환값 : 없음, 매개변수 : 없음
	@Override
	void show() {
		System.out.println("제조국 : " + makeCountry + ", 브랜드 : " + brand + ", 가격 : " + price + "만원, 보너스포인트 : " + bonusPoint + "\n");
	}
	//4.메서드 : 상속받은 toString() 메서드를 재정의함
	//호출하면 문자열 "Computer"를 리턴
	//반환값 타입 : String, 매개변수 : 없음
	@Override
	public String toString() {
		return "Computer";
	}
}

//Product 클래스의 자손 클래스
class Audio extends Product{

	//1.매개변수가 없는 생성자
    //부모인 Product 클래스의 생성자를 호출할 때 매개값으로 50 전달
	//반환타입 : 없음, 매개변수 : 없음
	public Audio() {
		super(50);
	}
	//2.메서드 : 상속받은 show() 추상 메서드를 재정의함
	//호출하면 콘솔 창에 ‘Audio 제조국, Audio 가격, Audio 보너스포인트’를 출력
	//반환값 : 없음, 매개변수 : 없음
	@Override
	void show() {
		System.out.println("제조국 : " + makeCountry +  ", 가격 : " + price + "만원, 보너스포인트 : " + bonusPoint + "\n");
	}
	//3.메서드 : 상속받은 toString() 메서드를 재정의함
	//호출하면 문자열 "Audio"를 리턴
	//반환값 타입 : String, 매개변수 : 없음
	@Override
	public String toString() {
		return "Audio";
	}
}

//구매자 클래스
class Buyer{
	//1.멤버변수(=필드)
	int money;//구매자가 가진 돈
	int bonusPoint = 0;//구매자의 보너스 포인트 점수로 0으로 명시적 초기화
	Product[] item = new Product[10];//구매자의 제품 목록으로 배열 사용:최대 10개까지 제품 구매가능함.

	
	//2.매개변수가 있는 생성자 - 돈을 가진 Buyer(=구매자) 생성
	//매개변수(money)의 값으로 자신의 멤버변수(money)를 초기화함
	//반환타입 : 없음, 매개변수 : 있음(int money)
	public Buyer(int money) {
		super();
		this.money = money;
	}
	//3.메서드 : 호출하면 콘솔 창에 "(매개값으로 전달받은) 제품에 대한 정보 부탁드립니다."를 출력
	//반환값 : 없음, 매개변수 : 있음(Product p)
	void askInfo(Product p){
		System.out.println(p+"제품에 대한 정보 부탁드립니다.\n\n");
	}
	
	//4.메서드 : 구매자가 선택한 제품을 구매
	/* 구매자가 가진 돈과 제품 가격을 비교하여 구매자의 돈이 더 적으면 "잔액이 부족하여 제품을 살 수 없습니다."
	 * 를 콘솔창에 출력하고 buy메서드 종료  
     * → 구매자의 돈은 제품의 가격만큼 감소 
     * → 구매자의 보너스점수는 제품의 보너스점수만큼 증가
	 * → item 배열에 제품 추가
	 * → “(매개값으로 전달받은 제품)을(를) 구입하셨습니다.”를 콘솔에 출력
	 */
	//반환값 : 없음, 매개변수 : 있음(Product p)
	int i = 0;
	void buy(Product p){
		if (this.money < p.price) {
			System.out.println("잔액이 부족하여 제품을 살 수 없습니다.");
			return;
		}
		this.money -= p.price;
		this.bonusPoint += p.bonusPoint;
		
		item[i++] = p;
		
		System.out.println(p+"제품을 구입하셨습니다.");
	}
	
	//5.메서드 : refund() (배열로 구현한 소스에는 없음)
	
	//6.메서드 : 구매자가 구매한 제품 정보를 요약
	//목록(=item)에서 구입한 제품이 있으면 
	//“구입하신 제품의 총금액은 ?만원이고 구입하신 제품은 ?,?입니다."를 콘솔에 출력
	//구입한 제품이 없으면 "구매자는 제품을 구매하지 않았습니다."를 콘솔에 출력
	//반환값 : 없음, 매개변수 : 없음
	void summary(){
		int sum = 0;
		String itemList = "";
		int cntTv = 0, cntCom = 0, cntAud = 0;
		
		for(i = 0 ; i < item.length ; i++) {
			if (item[i] == null) break;
			
			sum += item[i].price;
			 
			itemList = itemList + ((i==0) ? "" + item[i] : ", "  + item[i]);
			
			switch (item[i].toString().toUpperCase()) {
				case "TV" : {
					cntTv++;
					break;
				}
				case "COMPUTER" : {
					cntCom++;
					break;
				}
				case "AUDIO" : { 
					cntAud++;
					break;
				}
			} // switch문 종료
		} // for문 종료
		if(itemList.length() != 0) {
			System.out.println("==========현황==========");
			System.out.println("총 구매 가격 : " + sum + "만원 입니다!");
			System.out.println("총 구매 제품 목록 : [" + itemList + "] 입니다!");
			
			String itemCnt = "";
			if (cntTv > 0) itemCnt += "TV : " + cntTv + "대, ";
			if (cntCom > 0) itemCnt += "Computer : " + cntCom + "대, ";
			if (cntAud > 0) itemCnt += "Audio : " + cntAud + "대, ";
				
			itemCnt = itemCnt.substring(0, itemCnt.length()-2);
			System.out.println(itemCnt + " 이므로 ");
			System.out.println("총 " + i + " 대 입니다!");
			}
		else System.out.println("구매자는 제품을 구매하지 않았습니다!");
		}
	
	}

//실행용 클래스로 인터페이스인 ProductInter를 구현한 클래스
public class ProductInterfaceArray_after implements ProductInter{
	
	//1.메서드 : menu()추상메서드로 아래내용 출력되도록 재정의
	public void menu() {
		System.out.println("********************가전 제품 목록********************");
		System.out.println("1. TV             2. Computer             3.Audio");
	}
	//반환값 : 없음, 매개변수 : 없음
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1. 1000을가진 Boyer객체 생성
		Buyer A = new Buyer(1000);
		//2. Tv객체 생성
		TV tv = new TV();
		//3. Computer객체 생성
		Computer computer = new Computer();
		//4. Audio객체 생성
		Audio audio = new Audio();
		
		//5. 반복문 이용 - [콘솔 출력결과]를 참조하여 출력결과가 나오도록 작성
		//키보드로 입력할 때 "정수 또는 stop(대소문자 구분없음)"이외의 a와 같은 다른 문자를
		//입력하면 예외발생 -> 예외 처리하기
		String tmp = null;
		
		ProductInterfaceArray_after pi = new ProductInterfaceArray_after();
		while (A.money != 0) {
			pi.menu();
			
			System.out.print("원하시는 가전제품 번호를 입력하세요. 종료는 Stop : ");
			tmp = sc.next();
			
			if (tmp.equalsIgnoreCase("stop")) break;
			int num = 0;
			try {
				num = Integer.parseInt(tmp);
			} catch (NumberFormatException e) {
				// TODO 문자 입력시 재주문
				System.out.println("정수로만 입력해 주세요!");
				System.out.println("입력창으로 돌아갑니다!");
				continue;
			}
			if (!(0 <= num && num <= 3)) {
				System.out.println("정수로만 입력해 주세요!");
				System.out.println("입력창으로 돌아갑니다!");
				continue;
			}
			
			switch (num) {
				case ProductInter.TV : A.askInfo(tv);
					System.out.print("구매 하시겠습니까?(Y,N)");
					tmp = sc.next();
					
					if (tmp.equalsIgnoreCase("y")) {
						if (A.money >= tv.price) A.buy(tv); 
						else System.out.println("잔액이 부족합니다!");
						continue;
					}
					
					if (tmp.equalsIgnoreCase("n")) {
						System.out.println("메인화면으로 돌아갑니다!");
						continue;
					}
					
					if (!(tmp.equalsIgnoreCase("y") && tmp.equalsIgnoreCase("n"))) {
						System.out.println("잘못 입력하셨습니다!"); 
						System.out.println("메인화면으로 돌아갑니다!");
						continue;
					}
					
				case ProductInter.COMPUTER : A.askInfo(computer); 
					System.out.print("구매 하시겠습니까?(Y,N)");
					tmp = sc.next();
					
					if (tmp.equalsIgnoreCase("y")) {
						if (A.money >= computer.price) A.buy(computer); 
						else System.out.println("잔액이 부족합니다!");
						continue;
					}
					
					if (tmp.equalsIgnoreCase("n")) {
						System.out.println("메인화면으로 돌아갑니다!");
						continue;
					}
					
					if (!(tmp.equalsIgnoreCase("y") && tmp.equalsIgnoreCase("n"))) {
						System.out.println("잘못 입력하셨습니다!"); 
						System.out.println("메인화면으로 돌아갑니다!");
						continue;
					}
					
				case ProductInter.AUDIO : A.askInfo(audio);
					System.out.print("구매 하시겠습니까?(Y,N)");
					tmp = sc.next();
					
					if (tmp.equalsIgnoreCase("y")) {
						if (A.money >= audio.price) A.buy(audio); 
						else System.out.println("잔액이 부족합니다!");
						continue;
					}
					
					if (tmp.equalsIgnoreCase("n")) {
						System.out.println("메인화면으로 돌아갑니다!");
						continue;
					}
					
					if (!(tmp.equalsIgnoreCase("y") && tmp.equalsIgnoreCase("n"))) {
						System.out.println("잘못 입력하셨습니다!"); 
						System.out.println("메인화면으로 돌아갑니다!");
						continue;
					}
					
				case 0 : A.summary(); continue;
			} // switch문 종료
		} // while문 종료
		A.summary();
		
	} // 메인문
	
} // 클래스문
/*******************************************************************************************************/