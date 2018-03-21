package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animal;

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
		Connection conn = null;
		Statement sentencia = null;
		ArrayList<Animal> listaAnimales = new ArrayList<Animal>();
		try {
		  // Paso 1: Cargar el driver JDBC.
		  Class.forName("org.mariadb.jdbc.Driver").newInstance();

		  // Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
		  String userName = "alumno";
		  String password = "alumno";
		  String url = "jdbc:mariadb://localhost/animales";
		  conn = DriverManager.getConnection(url, userName, password);

		  // Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
		  sentencia = conn.createStatement();

		  // Paso 4: Ejecutar la sentencia SQL a través de los objetos Statement
		  String consulta = "SELECT * from animal";
		  ResultSet rset = sentencia.executeQuery(consulta);

		  // Paso 5: Procesar resultados
		  while (rset.next()) {
			  Animal a = new Animal (Integer.parseInt(rset.getString("chip")), 
					  rset.getString("nombre"), rset.getString("especie"), rset.getString("imagen"));
			  listaAnimales.add(a);
		  }

		  // Paso 6: Desconexión
		  if (sentencia != null)
		    sentencia.close();
		  if (conn != null)
		    conn.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}		
		request.setAttribute("animales",  listaAnimales);

		// Utiliza sólo una de las dos siguientes líneas:
		RequestDispatcher rd = request.getRequestDispatcher("jsp/MostrarAnimales.jsp"); // sin JSTL
		//RequestDispatcher rd = request.getRequestDispatcher("jsp/MostrarAnimales2.jsp"); // con JSTL
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
