package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarCuidadorServlet
 */
@WebServlet("/MostrarCuidador")
public class MostrarCuidadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarCuidadorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCuidador = 0;
		boolean errorIdCuidadorAusente = false;
		boolean errorIdCuidadorFormato = false;
		PrintWriter out = response.getWriter();
		String idCuidadorParametro = request.getParameter("idCuidador");
		if (idCuidadorParametro == null)
		  errorIdCuidadorAusente = true;
		else {
		  try {
		    idCuidador = Integer.parseInt(idCuidadorParametro);
		  } catch (Exception e) {
		    errorIdCuidadorFormato = true;
		  }
		}

		if (errorIdCuidadorAusente) {
		  out.println("<h3>Error: falta identificador de cuidador</h3>");
		} else if (errorIdCuidadorFormato) {
		  out.println("<h3>Error: el identificador de cuidador debe ser numérico</h3>");
		} else {
			Connection conn = null;
			Statement sentencia = null;
			ServletContext contexto=request.getServletContext();
			try {
			  // Paso 1: Cargar el driver JDBC.
			  Class.forName("org.mariadb.jdbc.Driver").newInstance();

			  // Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
			 /* String userName = "alumno";
			  String password = "alumno";
			  String url = "jdbc:mariadb://localhost:3306/animales";*/
			  conn = DriverManager.getConnection(contexto.getInitParameter("URL"), contexto.getInitParameter("UsuarioLectura"), contexto.getInitParameter("ContraseñaLectura"));

			  sentencia = conn.createStatement();

			  String consulta = "SELECT nombre from cuidador WHERE idCuidador="+idCuidador ;
			  ResultSet rset = sentencia.executeQuery(consulta);

			  if (!rset.isBeforeFirst() ) {    
			    out.println("<h3>Error: identificador de cuidador no válido</h3>");
			  }
			  else {
			    rset.next();
			    out.println("<p>Animales cuidados por " + rset.getString("nombre")+ ":</p>");
			    String consultaAnimales = "SELECT animal.* FROM animal, cuida WHERE (animal.chip = cuida.chipAnimal) AND (cuida.idCuidador = '"+idCuidador+"')";
			    rset = sentencia.executeQuery(consultaAnimales);
			    if (!rset.isBeforeFirst() ) {    
			      out.println("<p>Este cuidador no cuida ningún animal</p>");
			    }
			    while (rset.next()) {
			      out.println("<li>" + rset.getString("nombre") + ", de la especie " + rset.getString("especie") + "</li>");
			    }
			    out.println("<br></ul>");
			  }
			  out.println("<a href='./MostrarCuidadores'>Volver</a>");

			  // Paso 6: Desconexión
			  if (sentencia != null)
			    sentencia.close();
			  if (conn != null)
			    conn.close();
			} catch (Exception e) {
			  e.printStackTrace();
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
