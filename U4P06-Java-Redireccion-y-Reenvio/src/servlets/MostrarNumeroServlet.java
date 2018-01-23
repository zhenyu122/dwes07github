package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MostrarNumeroServlet
 */
@WebServlet("/MostrarNumero")
public class MostrarNumeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarNumeroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Mostrar numero aleatorio</title>"
				+ "<style>div{"
				+ "background-color:rgb("+request.getAttribute("rojo")+", "+request.getAttribute("verde")+", "+request.getAttribute("azul")+");}</style></head><body>");
		if(request.getAttribute("numero")==null) {
			response.sendRedirect("./Sorpresa");
			//out.println("<h3>Error. No se ha encontrado el atributo</h3>");
		}else {
			
			out.println("<p>Numero generado por el primer servlet : "+request.getAttribute("numero")+"</p>");
			
			out.println("<div>");
			out.println("<p>Color generado por el segundo servlet</p>");
			out.println("</div>");
		}
		out.println("<a href='./index.html'><input type='button' value='Volver'></a>");
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
