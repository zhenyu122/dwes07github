package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarAnimalesServlet
 */
@WebServlet("/MostrarAnimales")
public class MostrarAnimalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarAnimalesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto = getServletContext();
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/></head><body>");
		Connection conn = null;
		Statement sentencia = null;
		try {
		  // Paso 1: Cargar el driver JDBC.
		  Class.forName("org.mariadb.jdbc.Driver").newInstance();

		  // Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
		 /* String userName = "alumno";
		  String password = "alumno";
		  String url = "jdbc:mariadb://localhost/animales";*/
		  conn = DriverManager.getConnection(contexto.getInitParameter("URL"), contexto.getInitParameter("UsuarioLectura"), contexto.getInitParameter("ContraseñaLectura"));

		  // Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
		  sentencia = conn.createStatement();

		  // Paso 4: Ejecutar la sentencia SQL a través de los objetos Statement
		  
		  String consulta = "SELECT * from animal";
		  //String consulta ="SELECT * from animal WHERE nombre='donald'";
		 
		  ResultSet rset = sentencia.executeQuery(consulta);

		  // Paso 5: Mostrar resultados
		  
		  /*if (!rset.next()) { // MALA SOLUCIÓN
			    out.println("<h3>No hay resultados</p>");
			}*/
		  
		  if (!rset.isBeforeFirst() ) {    
			    out.println("<h3>No hay resultados</p>");
			}

			out.println("<table border='1'>");
			out.println("<th>Nombre");
			out.println("<th>Especie");
			out.println("<th>Imagen");
		  while (rset.next()) {
			out.println("<tr>");
			out.println("<td>"+rset.getString("nombre")+"</td>");
			out.println("<td>"+rset.getString("especie")+"</td>");
			out.println("<td><img src='img/"+rset.getString("imagen")+"' width='100px'/></td>");
			out.println("</tr>");
		  }
		    out.println("</table>");

		  // Paso 6: Desconexión
		  if (sentencia != null)
		    sentencia.close();
		  if (conn != null)
		    conn.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
