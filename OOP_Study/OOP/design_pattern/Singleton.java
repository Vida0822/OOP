package design_pattern;

public class Singleton {

	// �⺻ �����ڸ� ���Ƴ��´� 
	private Singleton() {} ; 
	
	private static class SingletonHolder{
		private static final Singleton SINGLETON_OBJECT = new Singleton() ; 
	}

	// �̱��� ��ü ��ȯ �޼��� 
	public static synchronized Singleton getInstance() {
		return SingletonHolder.SINGLETON_OBJECT ; 
	}
}

class Cient{
	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			Singleton instance1 = Singleton.getInstance() ; 			
		}) ; 
		Thread thread2 = new Thread(() -> {
			Singleton instance2 = Singleton.getInstance() ; 			
		}) ; 
		Thread thread3 = new Thread(() -> {			
			Singleton instance3 = Singleton.getInstance() ; 
		}) ; 
		
		thread1.start();// true 
		thread2.start();// true 
		thread3.start();// true 
	}
}
