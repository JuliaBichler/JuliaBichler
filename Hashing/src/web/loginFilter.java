package web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class loginFilter
 */
@WebFilter("/loginFilter")
public class loginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public loginFilter() {
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
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String url =req.getRequestURI();
		HttpSession session = req.getSession(false);
		boolean isLoggedIn=false;
		
		if(session !=null) {
			Object o=session.getAttribute("user");
			if(o!=null) {
				isLoggedIn=true;
			}
		}
		
		boolean wantsToLogIn=url.toLowerCase().contains("loginpage.jsp") 
				|| url.toLowerCase().contains("register")
				|| url.toLowerCase().contains("login") 
				|| url.toLowerCase().contains(".css");
		
		if(isLoggedIn==false && (!wantsToLogIn)){
			res.sendRedirect("loginpage.jsp");	
		}
		else {
			chain.doFilter(req, res);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
