package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Test1Servlet
 */
@WebServlet("/Test1")
public class Test1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		HttpSession session=request.getSession(false);
		ServletContext contexto=getServletContext();
		if (request.getMethod().equals("POST")) {
			String[]respuestas= (String[]) session.getAttribute("arRespuestas");
			String respuesta=request.getParameter("pregunta1");
			if(respuesta!=null) {
				respuestas[1]=respuesta;
			}else {
				respuestas[1]="";
			}
			session.setAttribute("respuestas", respuestas);
			response.sendRedirect(contexto.getContextPath()+"/Test2");
		}
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		out.println("<html> <head><meta charset='UTF-8'/></head><body>");
		out.println("<fieldset>"
	    +"<legend>Pregunta 1</legend>"
	    +"<form  method=\"post\">"
	    +"<h2>¿Cuál es la bebida favorita de James Bond?</h2>"
	    +"<select name=\"pregunta1\">"
	    	+"<option>Whisky de malta</option>"
	    	+"<option>Martini con vodka</option>"
	    	+"<option>Bloody mary</option>"
    	+"</select>"
    	+"<input type=\"submit\" name=\"enviar\">"
    	+" </form>"
	    +"</fieldset>");
		out.println("</body></html>");;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
