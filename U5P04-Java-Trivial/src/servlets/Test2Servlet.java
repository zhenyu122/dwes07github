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
 * Servlet implementation class Test2Servlet
 */
@WebServlet("/Test2")
public class Test2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test2Servlet() {
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
		String[]respuestas= (String[]) session.getAttribute("respuestas");
		if(respuestas[1]==null) {
			response.sendRedirect(contexto.getContextPath()+"/Test1");
		}else {
			if (request.getMethod().equals("POST")) {
				String respuesta=request.getParameter("pregunta2");
				if(request.getParameter("pregunta2")!=null) {
					respuestas[2]=respuesta;
				}else {
					respuestas[2]="";
				}
				session.setAttribute("respuestas", respuestas);
				response.sendRedirect(contexto.getContextPath()+"/Test2");
			}
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			out.println("<html> <head><meta charset='UTF-8'/></head><body>");
			out.println("<fieldset>"
		    +"<legend>Pregunta 2</legend>"
		    +"<form  method=\"post\">"
		    +"<h2>¿Cual de los siguientes grupos se originó en Nueva York?</h2>"
		    +"<select name=\"pregunta2\">"
		    	+"<option>Iron Maiden</option>"
		    	+"<option>Anthrax</option>"
		    	+"<option>Megadeth</option>"
	    	+"</select>"
	    	+"<input type=\"submit\" name=\"enviar\">"
	    	+" </form>"
		    +"</fieldset>");
			out.println("</body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
