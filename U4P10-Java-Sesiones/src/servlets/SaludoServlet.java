package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SaludoServlet
 */
@WebServlet("/Saludo")
public class SaludoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaludoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String mensajeError="";
		if(request.getParameter("cerrarSesion") !=null) {
			session.invalidate();
			session = request.getSession();
			response.sendRedirect(request.getRequestURI());

		}
		if(session.isNew()) {
				
		}else {
			
		if (request.getMethod().equals("POST")) {
				if (request.getParameter("nombre")!=null) {
					session.setAttribute("nombre", request.getParameter("nombre"));
				}else {
					mensajeError="No ha introducido un nombre";
				}
			}
		}
		out.println("<html><body>");
		if(session.getAttribute("nombre")!=null && !session.getAttribute("nombre").equals("") ) {
			String nombre =session.getAttribute("nombre").toString();
			
			out.println("<h1>Bienvenido "+nombre+"</h1>");
			out.println("<a href='"+request.getRequestURI()+"?cerrarSesion=true'>Cerrar Sesion</a>");
		}else {
			out.println("<form action='"+request.getRequestURI()+"' method='post'>");
			out.println("<label>Introduce tu nombre:</label> <input type='text' name='nombre'/>");
			if(!mensajeError.isEmpty()) {
				out.println("<span class='error'>" + mensajeError + "</span><br/>");
			}
			out.println("<input type='submit' name='enviar' value='Enviar'/></form>");
		}
		
		out.println("</body></html>");
				out.close();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
