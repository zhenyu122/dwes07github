package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class TestFilter
 */
@WebFilter("/TestFilter")
public class TestFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TestFilter() {
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
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res; 
		ServletContext contexto=request.getServletContext();
		HttpSession session=request.getSession();
		String[]respuestas= (String[]) session.getAttribute("respuestas");
		if(respuestas[1]==null) {
			response.sendRedirect(contexto.getContextPath()+"/Test1");
		}else if(respuestas[2]==null){
			response.sendRedirect(contexto.getContextPath()+"/Test2");
		}else if(respuestas[3]==null){
			response.sendRedirect(contexto.getContextPath()+"/Test3");
		}else {
			response.sendRedirect(contexto.getContextPath()+"/Resultados");
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
