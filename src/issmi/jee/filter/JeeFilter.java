package issmi.jee.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class JeeFilter
 */
@WebFilter("/JeeFilter")
public class JeeFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public JeeFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//System.out.println("filtered");

		int counter = (int) request.getServletContext().getAttribute("counter");
		request.getServletContext().setAttribute("counter", ++counter);
		//System.out.println("counter: "+counter);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		int counter = 0;
		fConfig.getServletContext().setAttribute("counter", counter);
	}

}
