package honux.calendar;

import java.util.Scanner;
// Ctrl + shift + n

public class summ {

	public static void main(String[] args) {
		//입력 : 키보드로 두수의 입력을 받는다.
		//출력 : 화면에 두수의 합을 출력한다.
		int a,b;
		// 두수를 입력해야 하니까 int a, b 를 입력한다.
		System.out.println("두 수를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		//scanner는 입력을 쉽게하기 위해 도와주는건데 키보드에서 입력하는건 System.in 모르더라도 넘어가자
		String s1, s2;
		s1 = scanner.next();
		s2 = scanner.next();
		//키보드에 입력받은걸 string (문자열) 변수에 입력한다.
		System.out.println(s1 + ","+ s2);
		a = Integer.parseInt(s1);
		b = Integer.parseInt(s2);
		System.out.println(a+","+b);
		int c = a + b;
		System.out.println("두수의 합은" +c + "입니다.");
		System.out.println(a+b);
		System.out.println("두수의 합은" + (a+b)+"이다.");
		System.out.printf("두수의 합은 %d 입니다.", a+b);
		System.out.printf("%d 와 %d의 합은 %d 입니다.",a,b, a + b);
		scanner.close();
		//문을 열고나면 반드시 습관적으로 문을 닫자. 	
		//warning 이 있는 코드는 깔끔한 코드가 아니다.
		}

}
