package SOLID;

abstract class Transportation{
	void boarding() {
		System.out.println("ž���մϴ�");
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
			System.out.println("�����մϴ�");
		}
		void leftDrive() {
			System.out.println("�������� �����մϴ�");
		}
		void rightDrive() {
			System.out.println("���������� �����մϴ�");
		}
		
		// Ship 
		void steer() {
			System.out.println("�����մϴ�");
		}
		void steerLeft() {
			System.out.println("�������� �����մϴ�");
		}
		void steerRight() {
			System.out.println("���������� �����մϴ�");
		}
		// �� Ŭ�������� �踦 ������ �� �ʿ��� steer, steerLeft, steerRight �� ���� �ʿ����� �������� �� �����ؾ��� 
}

public class ISP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
