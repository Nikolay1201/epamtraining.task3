package by.epam.training.arithmexpcalc;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArithmExpParser arithmExpParser = ArithmExpParserFactory.getParser();
		while (true) {
			try {
				System.out.println(arithmExpParser.parse(sc.nextLine()));
			} catch (IncorrectExpressionException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
