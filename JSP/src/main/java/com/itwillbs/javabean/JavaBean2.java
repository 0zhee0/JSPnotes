package com.itwillbs.javabean;

public class JavaBean2 {
	// itwill_member 테이블의 정보를 한번에 저장 객체
	 private int idx;
	 private String name;
	 private String gender;
	 private int age;
	 private String jumin;
	 
	 public JavaBean2() {
		// 생성자 : 클래스를 초기화 하는 메서드
		// 리턴타입이 없는 메서드
		// 메서드 이름이 클래스 이름과 동일	
		// idx = 0; => 기본값으로 변수를 초기화
		System.out.println("이코드는 객체 생성 시 실행됩니다.");
		System.out.println("객체의 변수정보를 기본값으로 초기화합니다.");
	}
	 
	// set/get 메서드 생성
	 // alt shift s + r 
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	 	 
}
