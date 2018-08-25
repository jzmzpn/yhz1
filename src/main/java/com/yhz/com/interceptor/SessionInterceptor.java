package com.yhz.com.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yhz.com.core.ProjectConstant;

public class SessionInterceptor implements HandlerInterceptor {
	
	@Autowired
	private HttpSession session;
	
	private static Set<String> whiteUrl = new HashSet<String>();
	
	static {
		whiteUrl.add("/yhz/login");
	}
	
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if(whiteUrl.contains(request.getRequestURI())) {
        	return true;
        }
        if(session.getAttribute(ProjectConstant.SESSION_KEY) != null) {
        	return true;
        }
        response.sendRedirect("login");
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}