package com.TaoYangyang.week3.controller;

import com.TaoYangyang.Dao.IUserDao;
import com.TaoYangyang.Dao.Impl.IUserDaoImpl;
import com.TaoYangyang.Model.User;
import com.TaoYangyang.Utils.jdbcUtil;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet(name = "RegisterServlet",value = "/register")
public class RegisterServlet extends HttpServlet {

    Connection con = null;

    @Override
    public void init() throws ServletException {
//        String driver = getServletConfig().getServletContext().getInitParameter("Driver");
//        String url = getServletConfig().getServletContext().getInitParameter("url");
//        String username = getServletConfig().getServletContext().getInitParameter("username");
//        String password = getServletConfig().getServletContext().getInitParameter("password");


//        String driver = (String) getServletContext().getAttribute("driver");
//        String url = (String) getServletContext().getAttribute("url");
//        String username = (String) getServletContext().getAttribute("username");
//        String password = (String) getServletContext().getAttribute("password");
//        jdbcUtil.getConnection(driver, url, username, password);

         con = (Connection) getServletContext().getAttribute("con");
    }


    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("Gender");
        String birth = request.getParameter("birth");
        User user = new User(null, username, password, email, gender, birth);

        PrintWriter pw = response.getWriter();
//        UserService userService = new UserServiceImpl();
        IUserDao iUserDao = new IUserDaoImpl();

        if ( iUserDao.saveUser(con,user) == 0 ){
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
            response.sendRedirect(request.getContextPath()+"/wee5/login.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("week2/register.jsp").forward(request,response);
    }
}
