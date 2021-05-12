//package com.TaoYangyang.Filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter(filterName = "FrontEndAuthenticationFilter",value = "/*")
//public class FrontEndAuthenticationFilter implements Filter {
//
//    private HttpServletRequest httpRequest;
//    private static final String[] loginRequireURLs = {
//            "/updateUser","/logout","/myCart"
//    };
//
//    public void destroy() {
//    }
//
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        httpRequest = (HttpServletRequest) req;
//
//        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
//
//        if (path.startsWith("/admin/")){
//            chain.doFilter(req,resp);
//            return;
//        }
//
//        HttpSession session = httpRequest.getSession(false);
//
//        boolean isLoggedIn = (session != null && session.getAttribute("userList") != null);
//        String loginURI = httpRequest.getContextPath() + "/login";
//        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
//        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login");
//
//        if (isLoggedIn && (isLoginRequest || isLoginPage)){
//            httpRequest.getRequestDispatcher("/").forward(req,resp);
//        }else if (!isLoggedIn && isLoginRequired()){
//            String loginPage = "/login";
//            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginPage);
//            dispatcher.forward(req,resp);
//        }else {
//            chain.doFilter(req,resp);
//        }
//    }
//
//    private boolean isLoginRequired(){
//        String requestURL = httpRequest.getRequestURL().toString();
//        for (String loginRequireURL : loginRequireURLs) {
//            if (requestURL.contains(loginRequireURL))
//                return true;
//        }
//        return false;
//    }
//
//    public void init(FilterConfig config) throws ServletException {
//
//    }
//
//}
