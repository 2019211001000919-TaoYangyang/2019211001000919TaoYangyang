package com.TaoYangyang.week2.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "HelloServlet",value = "/hello")    //Replace XML with annotations
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.write("<h1>Name: Tao Yangyang</h1>");
        pw.write("<h1>Id: 2019211001000919</h1>");
        pw.write("<h1>"+String.valueOf(new Date())+"</h1>");
    }
}
