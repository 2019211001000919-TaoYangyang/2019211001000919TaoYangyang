package com.TaoYangyang.week4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConfigDemoServlet",value = "/config",
initParams = {
        @WebInitParam(name = "name",value = "TaoYangyang"),
        @WebInitParam(name = "studentId",value = "2019211001000919"),
})
public class ConfigDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name =getServletConfig().getInitParameter("name");
        String studentId = getServletConfig().getInitParameter("studentId");

        PrintWriter pw = response.getWriter();
        pw.write("<h1>name: "+ name+"</h1>");
        pw.write("<h1>studentId: : "+ studentId+"</h1>");
    }
}
