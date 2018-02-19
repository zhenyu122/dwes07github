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
 * Servlet implementation class MostrarCuidadoresServlet
 */
@WebServlet("/MostrarCuidadores")
public class MostrarCuidadoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarCuidadoresServlet() {
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
		  Class.forName("org.mariadb.jdbc.Driver").newInstance();

		  /*String userName = "alumno";
		  String password = "alumno";
		  String url = "jdbc:mariadb://localhost/animales";*/
		  conn = DriverManager.getConnection(contexto.getInitParameter("URL"), contexto.getInitParameter("UsuarioLectura"), contexto.getInitParameter("ContraseñaLectura"));

		  sentencia = conn.createStatement();
		  
		  String consulta = "SELECT * from cuidador";
		 
		  ResultSet rset = sentencia.executeQuery(consulta);

		  if (!rset.isBeforeFirst() ) {    
			    out.println("<h3>No hay resultados</p>");
			}
			out.println("<ul>");
		  while (rset.next()) {
			out.println("<li><a href='./MostrarCuidador?idCuidador="+rset.getString("idCuidador")+"'>"+rset.getString("Nombre")+"</a>");
		  }
		    out.println("</ul>");

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
