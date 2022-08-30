
public class Test1 {

	public static void main(String[] args) {
		
		// 변수 : 데이터를 저장하는 메모리 공간
		
		// 배열 : 데이터를 저장하는 메모리 공간
		// 배열을 저장할 때는 항상 0번 인덱스(index) 시작
		
		// int[] 이름 = new int[크기]; // 이 순서를 권장
		// int 이름[] = new int[크기]; // 씨언어 방식이라 권장x
		
		int[] numbers = new int[5];
		
		numbers[0] = 10;
		numbers[1] = 20;
		numbers[2] = 30;
		numbers[3] = 40;
		numbers[4] = 50;
		
		//    [10][20][30][40][50]
		//	   0   1   2   3   4
		// => int타입의 데이터를 저장하는 공간(변수) 5개 생성
		// => 연속된 공간에 생성됨(배열과 변수의 차이점)
		// => 배열의 이름을 사용하여 접근  numbers[위치]
		// => 배열의 값을 '요소', 배열의 요소는 이름을 사용하여 변수처럼 접근

		System.out.println("3번째 요소의 값 : " + numbers[2]);
		System.out.println("배열의 길이 : " + numbers.length);
		
//			    [10][20][30][40][50]
		for ( int i=0;i<numbers.length;i++) {
			System.out.print("[" +numbers[i]+"]");
		}
		
		
	}

}
