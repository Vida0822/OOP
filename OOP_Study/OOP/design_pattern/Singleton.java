package design_pattern;

public class Singleton {

	// 기본 생성자를 막아놓는다 
	private Singleton() {} ; 
	
	private static class SingletonHolder{
		private static final Singleton SINGLETON_OBJECT = new Singleton() ; 
	}

	// 싱글톤 객체 반환 메서드 
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
