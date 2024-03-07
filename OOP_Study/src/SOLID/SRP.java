package SOLID;

/**
 * @author SHIN HEEMIN
 
  SRP 
  : Single Responsibility Principle

 */
class Employee{ 
	String name ; 
	String position ; 
	
	Employee(String name, String position){
		this.name = name;  
		this.position = position; 
	}
	
	void calculatePay() { this.calculateExtraHour();	}
	void reportHours() { this.calculateExtraHour(); }
	void saveDatabase() { /* */ } 
	void calculateExtraHour() {/* */}	
}

class Employee_SRT{
	
	class PayCalculator{	
		void calculateExtraHour(){ /*A*/ }
		void calculatePay() {this.calculateExtraHour();} 
	}
	class HourReporter{
		void calculateExtraHour() { /*B*/}
		void reportHours() {this.calculateExtraHour(); } 
	}
	class EmployeeSaver{
		void saveDataBase() {}  
	}
	
	class EmployeeFacade {
		private String name ; 
		private String position ; 
		
		EmployeeFacade(String name, String position){
			this.name = name ; 
			this.position = position; 
		}
		
		void caculatePay() {
			new PayCalculator().calculatePay(); 
		}
		
		void reportHours() {
			new HourReporter().reportHours(); 
		}
		
		void saveDataBase() {
			new EmployeeSaver().saveDataBase();
		}
	}
	
}