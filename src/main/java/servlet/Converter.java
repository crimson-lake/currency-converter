package servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rest.NBPClient;
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
    	final String from_currency = request.getParameter("from");
    	final String to = request.getParameter("to");
    	
    	Translator from = new Translator(from_numb);
    	
    	NBPClient nbp = new NBPClient();
    	String rate = nbp.getExchangeRate(to).toString();
    	
		request.setAttribute("text_numb", from.toText(from_currency));
		request.setAttribute("numb", from.getNumber().toString());
		request.setAttribute("from", from_currency);
		request.setAttribute("rate", rate);
		
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


