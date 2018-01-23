package servlets;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class GenerarNumeroServlet
 */
@WebServlet("/Sorpresa")
public class GenerarNumeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerarNumeroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//PrintWriter out=response.getWriter();
		int x=(int) ((Math.random()*100)+1);
		request.setAttribute("numero",x);
		RequestDispatcher rd =request.getRequestDispatcher("GenerarColores");
		/*out.println("<html><head><title>Numero aleatorio</title></head><body>");
		out.println("<h1>"+x+"</h1>");
		out.println("</body></html>");
		out.close();*/
		
		//response.sendRedirect("./MostrarNumero");
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
