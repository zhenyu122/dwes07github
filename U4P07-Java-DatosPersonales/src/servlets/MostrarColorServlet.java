package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarColorServlet
 */
@WebServlet("/MostrarColor")
public class MostrarColorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarColorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("enviar")==null) {
			response.sendRedirect("./colores.html");
		}else {
			PrintWriter out = response.getWriter();
			if(request.getParameter("color")==null || request.getParameter("nombre")==null) {
				response.sendRedirect("./colores.html");
				}
			out.println("<html><head></head><body>");
			String color=request.getParameter("color");
			int numero = (int)request.getAttribute("numero");
			String nombre= request.getParameter("nombre");
				out.println("<h3>"+nombre+"</h3>");
				out.println("<h2 style='color:"+color+";'>"+numero+"</h2>");
				out.println("</body></html>");
			
			out.close();
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
