package filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
//@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	  	// definimos elementos que utilizaremos:
		HttpServletRequest request = (HttpServletRequest) req; // L1
		HttpServletResponse response = (HttpServletResponse) res; // L1
		ServletContext contexto = request.getServletContext(); 
		Connection conn = null;Statement sentencia = null;
		String uri = request.getRequestURI();
		HttpSession session = request.getSession(false); // si no existe no la creamos // L2
		String errorSesion = ""; // L3
		// comprobamos posibles errores:
	  	// a. Aviso: intento de acceso sin sesión iniciada
		if(session==null) {
			System.out.println("Aviso: intento de acceso sin sesión iniciada");
			errorSesion+="Aviso: intento de acceso sin sesión iniciada";
		}else {
	  	// b. Aviso: existe sesión iniciada pero no contiene usuario
	  	// c. Aviso: existe sesión iniciada pero el usuario no existe en la base de datos
			try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(contexto.getInitParameter("url"), contexto.getInitParameter("usuarioLectura"), contexto.getInitParameter("passwordLectura"));
			sentencia = conn.createStatement();
			String consulta = "SELECT * FROM usuario where login=\""+session.getAttribute("login")+"\"";
			ResultSet rset = sentencia.executeQuery(consulta);
			if (!rset.isBeforeFirst() ) {    
				errorSesion+="Aviso: existe sesión iniciada pero el usuario no existe en la base de datos";
			}
			
			// Desconexión
			  if (rset != null)
			    rset.close();
			  if (sentencia != null)
			    sentencia.close();
			  if (conn != null)
			    conn.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// redirigir en caso de error, salvo en excepciones
		if( !errorSesion.isEmpty() && !(uri.endsWith("html") || uri.endsWith("Login") || uri.endsWith("Alta"))){ // L4
			contexto.log(errorSesion + " - " + uri);
			response.sendRedirect(contexto.getContextPath()+"/Login");
		}else{
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
