package filters;
/*
 * Created by Jaime Nejaim 
 * 
 * 
 */

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.LoginBean;
import beans.NavigationBean;
import classesBasicas.Administrador;
import classesBasicas.Usuario;

@WebFilter("/admin/*")
public class LoginFilter implements Filter{

	private NavigationBean navigationBean;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		navigationBean = new NavigationBean();
		LoginBean loginBean = (LoginBean)((HttpServletRequest)request).getSession().getAttribute("loginBean");
		
		String requestURI  = ((HttpServletRequest) request).getRequestURI();
			
		if(loginBean == null || loginBean.isLoggedIn() == false)
		{
			((HttpServletResponse) response).sendRedirect(((HttpServletRequest)request).getContextPath() + navigationBean.toLogin());
		}else{
			
		}
		
			
		//Redireciona o usuario para a pagina de login
		//((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/login.xhtml");
	
			chain.doFilter(request, response);	
	}

	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}



}
