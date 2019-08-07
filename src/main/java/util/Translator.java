package util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import pl.zielinska.numbers.languages.Languages;
import pl.zielinska.numbers.util.NumbersUtil;

public class Translator {
	private final BigDecimal number;

	public Translator(String numb) {
		number = new BigDecimal(numb).setScale(2, RoundingMode.HALF_UP);
	}
	
	public BigDecimal getNumber() {
		return number;
	}
	
	public String toText(String from) {
    	
		String text = "";
		
		try {
    		switch (from) {
				case "USD":
					text = NumbersUtil.textValue(Languages.US, number);
					break;
				case "PLN":
					text = NumbersUtil.textValue(Languages.PL, number);
					break;
				case "GBP":
					text = NumbersUtil.textValue(Languages.GB, number);
					break;
				default:
					text = "Select a language";
			}
    	} catch (Exception e) {
    		text = "Error, try again :C";
    	}
		return text;
	}
	
}
