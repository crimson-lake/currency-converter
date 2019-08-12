package util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
	
	private Calculator() {};
	
	public static BigDecimal convertCurrency(BigDecimal base, BigDecimal rate) {
		return base.multiply(rate).setScale(2, RoundingMode.HALF_UP);
	}

}
