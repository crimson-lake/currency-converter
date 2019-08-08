package rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class NBPClient {
	private final Client restClient = ClientBuilder.newClient();
	private final WebTarget root = restClient.target("http://api.nbp.pl/api/exchangerates");
	
	public BigDecimal getExchangeRate() {
		
	}

}
