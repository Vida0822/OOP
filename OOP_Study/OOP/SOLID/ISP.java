package SOLID;

abstract class Transportation{
	void boarding() {
		System.out.println("탑승합니다");
	}
	// Car 
	abstract void drive() ; 
	abstract void leftDrive() ; 
	abstract void rightDrive(); 
	
	// Ship 
	abstract void steer();
	abstract void steerLeft() ;
	abstract void steerRight() ;
}

class Car extends Transportation{

		// Car 
		void drive() {
			System.out.println("운전합니다");
		}
		void leftDrive() {
			System.out.println("왼쪽으로 운전합니다");
		}
		void rightDrive() {
			System.out.println("오른쪽으로 운전합니다");
		}
		
		// Ship 
		void steer() {
			System.out.println("조종합니다");
		}
		void steerLeft() {
			System.out.println("왼쪽으로 조종합니다");
		}
		void steerRight() {
			System.out.println("오른쪽으로 조종합니다");
		}
		// 이 클래스에는 배를 조종할 떄 필요한 steer, steerLeft, steerRight 가 전혀 필요하지 않음에도 다 구현해야함 
}

public class ISP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
