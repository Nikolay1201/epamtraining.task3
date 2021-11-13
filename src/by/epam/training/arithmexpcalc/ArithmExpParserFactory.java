package by.epam.training.arithmexpcalc;

import by.epam.training.arithmexpcalc.impl.ArithmExpParserImpl;

public class ArithmExpParserFactory {
	private static ArithmExpParser instance = new ArithmExpParserImpl();
	
	private ArithmExpParserFactory() {};
	
	public static ArithmExpParser getParser() {
		return instance;
	}
}
