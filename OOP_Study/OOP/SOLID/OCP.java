package SOLID;

abstract class AnimalType{
	abstract void speak() ; 
}

class CatType extends AnimalType{
	@Override
	void speak() {
		System.out.println("�Ŀ�");
	}
}

class DogType extends AnimalType{
	@Override
	void speak() {
		System.out.println("�۸�");
	}
}

class HelloAnimal{
	void hello(AnimalType animal) {
		animal.speak(); 
	}
}

public class OCP {
	public static void main(String[] args) {
		HelloAnimal hello = new HelloAnimal() ; 
		
//		AnimalType cat = new AnimalType("Cat"); 
		AnimalType cat = new CatType();		
		AnimalType dog = new DogType();		
	
		hello.hello(cat);
		hello.hello(dog); 

		AnimalType sheep = new SheepType() ; 
		hello.hello(sheep);
	}
}

// ��� �߰� --> �� Ŭ������ ������ָ� ���� Ŭ����(HelloAnimal, AnimalType)�� ���� x 
class SheepType extends AnimalType{
	@Override
//	int speak() { LSP ���� 
	void speak() {
//		System.out.println("���� �Դ´�"); // LSP ����
		System.out.println("�޿���");
	}
}