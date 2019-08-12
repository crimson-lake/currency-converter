package model.json;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RatesTable {
	@JsonProperty("rates")
	private final Rate rates;
	
	@JsonProperty("base")
	private final String base;
	
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private final LocalDate date;
	
	
	public RatesTable() {
		this.base = null;
		this.date = null;
		this.rates = null;
	}
	
	public RatesTable(String base, LocalDate date, Rate rates) {
		this.base = base;
		this.date = date;
		this.rates = rates;
	}
	
	public Rate getRates() {
		return rates;
	}
	
	public BigDecimal getRates(String currency) {
		return rates.getRates().get(currency);
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public String getBase() {
		return base;
	}
}
