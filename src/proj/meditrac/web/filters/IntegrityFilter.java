package proj.meditrac.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import proj.meditrac.core.Manager;

public class IntegrityFilter implements Filter {

    public IntegrityFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		if(Manager.isMeditracIntact()){
			chain.doFilter(request, response);
		} else 
			req.getRequestDispatcher("WEB-INF/jsp/errors/500.jsp").forward(request, response);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
