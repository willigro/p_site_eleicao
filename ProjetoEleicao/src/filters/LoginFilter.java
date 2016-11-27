package filters;
/*
 * Created by Jaime Nejaim 
 * 
 * 
 */

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
import beans.LoginBean;
import beans.NavigationBean;

@WebFilter("/admin/*")
public class LoginFilter implements Filter{

	private NavigationBean navigationBean;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		navigationBean = new NavigationBean();
		HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        LoginBean session = (LoginBean)req.getSession().getAttribute("loginBean");
        String url = req.getRequestURI();
        if(session == null || session.isLoggedIn() == false)
        {
            if(!url.equals(navigationBean.toLogin()))
            {
                res.sendRedirect(req.getContextPath() + navigationBean.toLogin());
            }
        }
        else
        {
            chain.doFilter(request, response);
        } 	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

}
