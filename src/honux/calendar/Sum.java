package honux.calendar;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		// 입력 ; 키보드로 두 수의 입력을 받는다.
		int a, b;
		System.out.println("두 숫자를 입력하세요");
		Scanner scanner = new Scanner(System.in);
		String s1, s2;
		s1 = scanner.next();
		// next();는 String에만 넣을 수 있다.
		s2 = scanner.next();

		System.out.println(s1 + "," + s2);
		a = Integer.parseInt(s1);
		b = Integer.parseInt(s2);
		//int c = a + b ;
		//System.out.println("두 수의 합은"+ (a+ b)+ "입니다.");
System.out.printf("%d 와 %d의 합은 %d 입니다.",a,b, a+b);
		// 정수형 클래스로 바꾸는게 Integer
		// 출력 : 화면에 두 수의 합을 출력한다.
scanner.close();

	}
}
