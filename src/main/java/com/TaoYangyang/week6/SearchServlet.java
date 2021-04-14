package com.TaoYangyang.week6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "SearchServlet",value = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String txt =  URLEncoder.encode(request.getParameter("txt"), "UTF-8");
        String search = request.getParameter("search");
        if (txt.equals("")){
            response.sendRedirect("index.jsp");
        }else {
            if (search.equals("baidu")){
                response.sendRedirect("https://www.baidu.com/s?wd=" + txt);
            }else if (search.equals("bing")){
                response.sendRedirect("https://cn.bing.com/search?q=" + txt);
            }else if (search.equals("google")){
                response.sendRedirect("https://www.google.com/search?q=" + txt);
            }
        }
    }
}