package design_pattern;

/*
 * 본문
 */
// 전략 인터페이스 
interface IStrategy{
	void execute() ; 
}

// 전략 구현체 (ConcreteStrategies) 
class FirstStrategy implements IStrategy{
	@Override
	public void execute() {
		System.out.println("First Strategy");
	}
}
class SecondStrategy implements IStrategy{
	@Override
	public void execute() {
		System.out.println("Second Strategy");
	}
}

class Context{
	private IStrategy strategy ; 
	
	public Context(IStrategy s) { // 의존성 주입 (생성자) 
		this.strategy = s ; 
	}
	
	public void setStrategy(IStrategy s) { // 의존성 주입(setter) 
		this.strategy = s ; 
	}
	
	public void doSomething(IStrategy s) {
		// 메서드 주입 : 주입과 동시에 기능호출 
		s.execute();  
	}
	
	public void doBasicLogic() {
		
	}
	public void doSomething() {
		this.strategy.execute();
	}	
}

class Client{
	/*
	public void doIt() {
		Context ctx = new Context(new FirstStrategy()); 
		ctx.doSomething();  
	}
	=> 문제 : 생성과 사용의 분리 X (결합도 up) 
		ㄴ 호출부에서 객체 타입, 생성자 같은 인자에 대한 과도한 지식(정보)를 알아야한다. 
		=> Factory 패턴 사용해 간단한 식별정보만 넘겨주면 Factory가 생성하도록 한다 
	*/
	private final Factory factory; 
	
	public Client(Factory f) {
		factory = f;
	}
	
	public void doIt(String req) {
		Context ctx = factory.createContext(req) ; 
		ctx.doSomething(); 
	}
}

class Factory{
	public Context createContext(String req) {
		IStrategy selected = createStrategy(req) ; 
		return new Context(selected);  // 주입 
	}
	
	private IStrategy createStrategy(String req) {
		IStrategy iStrategy; 
		switch (req) {
		case "first":
			iStrategy = new FirstStrategy() ; 
			break;

		default:
			iStrategy = new SecondStrategy() ; 
			break;
		}
		return iStrategy;
	}
}



/*
 * 과제 
 */
interface WeaponBehavior{
	void attack() ; 
}

class KnifeBehavior implements WeaponBehavior{
	@Override
	public void attack() {
		System.out.println("KnifeBehavior");
	}
}
class SwordBehavior implements WeaponBehavior{
	@Override
	public void attack() {
		System.out.println("SwordBehavior");
	}
}
class AxeBehavior implements WeaponBehavior{
	@Override
	public void attack() {
		System.out.println("AxeBehavior");
	}
}
class BowAndArrowBehavior implements WeaponBehavior{
	@Override
	public void attack() {
		System.out.println("BowAndArrowBehavior");
	}
}

abstract class Charactor{
	WeaponBehavior weapon ; 
	
	public void setWeapon(WeaponBehavior weapon) {
		this.weapon = weapon ; 
	}
	
	public abstract void fight() ; 
}

class King extends Charactor{
	@Override
	public void fight() {
		System.out.println("I'm king");
		weapon.attack();
	}
}
class Knight extends Charactor{
	@Override
	public void fight() {
		System.out.println("I'm Knight");
		weapon.attack();
	}
}
class Queen extends Charactor{
	@Override
	public void fight() {
		System.out.println("I'm Queen");
		weapon.attack();
	}
}


