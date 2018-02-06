package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InfoSesionServlet
 */
@WebServlet("/InfoSesion")
public class InfoSesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoSesionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Crear una sesión o recuperar la existente si se encuentra la cookie de sesión
		HttpSession session = request.getSession();
		boolean primera=false;
		int contador = 0;
		if(request.getParameter("reiniciarSesion")!=null) {
			session.invalidate();
			session = request.getSession();
		}
		//session.setMaxInactiveInterval(10);
		// Comprobar si es la primera vez
		if (session.isNew()) {
		  session.setAttribute("contador", 0);
		  primera=true;
		} else {
		  contador = (int) session.getAttribute("contador");
		  contador++;
		  session.setAttribute("contador", contador);
		}
		
		// Obtener datos sobre la sesión
		Date fechaInicioSesion = new Date(session.getCreationTime());
		// Obtener la fecha del último acceso
		Date fechaUltimoAcceso = new Date(session.getLastAccessedTime());
		
		// Comienza la salida...
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/>" + "<style> .error {color: red}</style>"
		    + "<title>Sesiones en JavaEE</title></head><body>");
		response.setContentType("text/html;UTF-8");
		if (primera) {
			out.println("<h3>Esta es tu primera visita, se ha creado una sesión</h3>");
		}else {
		out.println("<h2>Información sobre la sesión</h2>" +
		            "<ul>" +
		            "<li> Identificador: " + session.getId() + "</li>\n" +
		            "<li> Fecha de creación: " + fechaInicioSesion + "</li>\n" +
		            "<li> Fecha de último acceso: " + fechaUltimoAcceso + "</li>\n" +
		            "<li> Número de visitas: " + contador + "</li>\n" +
		            "</ul>");
		}
		out.println("<p><a href='" + request.getRequestURI() + "'>Refrescar</a></p>");
		out.println("<p><a href='" + response.encodeURL(request.getRequestURI())+ "'>Refrescar con reescritura de URL</a></p>"); 
		out.println("<p><a href='" + request.getRequestURI() + "?reiniciarSesion=true'>Borrar la sesión</a></p>");
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
