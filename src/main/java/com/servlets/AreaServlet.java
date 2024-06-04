package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Area;
import com.service.AreaService;
import com.service.AreaServiceImpl;

/**
 * Servlet implementation class AreaServlet
 */
@WebServlet("/AreaServlet")
public class AreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AreaServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//open area.jsp
		request.getRequestDispatcher("Area.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get form data
		int l = Integer.parseInt(request.getParameter("length"));
		int b= Integer.parseInt(request.getParameter("breadth"));
		
		//calculate area
		int area = l*b;
		//send to database
		Area a = new Area();
		a.setLength(l);
		a.setBreadth(b);
		
		AreaService service = new AreaServiceImpl();
		service.calculateAera(a);
		// send to Result.jsp
		request.setAttribute("area",area);
		request.getRequestDispatcher("Result.jsp").forward(request, response);
		
	}

}
