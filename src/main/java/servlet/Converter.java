package servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rest.client.ExchangeRatesClient;
import util.Calculator;
import util.Translator;



@WebServlet("/Converter")
public class Converter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Converter() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setCharacterEncoding("UTF-8");
    	
    	final String from_numb = request.getParameter("number");
    	Translator from = new Translator(from_numb);
    	
    	final String from_currency = request.getParameter("from");
    	final String to_currency = request.getParameter("to");
    	
    	ExchangeRatesClient api = new ExchangeRatesClient();
    	BigDecimal rate = api.getExchangeRate(from_currency, to_currency);
    	
    	Translator to = new Translator(Calculator.convertCurrency(from.getNumber(), rate));
    	
		request.setAttribute("numb_text_before", from.toText(from_currency));
		request.setAttribute("numb_before", from.getNumber());
		request.setAttribute("from_currency", from_currency);
		
		request.setAttribute("rate", rate);
		request.setAttribute("numb_text_after", to.toText(to_currency));
		request.setAttribute("numb_after", to.getNumber());
		request.setAttribute("to_currency", to_currency);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/form.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {}
	}
    
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


