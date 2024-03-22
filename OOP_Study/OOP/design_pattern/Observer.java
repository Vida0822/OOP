package design_pattern;

import java.util.ArrayList;

interface Publisher{
	public void add(Observer observer) ; 
	public void delete(Observer observer); 
	public void notifyObservers() ; 
}


interface Observer {
	public void update(String title, String news) ; // msg
}

class NewsOffice implements Publisher{
	private ArrayList<Observer> observers ; 
	private String todayNewstitle; 
	private String todayNewsContent ; 

	public NewsOffice() {
		observers = new ArrayList<>() ; 
	}
	
	@Override
	public void add(Observer observer) {
		observers.add(observer); 
	}

	@Override
	public void delete(Observer observer) {
		observers.remove(observer);  
	}

	@Override
	public void notifyObservers() {
		for(Observer observer: observers)
			observer.update(todayNewstitle, todayNewsContent);
	}
	
	public void setNewsInfo(String title, String news) {
		this.todayNewstitle = title; 
		this.todayNewsContent = news; 
		notifyObservers() ; 
	}
}

class AnnualSubscriber implements Observer{
	private String todaysNews ; 
	private Publisher publisher ; 
	
	public AnnualSubscriber(Publisher publisher) {
		this.publisher = publisher ; 
		publisher.add(this);
	}

	@Override
	public void update(String title, String news) {
		this.todaysNews = title + " \n------------\n"+news ; 
		display() ; 
	}
	private void display() {
		System.out.println("\n\n오늘의 뉴스 \n===========================\n\n"+todaysNews);
	}
}

class EventSubscriber implements Observer{
	private String todaysNews ; 
	private Publisher publisher ;
	
	public EventSubscriber(Publisher publisher) {
		this.publisher = publisher; 
		publisher.add(this);
	}
	
	@Override
	public void update(String title, String news) {
		this.todaysNews = title + " \n------------\n"+news ; 
		display() ; 
	}
	
	private void display() {
		System.out.println("==이벤트 유저==");
		System.out.println("\n\n오늘의 뉴스 \n===========================\n\n"+todaysNews);
	}
}

class Main{ 
	public static void main(String[] args) {
		
		// 이 작업을 스프링에선 스프링 컨테이너가 대신해줌 
		NewsOffice newsOffice = new NewsOffice() ; 
		AnnualSubscriber annualSubscriber = new AnnualSubscriber(newsOffice); 
		EventSubscriber eventSubscriber = new EventSubscriber(newsOffice); 
		
		newsOffice.setNewsInfo("3/21 오늘한파", "전국 영하 18도 입니다"); // 뉴스 발행 
		newsOffice.setNewsInfo("3/22 벛꼭 축제", "다같이 꽃보러가자!"); // 뉴스 발행 
	}
}

