package honux.calendar;

import java.text.ParseException;

import java.util.Date;
import java.util.HashMap;

public class Calendar2 {
	private static final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private HashMap<Date, PlanItem> planMap;

	public Calendar2() {
		planMap = new HashMap<Date, PlanItem>();
	}

	// import 단축키는 ctrl + shift + o
	/**
	 * 
	 * @param date
	 *            ex: "2017-06-20"
	 * @param plan
	 * @throws ParseException
	 */
	public void registerPlan(String strDate, String plan) {
		// java date from string 로 구글링 ㄱㄱ
		PlanItem p = new PlanItem(strDate, plan);
		planMap.put(p.getDate(), p);
	}
	public PlanItem searchPlan(String strDate) {
		Date date = PlanItem.getDatefromString(strDate);
		return planMap.get(date);
	}

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
		// boolean은 일단 false 리턴해주자.
	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		} else {
			return MAX_DAYS[month];
		}
	}

	public void printCalendar(int year, int month) {
		System.out.printf("    <<%d년 %3d월>>\n", year, month);
		// %3d 는 3칸을 차지한다.
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("--------------------");
		// get weekday automatically 검색해보라..

		int weekday = getWeekday(year, month, 1);
		// print black space
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}

		int maxDay = getMaxDaysOfMonth(year, month);
		int count = 7 - weekday;
		int delim = (count < 7) ? count : 0;
		/*
		 * 이거랑 똑같은 거다. if (count <7){ delim = count; }else{ delim = 0; }
		 */
		// print first line
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		// print from second line to last
		count++;
		for (int i = count; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == delim)
				System.out.println();
		}
		System.out.println();
		System.out.println();
	}

	private int getWeekday(int year, int month, int day) {
		// 기준 날짜에 요일을 얻어내자. 예를들어 1970년 1월 1일 (컴퓨터 달력 1970년 1월 1일부터 시작함)
		int syear = 1970;

		final int STANDARD_WEEKDAY = 4;
		// 1970/Jan/1st = Thursday

		int count = 0;

		for (int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}

		// System.out.println(count);
		for (int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}

		count += day - 1;

		int weekday = (count + STANDARD_WEEKDAY) % 7;
		return weekday;
	}

	// simple test code here
	public static void main(String[] args) throws ParseException {
		Calendar2 cal = new Calendar2();
		System.out.println(cal.getWeekday(1970, 1, 1) == 4);
		System.out.println(cal.getWeekday(1971, 1, 1) == 5);
		System.out.println(cal.getWeekday(1972, 1, 1) == 6);
		System.out.println(cal.getWeekday(1973, 1, 1) == 1);
		System.out.println(cal.getWeekday(1974, 1, 1) == 2);

		cal.registerPlan("2017-06-23", "Let's eat beef!");
		System.out.println(cal.searchPlan("2017-06-23").equals("Let's eat beef!"));

	}
}
