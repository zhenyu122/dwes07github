package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Producto;

/**
 * Servlet implementation class CompraServlet
 */
//@WebServlet("/CompraServlet")
public class CompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		ServletContext contexto=getServletContext();
		@SuppressWarnings("unchecked")
		ArrayList<Producto>carrito=(ArrayList<Producto>) session.getAttribute("carrito");
		Connection conn = null;
		Statement sentencia = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(contexto.getInitParameter("url"), contexto.getInitParameter("usuarioEscritura"), contexto.getInitParameter("passwordEscritura"));
			sentencia = conn.createStatement();
			double importePedido=0,gastoCliente=0;
			String consulta="select * from cliente where login=\""+session.getAttribute("login")+"\"";
			
			ResultSet rset = sentencia.executeQuery(consulta);
			if(!rset.isBeforeFirst()) {
		    	System.out.println("<h3>Error: identificador de producto no válido</h3>");
		    }else {
		    	rset.next();
				for (int i=0;i<carrito.size();i++) {
					importePedido+=carrito.get(i).getPrecio();
				}
				gastoCliente=rset.getDouble("gasto");
				String consultaCambio="update cliente set gasto="+(importePedido+gastoCliente)+" where login=\""+session.getAttribute("login")+"\"";
				rset=sentencia.executeQuery(consultaCambio);
				carrito.clear();
				session.setAttribute("carrito", carrito);
				response.sendRedirect(contexto.getContextPath()+"/MostrarProductos");
				
		    	
		    }
		}catch (Exception e) {
			System.out.println(e.getMessage());		
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
