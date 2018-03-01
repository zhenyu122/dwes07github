package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ResultadosServlet
 */
@WebServlet("/Resultados")
public class ResultadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultadosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		HttpSession session=request.getSession(false);
		ServletContext contexto=getServletContext();
		if(session==null) {
			response.sendRedirect(contexto.getContextPath()+"/Login");
		}else {
			String[]respuestas= (String[]) session.getAttribute("respuestas");
			if(respuestas[1]==null) {
				response.sendRedirect(contexto.getContextPath()+"/Test1");
			}else if(respuestas[2]==null){
				response.sendRedirect(contexto.getContextPath()+"/Test2");
			}else if(respuestas[3]==null){
				response.sendRedirect(contexto.getContextPath()+"/Test3");
			}else {
				int contAcertado=0,contFallido=0,contNoRespondido=0;
				if(respuestas[1]=="Martini con vodka") {
					contAcertado++;
				}else if(respuestas[1]=="") {
					contNoRespondido++;
				}else {
					contFallido++;
				}
				if(respuestas[2]=="Anthrax") {
					contAcertado++;
				}else if(respuestas[2]=="") {
					contNoRespondido++;
				}else {
					contFallido++;
				}
				if(respuestas[3]=="Herman Melville") {
					contAcertado++;
				}else if(respuestas[3]=="") {
					contNoRespondido++;
				}else {
					contFallido++;
				}
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				out.println("<html> <head><meta charset='UTF-8'/></head><body>");
				if(contAcertado==0) {
					out.println("<h3>No has acertado ninguna pregunta</h3>");
				}else if(contFallido==0 && contNoRespondido==0){
					out.println("<h3>Enhorabuena has acertado todas las preguntas</h3>");
				}else{
					out.println("<h3>Has acertado "+contAcertado+" preguntas</h3>");
					out.println("<h3>Has fallado "+contFallido+" preguntas</h3>");
					out.println("<h3>No has respondido a "+contNoRespondido+" preguntas</h3>");
				}
				out.println("<h3></h3>");
				out.println("<a href='./Logout'><button>Empezar de nuevo</button></a>");
				out.println("</body></html>");
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
