package by.epam.training.arithmexpcalc.impl;

import by.epam.training.arithmexpcalc.util.ArithmExpConstants;

public class ArithmExpValidator {
	public static boolean validate(String expStr) {
		if (expStr == null || expStr.length() == 0) {
			return false;
		}
		//brackets checking
		int bracketCounter = 0;
		for (int i = 0; i < expStr.length(); i ++) {
			if (expStr.charAt(i) == ArithmExpConstants.OPEN_BRACKET) {
				bracketCounter ++;
			}
			if (expStr.charAt(i) == ArithmExpConstants.CLOSE_BRACKET) {
				bracketCounter --;
				if (bracketCounter < 0) {
					return false;
				}
			}
		}
		//left symbols checking
		exploop:
		for (int i = 0; i < expStr.length(); i ++) {
			for (int j = 0; j < ArithmExpConstants.ALLOWABLE_CHAR_ARR.length; j ++) {
				if (ArithmExpConstants.ALLOWABLE_CHAR_ARR[j] == expStr.charAt(i)) {
					continue exploop;
				}
			}
			return false;
		}
		return true;
	}
}
