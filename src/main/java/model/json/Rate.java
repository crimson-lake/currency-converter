package model.json;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rate {
	private final String currency;
	private final String code;
	private final BigDecimal mid;
	
	public Rate(String currency, String code, BigDecimal mid) {
		this.currency = currency;
		this.code = code;
		this.mid = mid;
	}
	
	public Rate() {
		currency = null;
		code = null;
		mid = null;
	}

	public String getCurrency() {
		return currency;
	}

	public String getCode() {
		return code;
	}

	public BigDecimal getMid() {
		return mid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((mid == null) ? 0 : mid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Rate other = (Rate) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		
		if (mid == null) {
			if (other.mid != null)
				return false;
		} else if (!mid.equals(other.mid))
			return false;
		
		return true;
	}
	
	@Override
	public String toString() {
		return code + " " + currency + " " + mid;
	}

	public BigDecimal fromPLN(BigDecimal inPLN) {
		return inPLN.divide(mid, 2, RoundingMode.HALF_UP);
	}

	public BigDecimal toPLN(BigDecimal notInPLN) {
		return notInPLN.multiply(mid).setScale(2, RoundingMode.HALF_UP);
	}
}
