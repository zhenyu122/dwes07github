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
 * Servlet implementation class Test3Servlet
 */
@WebServlet("/Test3")
public class Test3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test3Servlet() {
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
		}else if(respuestas[2]==null){
			response.sendRedirect(contexto.getContextPath()+"/Test2");
		}else {
			if (request.getMethod().equals("POST")) {
				String respuesta=request.getParameter("pregunta3");
				if(request.getParameter("pregunta3")!=null) {
					respuestas[3]=respuesta;
				}else {
					respuestas[3]="";
				}
				session.setAttribute("respuestas", respuestas);
				response.sendRedirect(contexto.getContextPath()+"/Resultados");
			}
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			out.println("<html> <head><meta charset='UTF-8'/></head><body>");
			out.println("<fieldset>"
		    +"<legend>Pregunta 3</legend>"
		    +"<form  method=\"post\">"
		    +"<h2>¿Quién es el autor de \"Moby Dick\"?</h2>"
		    +"<select name=\"pregunta3\">"
		    	+"<option>Walt Whitman</option>"
		    	+"<option>Charles Dickens</option>"
		    	+"<option>Herman Melville</option>"
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
