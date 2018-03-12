package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;

/**
 * Servlet implementation class MostrarProductosServlet
 */
//@WebServlet("/MostrarProductosServlet")
public class MostrarProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarProductosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session=request.getSession(false);
		PrintWriter out =response.getWriter();
		ServletContext contexto=getServletContext();
		Connection conn = null;
		Statement sentencia = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(contexto.getInitParameter("url"), contexto.getInitParameter("usuarioLectura"), contexto.getInitParameter("passwordLectura"));
			sentencia = conn.createStatement();
			String consultaFamilia = "SELECT distinct familia FROM producto";
			String consultaProductos="select * from producto where familia=\"Bio\"";
			ResultSet rset = sentencia.executeQuery(consultaFamilia);
			if(request.getParameter("familia")!=null) {
				Cookie familia = new Cookie("familia", request.getParameter("familia"));
				familia.setPath(contexto.getContextPath());
				familia.setMaxAge(60*60*24);
				response.addCookie(familia);
				//String consultaProductos="select * from producto where familia=\"Bio\"";
			}
			Cookie cookieFamilia = buscarCookie("familia", request);
			if(cookieFamilia!=null) {
				consultaProductos="select * from producto where familia=\""+cookieFamilia.getValue()+"\"";
			}
			if(request.getParameter("orden")!=null) {
				if(request.getParameter("orden").equalsIgnoreCase("asc")) {
					consultaProductos+=" order by nombre asc";
				}else if(request.getParameter("orden").equalsIgnoreCase("desc")) {
					consultaProductos+=" order by nombre desc";
				}
			}
			if(request.getParameter("busqueda")!=null) {
				  String busqueda= request.getParameter("busqueda");
				  String[] arBusqueda= busqueda.split(" ");
				  if(arBusqueda.length>1) {
					  for(int i=0; i<arBusqueda.length;i++) {
						  if(i==0) {
							  consultaProductos+=" AND (producto.nombre LIKE '%"+arBusqueda[i]+"%'"; 
						  }
						  if(i>0) {
							  consultaProductos+=" OR producto.nombre  LIKE '%"+arBusqueda[i]+"%'"; 
						  }
						  if(i==arBusqueda.length-1) {
							  consultaProductos+=" OR producto.nombre  LIKE '%"+arBusqueda[i]+"%')"; 
						  }
					  }
				  }else {
					  consultaProductos+=" AND producto.nombre LIKE '%"+busqueda+"%'"; 
				  }
			  }
			if (!rset.isBeforeFirst() ) {    
				   out.println("<h3>No hay resultados</p>");
			}else {
				out.println("<html> <head>\r\n" 
						+ "<style>td,th{text-align:center}a{text-decoration:none;}a:hover{color:red}td:empty{border:0}"
						+ "</style>"
						+ "<meta charset='UTF-8'/></head><body>");
				out.println("<h3>Supermercado Zhenyu Guo</h3>");
				out.println("<img src='./img/supermercado1.jpg' width='100px'/>");
				out.println("<form action='"+request.getRequestURI()+"' method='post'>");
			    out.println("<input class='form-control' placeholder='Buscar' type='text' name='busqueda'/>");
			    out.println("<input type='submit' name='enviar' value='Enviar'/>");
			    out.println("<a href='./"+request.getRequestURI()+"'><button>Limpiar filtros</button></a>");
				out.println("<ul>");
				while (rset.next()) {
					out.println("<li><a href='"+request.getRequestURI()+"?familia="+rset.getString("familia")+"'>"+rset.getString("familia")+"</a>");
									}
				out.println("</ul>");
				Usuario usuario = (Usuario) session.getAttribute("usuario");
				out.println("<h4>Sesión iniciada como <a href='"+contexto.getContextPath()+"/Cuenta'>"+ usuario.getNombre() + "</a></h4>");
				/*String consultaProductos="select * from producto where familia=\"Bio\"";
				Cookie cookieFamilia = buscarCookie("familia", request);
				if(cookieFamilia!=null) {
					consultaProductos="select * from producto where familia=\""+cookieFamilia.getValue()+"\"";
				}*/
				/*if(request.getParameter("orden")!=null) {
					if(request.getParameter("orden").equalsIgnoreCase("asc")) {
						consultaProductos+=" order by nombre asc";
					}else if(request.getParameter("orden").equalsIgnoreCase("desc")) {
						consultaProductos+=" order by nombre desc";
					}
				}*/
				rset=sentencia.executeQuery(consultaProductos);
				if (!rset.isBeforeFirst() ) {    
					   out.println("<h3>No hay productos</p>");
				}else {
					 out.println("<table border='1'>");
					 out.println("<thead><tr>"
					 		+ "<th>Nombre<a href='"+request.getRequestURI()+"?orden=asc'>&#9650</a><a href='"+request.getRequestURI()+"?orden=desc'>&#9660</a></th>"
					 		+ "<th>Marca</th>"
					 		+ "<th>Imagen</th>"
					 		+ "</tr></thead><tbody>");
					 out.println("<h3>Hay que recargar la pagina para que coja bien la consulta</h3>");

					
					while (rset.next()) {
						out.println("<tr>");
						out.println("<td><a href='./DetalleProducto?idProducto="+rset.getInt("idproducto")+"'>"+rset.getString("nombre")+"</a>"
								+ "<a href='./Cesta?idProducto="+rset.getInt("idproducto")+"'><img src='./img/carrito1.png' width='50px'/></a></td>");
						out.println("<td>"+rset.getString("marca")+"</td>");
						out.println("<td><img src='./img/productos/"+rset.getString("imagen")+"' width='100px'/></td>");
						out.println("</tr>");
					}
					out.println("</tbody></table>");
				}
				out.println("</body></html>");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	private Cookie buscarCookie(String nombreCookie, HttpServletRequest request) {
		Cookie x=null;
		Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
		Cookie[] cookies = request.getCookies();
		
		if(cookies!=null) {
			
			for(Cookie c : cookies){
			        cookieMap.put(c.getName(), c);
			}
			
			Cookie cookieUsuario = cookieMap.get(nombreCookie);
			
			if(cookieUsuario!=null) {
				x=cookieUsuario;
			}
			
		}
		return x;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
