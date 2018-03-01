package servlets.cuenta;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BajaServlet
 */
@WebServlet("/Baja")
public class BajaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String UserSesion=(String) session.getAttribute("login");
		ServletContext contexto=getServletContext();
		Connection conn = null;Statement sentencia = null;
		String consultaComprobacion = "SELECT * from usuario WHERE login='"+session.getAttribute("login")+"'";
		//String borrado= "";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(contexto.getInitParameter("url"), contexto.getInitParameter("usuarioEscritura"), contexto.getInitParameter("passwordEscritura"));
			sentencia = conn.createStatement();
			ResultSet rset = sentencia.executeQuery(consultaComprobacion);
			if (!rset.isBeforeFirst() ) {    
				System.out.println("No hay resultados");
			}else {
				  rset.next();
				  sentencia.executeQuery("DELETE FROM usuario WHERE login = '"+rset.getString("login")+"'");
					if(UserSesion!=null) {
						session.invalidate();
					}
					response.sendRedirect(contexto.getContextPath() + "/Login?Borrado=true");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
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
