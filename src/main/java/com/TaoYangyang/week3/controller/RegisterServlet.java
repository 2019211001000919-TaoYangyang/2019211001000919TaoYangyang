package com.TaoYangyang.week3.controller;

import com.TaoYangyang.week3.Pojo.User;
import com.TaoYangyang.week3.Service.Impl.UserServiceImpl;
import com.TaoYangyang.week3.Service.UserService;
import com.TaoYangyang.week3.Utils.jdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "RegisterServlet",value = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        String driver = getServletConfig().getServletContext().getInitParameter("Driver");
        String url = getServletConfig().getServletContext().getInitParameter("url");
        String username = getServletConfig().getServletContext().getInitParameter("username");
        String password = getServletConfig().getServletContext().getInitParameter("password");
        jdbcUtil.getConnection(driver, url, username, password);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("Gender");
        String birth = request.getParameter("birth");
        User user = new User(null, username, password, email, gender, birth);

        PrintWriter pw = response.getWriter();
        UserService userService = new UserServiceImpl();
        if ( userService.addUser(user) == 0 ){
            pw.write("<h1>Insert error</h1>!");
        }else {
//            List<User> allUser = userService.findAllUser();
//            pw.write("<table border='1' style='text-align: center;'>");
//            pw.write("<td>number</td>");
//            pw.write("<td>username</td>");
//            pw.write("<td>password</td>");
//            pw.write("<td>email</td>");
//            pw.write("<td>gender</td>");
//            pw.write("<td>birth</td>");
//            pw.write("<td colspan = 2>operation</td>");
//            for (int i = 0; i < allUser.size(); i++) {
//                pw.write("<tr>");
//                pw.write("<td>"+ (i+1) + "</td>");
//                pw.write("<td>"+ allUser.get(i).getUsername() +"</td>");
//                pw.write("<td>"+ allUser.get(i).getPassword() +"</td>");
//                pw.write("<td>"+ allUser.get(i).getEmail() +"</td>");
//                pw.write("<td>"+ allUser.get(i).getGender() +"</td>");
//                pw.write("<td>"+ allUser.get(i).getBirth() +"</td>");
//                pw.write("<td><a href='#' >Delete</a></td>");
//                pw.write("<td><a href='#' >Update</a></td>");
//                pw.write("</tr>");
//            }
//            pw.write("</table>");
            response.sendRedirect("login.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
