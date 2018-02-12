package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LogFilter
 */

//@WebFilter("/LogFilter")
//@WebFilter(urlPatterns = "/Saludo")
//@WebFilter(servletNames="SaludoServlet")
//@WebFilter(servletNames= {"SaludoServlet","FechaServlet"})


//@WebFilter(urlPatterns = "/Saludo")
//@WebFilter(servletNames="SaludoServlet")
//@WebFilter(servletNames= {"SaludoServlet","FechaServlet"})
//@WebFilter(urlPatterns = {"/Saludo","/Fecha"})
//@WebFilter(urlPatterns = "*.html")
//@WebFilter(urlPatterns = {"*.html","/Saludo"})
//@WebFilter(urlPatterns = "*.html",servletNames="SaludoServlet")
//@WebFilter(urlPatterns = "/*")

//@WebFilter(filterName="FiltroDeRegistro")
public class LogFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Aplicando filtro de registro.");
		if (request instanceof HttpServletRequest) 
			System.out.println("Petición:" + ((HttpServletRequest)request).getRequestURL().toString());
		
		PrintWriter out = response.getWriter();
		out.println("<p>Mensaje 1: Estamos aplicando el filtro de registro</p>");
		
		chain.doFilter(request, response);
		
		out.println("<p>Mensaje 2: De vuelta en el filtro tras ejecutar el resto de la cadena</p>");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
