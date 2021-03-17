package com.TaoYangyang.week3.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet",value = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int gender_db = Integer.parseInt(request.getParameter("Gender"));
        String birth = request.getParameter("birth");

        PrintWriter pw = response.getWriter();
        pw.write("<h1>username: " + username + "</h1>");
        pw.write("<h1>password: " + password + "</h1>");
        pw.write("<h1>email: " + email + "</h1>");
        String gender = gender_db==1?"Male":"Female";
        pw.write("<h1>gender: " + gender + "</h1>");
        pw.write("<h1>birth: " + birth + "</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
