package ex;

interface Will{
	public abstract void Hello();
	public void Hello2(); // abstract 생략 가능
	void Hello3(); // abstract, public 생략 가능
}

class Test implements Will{
	// alt shift s + v
	@Override
	public void Hello() {	}

	@Override
	public void Hello2() {	}

	@Override
	public void Hello3() {	}
	
}

abstract class Shape{
	public abstract void draw(Shape s); 
}

class Cir extends Shape{ // 원	
	public void draw() {
		System.out.println("원 그리기");
	}
	
	public void draw(Shape s) {
		System.out.println(s+" 그리기");
	}
	
}

class Tri extends Shape{ // 삼각형
//	public void paint() {
//		System.out.println("삼각형 그리기");
//	}
	
	public void draw(Shape s) {
		System.out.println(s+" 그리기");
	}
	
}

class Red extends Shape{
//	public void print() {
//		System.out.println("사각형 그리기");
//	}
	
	public void draw(Shape s) {
		System.out.println(s+" 그리기");
	}
	
}

public class Test4 {

}












