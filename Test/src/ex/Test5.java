package ex;

public class Test5 {

	public static void main(String[] args) {
		// String str = new String("hello");
		String str = "hello";
		System.out.println(str);
		str.toUpperCase(); // 대문자 변경 -> 이때만
//		String stamp = str.toUpperCase(); // 계속 대문자 출력하고 싶으면 이렇게 변수에 저장해서 꺼내면 된다.
		System.out.println(str.toUpperCase());
		System.out.println(str);
		
		// String의 경우 메서드 실행 결과를 저장하지 않는다.
		// 만약 실행결과는 저장하려면 변수에 따로 저장을 해줘야한다.
		
		////////////////////////////////////////////////////////////////
		
		System.out.println("------------------------------");
		StringBuffer sb = new StringBuffer("hello");
		System.out.println(sb);
		// toUpperCase는 String의 메서드 안에만 있어서 여기서는 꺼낼 수 없다.
		sb.reverse();
		System.out.println(sb); // 문자열 거꾸로 출력 => olleh
		// StringBuffer 메서드 실행 결과를 저장O
		System.out.println(sb);  // olleh
	}

}
