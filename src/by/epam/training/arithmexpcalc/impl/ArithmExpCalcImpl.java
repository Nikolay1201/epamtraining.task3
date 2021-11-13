package by.epam.training.arithmexpcalc.impl;

import by.epam.training.arithmexpcalc.ArithmExpCalc;
import by.epam.training.arithmexpcalc.util.ArithmExpConstants;

public class ArithmExpCalcImpl implements ArithmExpCalc {
	
	private String expStr;
	int index;
	
	public double calculate(String expStr) {
		this.expStr = expStr.replaceAll(" ", "");
		index = 0;
		return evalPlusMinus();
	}
	
	private double evalPlusMinus() {
		double value2;
		char op;
		double value1 = evalMultDiv();
		while (true) {
			if (index >= expStr.length()) {
				return value1;
			}
			op = expStr.charAt(index);
			if (op != ArithmExpConstants.MINUS_SIGN && op != ArithmExpConstants.PLUS_SIGN) {
				return value1;
			}
			index ++;
			value2 = evalMultDiv();
			if (op == ArithmExpConstants.PLUS_SIGN) {
				value1 += value2;
			} else {
				value1 -= value2;
			}
		}
	}
	
	private double evalMultDiv() {
		double value1, value2;
		char op;
		if (expStr.charAt(index) == ArithmExpConstants.OPEN_BRACKET) {
			value1 = evalNextBrackets();
		} else {
			value1 = parseInt();
		}
		while (true) {
			if (index >= expStr.length()) {
				return value1;
			}
			op = expStr.charAt(index);
			if (op != ArithmExpConstants.DIVIDE_SIGN && op != ArithmExpConstants.MULTIPLY_SIGN) {
				return value1;
			}
			index ++;
			if (expStr.charAt(index) == ArithmExpConstants.OPEN_BRACKET) {
				value2 = evalNextBrackets();
			} else {
				value2 = parseInt();
			}
			if (op == ArithmExpConstants.DIVIDE_SIGN) {
				value1 /= value2;
			} else {
				value1 *= value2;
			}
		}
	}
	
	private double evalNextBrackets() {
		ArithmExpCalcImpl subExpCalc = new ArithmExpCalcImpl();
		int startIndex = index + 1;
		int bracketCounter = 1;
		do {
			index ++;
			if (expStr.charAt(index) == ArithmExpConstants.OPEN_BRACKET) {
				bracketCounter ++;
			}
			if (expStr.charAt(index) == ArithmExpConstants.CLOSE_BRACKET) {
				bracketCounter --;
			}
		} while (bracketCounter != 0);
		index ++;
		return subExpCalc.calculate(expStr.substring(startIndex, index));
		
	}
	
	private int parseInt() {
		int number = 0;
		while (expStr.charAt(index) >= '0' && expStr.charAt(index) <= '9') {
			number = number*10 + expStr.charAt(index) - '0';
			index ++;
			if (index == expStr.length()) {
				break;
			}
		}
		return number;
	}
}
