package com.xmut.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.xmut.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class HandlerIntercept implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3) throws Exception {
		
		//System.out.println("1.afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3) throws Exception {
		
		//System.out.println("1.postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		
		//System.out.println("1.preHandle");
		//获取请求URL
		StringBuffer url = request.getRequestURL();
		//判断URL是否是公开地址
		//这里的公开地址是登陆提交的地址
		if(url.indexOf("login.do")>=0){
			return true;//表示放行
		}
		//判断session
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null){
			//已登录
			System.out.println(user+":"+"用户已登录！");
			return true;
		} else {
			System.out.println(user+":"+"用户未登录！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);		
		}
		return false;
	}
}
