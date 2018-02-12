package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * Servlet Filter implementation class WrapFilter
 */
//@WebFilter(filterName="WrapFilter")
public class WrapFilter implements Filter {

    /**
     * Default constructor. 
     */
    public WrapFilter() {
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
		PrintWriter out=response.getWriter();
		ServletContext contexto=request.getServletContext();
		System.out.println("Aplicando filtro envoltorio.");
		response.setContentType("text/html;UTF-8");
		System.out.println("* En Wrap: " + response.getContentType());
		out.println("<html><head><title>Visita: "+contexto.getAttribute("contador")+"</title><meta charset='UTF-8'/></head><body>");
		chain.doFilter(request, response);
		out.println("<h3>Zhenyu Guo</h3>");
		//out.println("<h2>Número de visitas: "+contexto.getAttribute("contador")+"</h2>");
		out.println("</body></html>");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
