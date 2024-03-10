package SOLID;

import java.util.ArrayList;
import java.util.List;

abstract class Animal{}

interface Speakable{
	void speak() ; 
}
class Cat extends Animal implements Speakable{
	public void speak() {
		System.out.println("�Ŀ�");
	}
}
class Dog extends Animal implements Speakable{
	public void speak() {
		System.out.println("�۸�");
	}
}
class Fish extends Animal{}

public class LSP {
	public static void main(String[] args) {
		List<Animal> list = new ArrayList<>(); 
		list.add(new Cat()); 
		list.add(new Dog()); 
		list.add(new Fish()); 
		
		for(Animal a : list) {
	//		a.speak(); // java.lang.Exception: ������ ���� �� ����
		}

	}
}
