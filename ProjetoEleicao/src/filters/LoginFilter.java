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
		
		
		if(loginBean == null || loginBean.isLoggedIn() == false)
		{
			((HttpServletResponse) response).sendRedirect(((HttpServletRequest)request).getContextPath() + navigationBean.toLogin());
		}else
		{
//			String url = ((HttpServletRequest)request).getRequestURL().toString();
//			System.out.println("entrou e a url e: "+url.toString());
//			
//		
//			if(url.equals(((HttpServletRequest) request).getContextPath() + navigationBean.toLogin())){
//				
//				if(loginBean.getUsuarioLogado().getClass() == Usuario.class){
//					System.out.println("user");
//					((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + navigationBean.toMainUsuario());
//				}
//				else if(loginBean.getUsuarioLogado().getClass() == Administrador.class){
//					System.out.println("adm");
//					((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + navigationBean.toMainAdministrador());	
//				}
//				
//			}
			
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
