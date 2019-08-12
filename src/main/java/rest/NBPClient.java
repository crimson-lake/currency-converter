package rest;

import java.math.BigDecimal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;


import model.json.RatesTable;

public class NBPClient {
	private final Client restClient = ClientBuilder.newClient();
	//private final WebTarget root = restClient.target("https://api.exchangeratesapi.io/latest?base=USD&symbols=PLN,GBP,USD");
	
	public BigDecimal getExchangeRate(String code) {
		final WebTarget rate = restClient.target("https://api.exchangeratesapi.io/latest?base=USD&symbols=PLN,GBP,USD");
		
		Invocation getRate = rate
				.request()
				.header("Content-type", "application/json; charset=utf-8")
				.buildGet();
		
		Response responseRate = getRate.invoke();
		
		GenericType<RatesTable> type = new GenericType<RatesTable>() {};
		RatesTable exchangeRate = responseRate.readEntity(type);
		
		System.out.println(exchangeRate.getRates(code));
		
		
		return BigDecimal.ZERO;
	}

}
