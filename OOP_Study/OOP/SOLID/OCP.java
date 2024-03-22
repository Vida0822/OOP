package SOLID;

abstract class AnimalType{
	abstract void speak() ; 
}

class CatType extends AnimalType{
	@Override
	void speak() {
		System.out.println("냐옹");
	}
}

class DogType extends AnimalType{
	@Override
	void speak() {
		System.out.println("멍멍");
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

// 기능 추가 --> 이 클래스만 만들어주면 기존 클래스(HelloAnimal, AnimalType)에 영향 x 
class SheepType extends AnimalType{
	@Override
//	int speak() { LSP 위반 
	void speak() {
//		System.out.println("밥을 먹는다"); // LSP 위반
		System.out.println("메에에");
	}
}