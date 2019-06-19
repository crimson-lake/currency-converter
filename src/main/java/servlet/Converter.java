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
    	long number = Long.parseLong(request.getParameter("number"));
		String language = request.getParameter("language");
		String text = "";
		switch (language) {
			case "British":
				text = NumbersUtil.textValue(Languages.GB, number);
				break;
			case "American":
				text = NumbersUtil.textValue(Languages.US, number);
				break;
			case "Polish":
				text = NumbersUtil.textValue(Languages.PL, number);
				break;
			default:
				text = "Select a language";
		}
		request.setAttribute("text_numb", text);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/form.jsp");
		dispatcher.forward(request, response);


	}

}
