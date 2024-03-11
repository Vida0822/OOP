package SOLID;

// ���� ���
class Kid{
	private Toy toy ;
	// ���� ��⿡�� ������ �߻� Ÿ�� (�̰� �ʿ���! ��� ���� ��ü�� �ǹ�) 
	// ==> ���⿡ ���� 
	public void setToy(Toy toy) {
		this.toy = toy ; 
	}
	public void play() {
		System.out.println(toy.toString());
	}
}
// �߻� Ŭ���� 
abstract class Toy{}
// ���� ���� ��� 
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
		
		// ��� ���� : ���� ������ �ʹ� 
		Toy lego = new Lego() ; 
		k.setToy(lego);
	}
}
