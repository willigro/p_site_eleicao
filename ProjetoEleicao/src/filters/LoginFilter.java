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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import beans.LoginBean;

@WebFilter("/admin/*")
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession sessao = req.getSession();
				
		if(sessao == null || sessao.getAttribute("loginBean") == null 
		   || (((LoginBean) sessao.getAttribute("loginBean")).getUsuarioLogado()== null)){
			RequestDispatcher dis = request.getRequestDispatcher("/login.xhtml");
			dis.forward(request, response);
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
