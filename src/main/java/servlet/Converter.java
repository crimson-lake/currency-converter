package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.zielinska.numbers.languages.Languages;
import pl.zielinska.numbers.util.NumbersUtil;


@WebServlet("/Converter")
public class Converter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Converter() {
        super();

    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setCharacterEncoding("UTF-8");
    	
    	BigDecimal number = BigDecimal.ZERO;
    	String text = null;
    	String from = request.getParameter("from");
    	
    	try {
    		number = new BigDecimal(request.getParameter("number")).setScale(2, RoundingMode.HALF_UP);
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

		request.setAttribute("text_numb", text);
		request.setAttribute("numb", number.toString());
		request.setAttribute("currency", from);
		
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


