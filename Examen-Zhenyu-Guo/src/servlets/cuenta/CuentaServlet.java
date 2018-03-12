package servlets.cuenta;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Producto;
import modelo.Usuario;

/**
 * Servlet implementation class CuentaServlet
 */
@WebServlet("/CuentaServlet")
public class CuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CuentaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto=getServletContext();
		HttpSession session = request.getSession(false);
		PrintWriter out=response.getWriter();
		if(session==null) {
			response.sendRedirect(contexto.getContextPath() + "/login");
		}else {
			Usuario user=(Usuario)session.getAttribute("usuario");
			out.println("<html><head><title>Cuenta</title></head><body>");
			out.println("<h1>Datos de la Cuenta</h1>");
			out.println("<ul>"
					+ "<li>Login: "+user.getLogin()
					+ "<li>Password: "+user.getPassword()
					+ "<li>Nombre: "+user.getNombre()
					+ "<li>Gasto: "+user.getGasto()
					+ "Dirección: "+user.getDireccion());
			out.println("</ul>");
			out.println("<h3>Carrito de la compra</h3>");
			@SuppressWarnings("unchecked")
			ArrayList<Producto>carrito=(ArrayList<Producto>) session.getAttribute("carrito");
			if(carrito.isEmpty()) {
				out.println("No hay ningún producto en la cesta");
			}else {
				double importePedido=0;
				out.println("<ul>");
				for (int i=0;i<carrito.size();i++) {
					out.println("<li>"+carrito.get(i).getNombre());
					importePedido+=carrito.get(i).getPrecio();
				}
				out.println("</ul>");
				out.println("<h2>El importe total de la compra es: "+importePedido+"</h2>");
				out.println("<a href=\""+contexto.getContextPath()+"/Compra\"<button>Comprar</button></a>");
			}
			out.println("<a href=\""+contexto.getContextPath()+"/Logout\"<button>Cerrar Sesión</button></a>");
			out.println("<a href=\""+request.getHeader("Referer")+"\"<button>Volver</button></a>");
			out.println("</body></html>");
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
