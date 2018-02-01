package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class GenerarColorServlet
 */
@WebServlet("/GenerarColor")
public class GenerarColorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerarColorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("enviar")==null) {
			response.sendRedirect("./colores.html");
		}else {
			String nombre=request.getParameter("nombre");
			int limite=0;
			if(request.getParameter("limite")!=null) 
			limite=Integer.parseInt(request.getParameter("limite"));
				
			String color=request.getParameter("color");
			ServletContext contexto = getServletContext();
			
			if(nombre!=null && limite>0 && color!=null ) {
				int numero =(int)Math.round(Math.random()*limite-1);
				request.setAttribute("numero", numero);
				RequestDispatcher rd = request.getRequestDispatcher("/MostrarColor");
				rd.forward(request, response);
				
			}else {
				response.sendRedirect(contexto.getContextPath()+"/colores.html");
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
