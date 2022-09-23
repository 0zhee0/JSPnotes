package ex;

class Alpha{
	public void foo() {System.out.println("Afoo ");}
}

public class Beta extends Alpha{
	public void foo() {System.out.println("Bfoo ");}
	public static void main(String[] args) {
		// * 형변환 여부와 상관없이 항상 오버라이딩괸 메서드만 호출됨
		
		Alpha a = new Beta();
//		Alpha a = new New String();
		Beta b = (Beta) a;
		a.foo();
		b.foo();
		

	}

}
