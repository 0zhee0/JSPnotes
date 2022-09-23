package ex;

class SuperClass1 {
	public void pprn() {
		System.out.println(" P : SuperClass1 ");
	}
}

class SubClass1 extends SuperClass1{
	public void cprn() {
		System.out.println(" C : SubClass1 ");
	}
}

public class Test3 {

	public static void main(String[] args) {
		
		// 기본형타입(boolean(1) char(2) byte(1) short(2) int(4) long(8) float(4) double(8))
		// 형변환	1) 명시적 형변환 (자동) : 메모리 크기 작은 곳 -> 큰곳 갈 때 발생 
		//				=> 컴파일러가 자동으로 형변환 실행(에러 없음)
		//			2) 묵시적 형변환 (강제) : 메모리 크기 큰곳 ->  작은곳 갈 때 발생
		//				=> 컴파일러가 자동으로 형변환 X (에러 생김)
		//				=> 강제 형변환 (개발자가 에러를 확인하고 책임 진다는 의미)
		
		int a = 100;
		long a1;
		
		a1 = a;
		
		int b;
		long b1 = 1000L;
		b = (int)b1;
		
		// * 반드시 '상속' 관계에서만 가능
		
		// 참조형타입 (기본형 타입 8개 제외한 나머지)
		// 형변환    
		//	 1) 업캐스팅 (자동 형변환) : 
		//			슈퍼클래스의 레퍼런스가 서브클래스의 인스턴스를 가리키는 것
		//			부모타입으로 형변환
		//			서브클래스의 레퍼런스 값이 슈퍼클래스의 레퍼런스 변수에 저장
		//	 2) 다운캐스팅 (강제 형변환) : 
		//			서브클래스의 레퍼런스가 슈퍼클래스의 인스턴스를 가리키는 것
		//			자식타입으로 형변환
		//			슈퍼클래스의 레퍼런스 값이 서브클래스의 레퍼런스 변수에 저장			
		
		// 슈퍼클래스의 레퍼런스가 서브클래스의 인스턴스를 가리키는 것
//		 SuperClass1 s = new SubClass1();
//		SuperClass1 s = new SubClass1();
//		SubClass1 sc1 = new SubClass1();
//		
//		s = sc1;
		
		 SuperClass1 s1 = new SuperClass1();
		 s1.pprn();
		 
		 SubClass1 sc1 = new SubClass1();
		 sc1.cprn();
		 sc1.pprn();
		
		 // 업캐스팅
		 SuperClass1 s = new SubClass1();
		 s.pprn();
//		 s.cprn(); (x)
		 // => 상속받은 부분만 사용 가능하다.
		 
		 // * 업캐스팅 : 슈퍼클래스 타입으로 형변환
		 //			 	 참조 가능한 영역의 축소 (상속 받은 부분만 사용 가능)
		 //				 컴파일러가 자동으로 형변환(에러가 없음)
		 //				 상속받은 부분만 사용하고, 나머지는 안 쓴다.(포기)
		 
		 // * 다운캐스팅
		 //	  서브클래스의 레퍼런스가 슈퍼클래스의 인스턴스를 가리키는 것
//		 	SubClass1 sc2;
//		 	SuperClass1 s2 = new SuperClass1();
//		 	sc2 = s2;
		 	
//		 	SubClass1 sc2 = new SuperClass1(); // 컴파일에러
//		 	SubClass1 sc2 = (SubClass1) new SuperClass1(); // 다운캐스팅 (강제형변환)
//			sc2.cprn();
//		 	sc2.pprn();
		 
		 // => 실행 시 (runtime 에러) 없는 영역에 참조가능성이 있기때문에 예외 발생
		 
		 System.out.println("--------------------------------");
		 // 안전한 다운캐스팅 :업캐스팅 -> 다운캐스팅
		 SuperClass1 s3 = new SubClass1();
		 
		 SubClass1 sc3 = (SubClass1)s3;
		 
		 sc3.pprn();
		 sc3.cprn();
		 
		 // * 다운캐스팅
		 //	  서브클래스 형태로 형변환
		 //	  참조가능한 영역이 확대
		 //	  컴파일러가 자동으로 형변환 X (에러 발생)
		 //	  -> 존재하지 않는 영역 참조 가능성 있음(컴파일 에러)
		 //	  => 개발자가 강제 형변환을 통해 해결한다.
		 //   업캐스팅된 객체를 다운캐스팅 해야함.(안전한 다운캐스팅)
		 
		 // * 참조형 형변환 실행 시
		 //	  1) 컴파일 단계, 2) 실행단계  2번 에러체크
		 
//		 session.seAttribute("이름", "값");
//		 String name = (String) session.getAttribute("이름"); 
		
		// 형변환
		
	}

}
