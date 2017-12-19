package honux.calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록           ");
		System.out.println("| 2. 일정 검색           ");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
	}

	/*
	 * 1. switch case - String 적용 2. Plan class 이용해서 refactoring?
	 */

	/**
	 * 
	 * @param week
	 *            요일명
	 * @return 0~6 (0 = sunday, 6= saturday)
	 */

	public int parseDay(String week) {
		switch (week) {
		case "su":
			return 0;
		case "mo":
			return 1;
		case "tu":
			return 2;
		case "we":
			return 3;
		case "th":
			return 4;
		case "fr":
			return 5;
		case "sa":
			return 6;
		default:
			return 0;

		}
		
	}

	public void runPrompt() throws ParseException {
		printMenu();

		Scanner scanner = new Scanner(System.in);
		Calendar2 cal = new Calendar2();

		while (true) {
			System.out.println("명령(1,2,3,h,q)");
			String cmd = scanner.next();
			if (cmd.equals("1"))
				cmdRegister(scanner, cal);
			else if (cmd.equals("2"))
				cmdSearch(scanner, cal);
			else if (cmd.equals("3"))
				cmdCal(scanner, cal);
			else if (cmd.equals("3"))
				printMenu();
			else if (cmd.equals("q"))
				break;
		}

		System.out.println("Thank you. bye~");
		scanner.close();
	}

	private void cmdCal(Scanner s, Calendar2 c) {
		// parameter...
		int month = 1;
		int year = 2017;

		System.out.println("년도를 입력하세요.");
		System.out.print("YEAR> ");
		year = s.nextInt();

		System.out.println("달을 입력하세요.");
		System.out.print("MONTH> ");
		month = s.nextInt();

		if (month > 12 || month < 1) {
			System.out.println("잘못된 입력입니다.");
			return;
			// 메소드를 종료하려면 return을 입력한다.
		}
		c.printCalendar(year, month);

	}

	// TODO Auto-generated method stub

	private void cmdSearch(Scanner s, Calendar2 c) {

		System.out.println("[일정검색]");
		System.out.println("날짜를 입력해주세요 (yyyy-MM-dd).");
		String date = s.next();
		String plan = "";
		try {
			plan = c.searchPlan(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("일정검색 중 오류가 발생 했습니다.");
		}
		System.out.println(plan);
		// TODO Auto-generated method stub

	}

	private void cmdRegister(Scanner s, Calendar2 c) throws ParseException {
		System.out.println("[새 일정등록]");
		System.out.println("날짜를 입력해주세요 (yyyy-MM-dd).");
		String date = s.next();
		String text = "";
		System.out.println("일정을 입력해주세요. (문장의 끝에 ;을 입력해주세요.");
		while (true) {
			String word = s.next();
			text += word + " ";
			if (word.endsWith(";")) {
				break;
			}
		}
		c.registerPlan(date, text);
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) throws ParseException {
		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}
}
