package SOLID;

// 상위 모듈
class Kid{
	private Toy toy ;
	// 상위 모듈에서 정의한 추상 타입 (이게 필요해! 라는 설계 자체를 의미) 
	// ==> 여기에 의존 
	public void setToy(Toy toy) {
		this.toy = toy ; 
	}
	public void play() {
		System.out.println(toy.toString());
	}
}
// 추상 클래스 
abstract class Toy{}
// 하위 개별 모듈 
class Robot extends Toy{
	public String toString() {
		return "Robot" ; 
	}
}
class Lego extends Toy{
	public String toString() {
		return "Lego" ; 
	}
}

public class DIP {
	public static void main(String[] args) {
		Toy robot = new Robot() ; 
		Kid k = new Kid(); 
		k.setToy(robot);
		k.play();
		
		// 기능 수정 : 레고를 갖고놀고 싶다 
		Toy lego = new Lego() ; 
		k.setToy(lego);
	}
}
