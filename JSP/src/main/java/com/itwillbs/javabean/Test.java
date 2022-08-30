package com.itwillbs.javabean;

public class Test {

	public static void main(String[] args) {
		
		// 변수 선언
		int a;		
//		System.out.println(a);		
		// 변수선언
		int b = 0;
		System.out.println(b);
		
		// JavaBean2 객체 정보 확인
		JavaBean2 jb2 = new JavaBean2();
		
		System.out.println(jb2.getIdx());
		System.out.println(jb2.getName());
		

	}

}
