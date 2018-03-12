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
 * Servlet implementation class CestaServlet
 */
//@WebServlet("/CestaServlet")
public class CestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CestaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto=getServletContext();
		HttpSession session=request.getSession(false);
		int idProducto;
		if(request.getParameter("idProducto")!=null) {
			idProducto=Integer.parseInt(request.getParameter("idProducto"));
			Connection conn = null;
			Statement sentencia = null;
			try {
				Class.forName("org.mariadb.jdbc.Driver").newInstance();
				conn = DriverManager.getConnection(contexto.getInitParameter("url"), contexto.getInitParameter("usuarioLectura"), contexto.getInitParameter("passwordLectura"));
			    sentencia = conn.createStatement();
			    System.out.println(idProducto);
			    String consulta="select * from producto where idproducto="+idProducto;
			    
			    ResultSet rset=sentencia.executeQuery(consulta);
			    if(!rset.isBeforeFirst()) {
			    	System.out.println("<h3>Error: identificador de producto no válido</h3>");
			    }else {
			    	rset.next();
				    	Producto producto=new Producto(rset.getInt("idproducto"), rset.getString("nombre"), rset.getString("marca"), rset.getDouble("precio"), rset.getInt("stock"));
						ArrayList<Producto>carrito=(ArrayList<Producto>) session.getAttribute("carrito");
				    	carrito.add(producto);
				    	session.setAttribute("carrito", carrito);
						response.sendRedirect(contexto.getContextPath() + "/MostrarProductos");
			    	
			    }
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}else {
			response.sendRedirect(contexto.getContextPath()+"/MostrarProductos");
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
