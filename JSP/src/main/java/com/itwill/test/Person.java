package com.itwill.test;

public class Person {
	// 이름, 나이, 휴대폰
	private String name;
	private int age;
	private Phone p;
	
	// alt shift s + r : set()/get()
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Phone getP() {
		return p;
	}
	public void setP(Phone p) {
		this.p = p;
	}
	
}



