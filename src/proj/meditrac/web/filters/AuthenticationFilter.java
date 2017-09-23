package proj.meditrac.web.filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proj.meditrac.util.Utility;

@WebFilter(
	urlPatterns = "/dashboard/*",
    dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD}		
)
public class AuthenticationFilter implements Filter {

    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(Utility.checkCookie((HttpServletRequest)request)){
			chain.doFilter(request, response);
		} else
			((HttpServletResponse) response).sendRedirect("/MediTrac");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
