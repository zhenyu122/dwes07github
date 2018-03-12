package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;


/**
 * Servlet implementation class DetalleProductoServlet
 */
//@WebServlet("/DetalleProductoServlet")
public class DetalleProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalleProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int idProducto = 0;
		boolean erroridProductoAusente = false;
		boolean erroridProductoFormato = false;
		ServletContext contexto=getServletContext();
		HttpSession session=request.getSession(false);
		PrintWriter out = response.getWriter();
		String idProductoParametro = request.getParameter("idProducto");
		if (idProductoParametro == null) {
			erroridProductoAusente = true;
			response.sendRedirect(contexto.getContextPath()+"/MostrarProductos");
		}else {
			  try {
				  idProducto = Integer.parseInt(idProductoParametro);
			  } catch (Exception e) {
				  erroridProductoFormato = true;
			  }
		}
		out.println("<html> <head><style>td,th{text-align:center}</style><meta charset='UTF-8'/></head><body>");
		if (erroridProductoAusente) {
			  out.println("<h3>Error: falta identificador del producto</h3>");
			} else if (erroridProductoFormato) {
			  out.println("<h3>Error: el identificador del producto debe ser numérico</h3>");
			} else {
				Connection conn = null;
				Statement sentencia = null;
				try {
					Class.forName("org.mariadb.jdbc.Driver").newInstance();
					conn = DriverManager.getConnection(contexto.getInitParameter("url"), contexto.getInitParameter("usuarioLectura"), contexto.getInitParameter("passwordLectura"));
				    sentencia = conn.createStatement();
				    String consulta = "SELECT ubicacion.* from producto,ubicacion WHERE idproducto="+idProducto+" and ubicacion=idubicacion" ;
					ResultSet rset = sentencia.executeQuery(consulta);
					if (!rset.isBeforeFirst() ) {    
					    out.println("<h3>Error: identificador de producto no válido</h3>");
					  } else {
							Usuario usuario = (Usuario) session.getAttribute("usuario");
							out.println("<h4>Sesión iniciada como <a href='"+contexto.getContextPath()+"/Cuenta'>"+ usuario.getNombre() + "</a></h4>");
						  out.println("<table border='1'>");
						  out.println("<thead><tr><th>Pasillo</th><th>Modulo</th><th>Altura</th><th>Hueco</th></tr></thead><tbody>");
						  while (rset.next()) {
						    out.println("<tr><td>" + rset.getInt("pasillo")+ "</td>"
						    		+ "<td>" + rset.getInt("modulo")+ "</td>"
						    		+ "<td>"+rset.getInt("altura")+"</td>"
						    		+ "<td>" + rset.getInt("hueco") + "</td>"
				    				+ "</tr>");
						  }
						  out.println("</tbody></table>");
					  }
					out.println("<a href='"+contexto.getContextPath()+"/MostrarProductos'><button>Volver</button></a>");
					out.println("</body><html>");
				}catch (Exception e) {
					System.out.println(e.getMessage());
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
