package servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
    	response.setCharacterEncoding("utf-8");
    	long number = 0;
    	String text = "";
    	String language = request.getParameter("language");
    	String numb_str = request.getParameter("number");
    	try {
    		number = Long.parseLong(numb_str);
    		if (number < 0) {
    			number = -1*number;
    			text = "minus ";
    		}
    		switch (language) {
				case "English":
					text += NumbersUtil.textValue(Languages.GB, number);
					break;
				case "Polish":
					text += NumbersUtil.textValue(Languages.PL, number);
					break;
				default:
					text = "Select a language";
			}
    	} catch (Exception e) {
    		text = "Error, try again :C";
    	}

		request.setAttribute("text_numb", text);
		request.setAttribute("numb", numb_str);
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


