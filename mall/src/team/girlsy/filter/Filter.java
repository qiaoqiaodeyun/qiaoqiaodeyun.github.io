package team.girlsy.filter;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import team.girlsy.bean.Admin;
import team.girlsy.bean.Custom;
import team.girlsy.dao.AdminDao;
import team.girlsy.dao.CustomDao;
import team.girlsy.dao.impl.AdminDaoImpl;
import team.girlsy.dao.impl.CustomDaoImpl;

public class Filter implements javax.servlet.Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain cha) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//过滤字符集
		req.setCharacterEncoding("utf-8");//只对POST方法有用
		resp.setContentType("text/html;charset=utf-8");

		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		//判断是否记住过账号
		HttpSession session = request.getSession();
		
			if (null ==  session.getAttribute("exitLogin")&&(null == session.getAttribute("cookieLogined"))) {
				FilterCheckCookieLogin filterCheckCookieLogin = new FilterCheckCookieLogin();
				filterCheckCookieLogin.checkCookies(request, response);
			}
		
		//不能少，否则跳转之后不会出现页面的内容
		cha.doFilter(req, resp);
		}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
}
