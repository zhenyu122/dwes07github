package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ValidarFormularioServlet
 */
@WebServlet("/ValidarFormulario")
public class ValidarFormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidarFormularioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("enviar")==null) {
			response.sendRedirect("./index.html");
		}else {
			String errores="";
			PrintWriter out = response.getWriter();
			String clave= request.getParameter("clave");
			 String formato = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{3,}";
			if(clave.matches(formato)) {
				out.println("<p>Contraseña correcta</p>");
			}else {
				errores+="<p>La contraseña no cumple los requisitos</p>";
	
			}
			SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
			try{
				Date fecha = formatoEntrada.parse(request.getParameter("fecha"));
				Date fechaActual = new Date();
				long lnMilisegundos = fechaActual.getTime();
				long lnMilisegundos1 = fecha.getTime();
				
				if(lnMilisegundos>lnMilisegundos1){
					out.println("<p>La fecha "+fecha.toString()+" es correcta</p>");
					
				}else {
					errores+="<p>La fecha "+fecha.toString()+" es incorrecta. Es posterior a la fecha actual</p>";
				}
			
			}catch (Exception e) {
				out.println("<p>Error: "+e+"</p>");
				errores+="<p>Error fecha: "+e+"</p>";
			}
			
			
			String edad= request.getParameter("edad");
			if(!edad.matches("[0-9]+")) {
				errores+="<p>Edad Erronea</p>";
			}
			if(errores.equals("")) {
				out.println("<ul>");
				out.println("<li>Nombre: "+request.getParameter("nombre"));
				out.println("<li>Fecha nacimiento: "+request.getParameter("fecha"));
				out.println("<li>Edad: "+request.getParameter("edad"));
				out.println("<li>Sexo: "+request.getParameter("sexo"));
				out.println("<li>Suscripción: "+request.getParameter("suscripcion"));
				out.println("<li>Ciclo: "+request.getParameter("campo"));
				out.println("<li>Comentario: "+request.getParameter("comentario"));
				out.println("</ul>");
			}else {
				out.println("Errores:<br>");
				out.println(errores);
			}
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
