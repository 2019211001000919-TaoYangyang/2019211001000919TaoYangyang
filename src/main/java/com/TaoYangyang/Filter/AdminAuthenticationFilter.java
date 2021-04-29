package com.TaoYangyang.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminAuthenticationFilter",value = "/admin/*")
public class AdminAuthenticationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        HttpSession session = httpServletRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("user") != null);

        String loginURI = httpServletRequest.getRequestURI() + "/admin/login";

        boolean isLoginRequest = httpServletRequest.getRequestURI().equals(loginURI);

        boolean isLoginPage = httpServletRequest.getRequestURI().endsWith("login.jsp");

        if (isLoggedIn && (isLoginRequest || isLoginPage)){
            RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/home");
            dispatcher.forward(req,resp);
        }else if (isLoggedIn || isLoginRequest){
            chain.doFilter(req,resp);
        }else {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+ "/admin/login");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
