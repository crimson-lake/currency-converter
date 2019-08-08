package rest;

import java.math.BigDecimal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class NBPClient {
	private final Client restClient = ClientBuilder.newClient();
	private final WebTarget root = restClient.target("http://api.nbp.pl/api/exchangerates/rates/A");
	
	public BigDecimal getExchangeRate(String code) {
		final WebTarget rate = root.path("/" + code);
		
		Invocation getRate = rate
				.request()
				.header("Accept", "application/json")
				.buildGet();
		
		Response responseRate = getRate.invoke();
	}

}
