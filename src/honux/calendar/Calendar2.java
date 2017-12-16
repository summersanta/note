package honux.calendar;

import java.util.Scanner;

public class Calendar2 {
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDaysOfMonth(int month) {

		return MAX_DAYS[month - 1];
	}

	/*
	 * 월을 입력하면 해당월의 달력을 출력한다. 
	 * 달력은 모양은 1단계에서 작성한 모양으로 만든다. 
	 * 1일은 일요일로 정해도 무방하다. 
	 * -1을 입력받기 전까지 반복 입력받는다. 
	 * 프롬프트를 출력한다.
	 */
	public void printCalendar(int year, int month) {
		System.out.printf("    <<%4d년%3d월>>\n",year, month);
		//%3d 는 3칸을 차지한다.
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("--------------------");
		int maxDay = getMaxDaysOfMonth(month);
		for(int i =1; i<=maxDay; i++) {
			System.out.printf("%3d",i);
		if(i % 7 == 0)
			System.out.println();
			//7번 돌때마다 줄바꾸기 위해서, i를 7로 나누면..
		}
		System.out.println();
		//Ctrl + space 하면 자동완성
//		System.out.println("1  2  3  4  5  6  7");
//		System.out.println("8  9  10 11 12 13 14");
//		System.out.println("15 16 17 18 19 20 21");
//		System.out.println("22 23 24 25 26 27 28");
		//println은 줄바꿈이 포함되어있는데, printf는 줄바꿈이 포함안되어 있따.
	}

	
}
