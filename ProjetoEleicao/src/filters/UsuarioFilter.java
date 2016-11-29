package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import beans.LoginBean;
import beans.NavigationBean;
import classesBasicas.Administrador;
import classesBasicas.Usuario;

//@WebFilter("/usr/*")
public class UsuarioFilter implements Filter{

	private NavigationBean navigationBean;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		LoginBean loginBean = (LoginBean)((HttpServletRequest)request).getSession().getAttribute("loginBean");
//		if(loginBean == null || loginBean.isLoggedIn() == false)
//		{
//			((HttpServletResponse) response).sendRedirect(((HttpServletRequest)request).getContextPath() + navigationBean.toLogin());
//		}else
//		{
//			String url = ((HttpServletRequest)request).getRequestURL().toString();
//			
//		
//			
//				if(loginBean.getUsuarioLogado().getClass() == Usuario.class){
//					
//					if(loginBean.getUsuarioLogado() != null){
//						
//					}
//					System.out.println("user");
//					((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + navigationBean.toMainUsuario());
//				}
//				
//				
//			}
//			
//		  chain.doFilter(request, response);
		}
		
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
