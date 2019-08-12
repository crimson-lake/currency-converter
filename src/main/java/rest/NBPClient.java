package rest;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;


import model.json.RatesTable;

public class NBPClient {
	private final Client restClient = ClientBuilder.newClient();
	
	public BigDecimal getExchangeRate(String base, String code) {
		String address = "https://api.exchangeratesapi.io/latest?base=" + base + "&symbols=" + code;
		final WebTarget rate = restClient.target(address);
		Invocation getRate = rate
				.request()
				.header("Content-type", "application/json; charset=utf-8")
				.buildGet();
		
		Response responseRate = getRate.invoke();
		
		GenericType<RatesTable> type = new GenericType<RatesTable>() {};
		RatesTable exchangeRate = responseRate.readEntity(type);
		
		return exchangeRate.getRates(code);
	}

}
