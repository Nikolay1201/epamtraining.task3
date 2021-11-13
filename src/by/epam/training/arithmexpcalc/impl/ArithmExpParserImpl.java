package by.epam.training.arithmexpcalc.impl;

import by.epam.training.arithmexpcalc.ArithmExpCalc;
import by.epam.training.arithmexpcalc.ArithmExpParser;
import by.epam.training.arithmexpcalc.IncorrectExpressionException;

public class ArithmExpParserImpl implements ArithmExpParser {
	ArithmExpCalc calculator = new ArithmExpCalcImpl();
	
	public double parse(String expStr) {
		if (!ArithmExpValidator.validate(expStr)) {
			throw new IncorrectExpressionException("Incorrect expression");
		}
		try {
			return calculator.calculate(expStr);
		} catch (StringIndexOutOfBoundsException e) {
			throw new IncorrectExpressionException("Incorrect expression", e);
		}
	}
}
