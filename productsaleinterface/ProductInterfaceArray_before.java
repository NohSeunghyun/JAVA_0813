package productsaleinterface;

interface ProductInter{
	//1.멤버변수(=필드) : 모두 상수
	//객체 생성없이 바로 메모리에 올라와 공유 가능, 값 변경 불가
	int TV=1, COMPUTER=2, AUDIO=3;
	
	//2.메서드 : 콘솔 창에 "구매자가 전자마트에 입장하셨습니다." 출력
	//반환값 : 없음, 매개변수 : 없음, 객체 생성없이 바로 메모리에 올라옴.
	buyerEnter(){
		
	}
	
	//3.메서드 : 자식 클래스에서 반드시 재정의해야 하는 추상 메서드
	//반환값 : 없음, 매개변수 : 없음
	menu();
}

abstract class Product{
	//1.멤버변수(=필드) 
	String makeCountry;//만든 국가로 "대한민국"으로 명시적 초기화 후 값 변경 불가
	int price;//제품 가격
	int bonusPoint;//제품을 구매하면 얻게 되는 보너스 포인트 점수

	//2.매개변수가 있는 생성자 - 가격이 있는 Product(=제품) 생성
	//매개변수(price)의 값으로 자신의 멤버변수(price)를 초기화함.
    //bonusPoint = (int)(price/10.0)
    //반환타입 : 없음, 매개변수 : 있음 (int price)


	//3.메서드 : 자식 클래스에서 반드시 재정의해야 하는 추상 메서드
	//반환값 : 없음, 매개변수 : 없음
	 show();
}

//Product 클래스의 자손 클래스
class Tv extends Product{
	//1.추가한 멤버변수(=필드)
	String makeCompany;//만든 회사로 "삼성"으로 명시적 초기화 후 값 변경 불가

	//2.매개변수가 없는 생성자
    //부모인 Product 클래스의 생성자를 호출할 때 매개값으로 200 전달
	//반환타입 : 없음, 매개변수 : 없음

	//3.메서드 : 상속받은 show() 추상 메서드를 재정의함
	//호출하면 콘솔 창에 ‘TV 제조국, TV 제조사, TV 가격, TV 보너스포인트’를 출력
	//반환값 : 없음, 매개변수 : 없음
	
	//4.메서드 : 상속받은 toString() 메서드를 재정의함
	//호출하면 문자열 "TV"를 리턴
	//반환값 타입 : String, 매개변수 : 없음   
}

//Product 클래스의 자손 클래스
class Computer extends Product{
	//1.추가한 멤버변수(=필드)
	String brand;//제품 이름으로 "LG 그램"으로 명시적 초기화 후 값 변경 불가

	//2.매개변수가 없는 생성자
    //부모인 Product 클래스의 생성자를 호출할 때 매개값으로 100 전달
	//반환타입 : 없음, 매개변수 : 없음

	//3.메서드 : 상속받은 show() 추상 메서드를 재정의함
	//호출하면 콘솔 창에 ‘Computer 제조국, Computer 브랜드, Computer 가격, Computer 보너스포인트’를 출력
	//반환값 : 없음, 매개변수 : 없음
	
	//4.메서드 : 상속받은 toString() 메서드를 재정의함
	//호출하면 문자열 "Computer"를 리턴
	//반환값 타입 : String, 매개변수 : 없음

}

//Product 클래스의 자손 클래스
class Audio extends Product{

	//1.매개변수가 없는 생성자
    //부모인 Product 클래스의 생성자를 호출할 때 매개값으로 50 전달
	//반환타입 : 없음, 매개변수 : 없음

	//2.메서드 : 상속받은 show() 추상 메서드를 재정의함
	//호출하면 콘솔 창에 ‘Audio 제조국, Audio 가격, Audio 보너스포인트’를 출력
	//반환값 : 없음, 매개변수 : 없음
	
	//3.메서드 : 상속받은 toString() 메서드를 재정의함
	//호출하면 문자열 "Audio"를 리턴
	//반환값 타입 : String, 매개변수 : 없음
}

//구매자 클래스
class Buyer{
	//1.멤버변수(=필드)
	int money;//구매자가 가진 돈
	int bonusPoint;//구매자의 보너스 포인트 점수로 0으로 명시적 초기화
	Product[] item;//구매자의 제품 목록으로 배열 사용:최대 10개까지 제품 구매가능함.

	
	//2.매개변수가 있는 생성자 - 돈을 가진 Buyer(=구매자) 생성
	//매개변수(money)의 값으로 자신의 멤버변수(money)를 초기화함
	//반환타입 : 없음, 매개변수 : 있음(int money)
	
	//3.메서드 : 호출하면 콘솔 창에 "(매개값으로 전달받은) 제품에 대한 정보 부탁드립니다."를 출력
	//반환값 : 없음, 매개변수 : 있음(Product p)
	askInfo(){
		
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
	buy(){
		
	}
	
	//5.메서드 : refund() (배열로 구현한 소스에는 없음)
	
	//6.메서드 : 구매자가 구매한 제품 정보를 요약
	//목록(=item)에서 구입한 제품이 있으면 
	//“구입하신 제품의 총금액은 ?만원이고 구입하신 제품은 ?,?입니다."를 콘솔에 출력
	//구입한 제품이 없으면 "구매자는 제품을 구매하지 않았습니다."를 콘솔에 출력
	//반환값 : 없음, 매개변수 : 없음
	summary(){
		
	}

}

//실행용 클래스로 인터페이스인 ProductInter를 구현한 클래스
public class ProductInterfaceArray_before implements ProductInter{
	
	//1.메서드 : menu()추상메서드로 아래내용 출력되도록 재정의
	"********************가전제품목록*****************"
	"1.TV             2.Computer           3.Audio"
	//반환값 : 없음, 매개변수 : 없음
	public static void main(String[] args) {
		//1. 1000을가진 Boyer객체 생성
		//2. Tv객체 생성
		//3. Computer객체 생성
		//4. Audio객체 생성
		
		//5. 반복문 이용 - [콘솔 출력결과]를 참조하여 출력결과가 나오도록 작성
		//키보드로 입력할 때 "정수 또는 stop(대소문자 구분없음)"이외의 a와 같은 다른 문자를
		//입력하면 예외발생 -> 예외 처리하기
		
	} // 메인문
	
} // 클래스문
/*******************************************************************************************************/