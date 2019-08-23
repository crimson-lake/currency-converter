package util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import pl.zielinska.numbers.languages.Languages;
import pl.zielinska.numbers.util.NumbersUtil;

public class Translator {
	private final BigDecimal number;

	public Translator(String numb) {
		BigDecimal temp;
		try {
			temp = new BigDecimal(numb).setScale(2, RoundingMode.HALF_UP);
		} catch (NumberFormatException e) {
			temp = BigDecimal.ZERO.setScale(2);
		}
		number = temp;
	}
	
	public Translator(BigDecimal numb) {
		this.number = numb;
	}
	
	public BigDecimal getNumber() {
		return number;
	}
	
	public String toText(String from) {
    	
		String text = "";
		
		if (BigDecimal.valueOf(Long.MAX_VALUE).compareTo(number.abs()) < 0) {
			text = "Out of range, text form unavailable :(";
		}
		else {
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
		}
		return text;
	}
}