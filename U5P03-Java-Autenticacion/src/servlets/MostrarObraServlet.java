package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.*;

/**
 * Servlet implementation class MostrarObraServlet
 */
@WebServlet("/MostrarObra")
public class MostrarObraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarObraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		response.setContentType("text/html; charset=UTF-8");
		int idObra = 0;
		boolean erroridObraAusente = false;
		boolean erroridObraFormato = false;
		PrintWriter out = response.getWriter();
		String idObraParametro = request.getParameter("idObra");
		if (idObraParametro == null)
		  erroridObraAusente = true;
		else {
		  try {
		    idObra = Integer.parseInt(idObraParametro);
		  } catch (Exception e) {
		    erroridObraFormato = true;
		  }
		}
		out.println("<html> <head><style>td,th{text-align:center}</style><meta charset='UTF-8'/></head><body>");
		if (erroridObraAusente) {
		  out.println("<h3>Error: falta identificador de la obra</h3>");
		} else if (erroridObraFormato) {
		  out.println("<h3>Error: el identificador de la obra debe ser numérico</h3>");
		} else {
			Obra obra;
			Connection conn = null;
			Statement sentencia = null;
			try {
			  // Paso 1: Cargar el driver JDBC.
			  Class.forName("org.mariadb.jdbc.Driver").newInstance();

			  // Paso 2: Conectarse a la Base de Datos utilizando la clase Connection

			  String userName = "alumno";
			  String password = "alumno";
			  String url = "jdbc:mariadb://localhost/catalogo07";
			  conn = DriverManager.getConnection(url, userName, password);
			  sentencia = conn.createStatement();

			  String consulta = "SELECT obras.*,autor.Nombre from obras,autor WHERE obras.ID="+idObra+" and Compania=autor.ID" ;
			  ResultSet rset = sentencia.executeQuery(consulta);

			  if (!rset.isBeforeFirst() ) {    
			    out.println("<h3>Error: identificador de obra no válido</h3>");
			  } else {
				  out.println("<table border='1'>");
				  out.println("<thead><tr><th>ID</th><th>Titulo</th><th>Imagen</th><th>Compania ID</th><th>Compania</th></tr></thead><tbody>");
				  while (rset.next()) {
					obra=new Obra(rset.getInt("ID"), rset.getString("Titulo"), rset.getString("Compania"),rset.getString("Imagen"),rset.getString("Nombre"));
				    out.println("<tr><td>" + obra.getID()+ "</td>"
				    		+ "<td>" + obra.getTitulo()+ "</td>"
				    		+ "<td><img width=100px src='./img/"+obra.getImagen()+"'></td>"
				    		+ "<td>" + obra.getCompania() + "</td>"
		    				+ "<td>"+obra.getNombreCompania()+"</td></tr>");
				    
				  }
				  out.println("</tbody></table>");
				  out.println("<br><a href='./MostrarCatalogo'><button>Volver al catalogo</button></a>");
			  }

			  // Paso 6: Desconexión
			  if (sentencia != null)
			    sentencia.close();
			  if (conn != null)
			    conn.close();
			} catch (Exception e) {
			  e.printStackTrace();
			}
		}
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		out.println("<h4>Sesión iniciada como <a href='"+request.getRequestURI()+"/Cuenta'>" 
			+ usuario.getNombre() + "</a></h4>");
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
