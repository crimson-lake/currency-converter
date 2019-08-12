package model.json;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;


public class Rate {
	private Map<String, BigDecimal> rates = new HashMap<>();
	
	@JsonAnySetter
	public void setRates(String name, BigDecimal value) {
		this.rates.put(name, value);
	}
	
	@JsonAnyGetter
	public Map<String, BigDecimal> getRates() {
		return this.rates;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(Map.Entry<String, BigDecimal> entry: rates.entrySet()) {
			result.append(entry.getKey())
				.append(": ")
				.append(entry.getValue())
				.append(" ");
		}
		return result.toString();
	}
	
}
