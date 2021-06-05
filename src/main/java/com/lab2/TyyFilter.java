package com.lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author tyy
 * @version 1.0
 * @date 2021/6/5 13:18
 */
@WebFilter(filterName = "TyyFilter")
public class TyyFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("TyyFilter -- before chain");
        chain.doFilter(req, resp);
        System.out.println("TyyFilter -- after chain");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
