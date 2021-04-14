package com.TaoYangyang.week5;

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

@WebServlet(name = "LoginController",value = "/login")
public class LoginController extends HttpServlet {

    Connection con = null;

    @Override
    public void init() throws ServletException {
//        String driver = getServletConfig().getServletContext().getInitParameter("Driver");
//        String url = getServletConfig().getServletContext().getInitParameter("url");
//        String username = getServletConfig().getServletContext().getInitParameter("username");
//        String password = getServletConfig().getServletContext().getInitParameter("password");
//        jdbcUtil.getConnection(driver, url, username, password);


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


        //The userservice of week3 is called here
        UserService userService = new UserServiceImpl();


        PrintWriter pw = response.getWriter();
        User user = iUserDao.findByUsernamePassword(con,username, password);
        if ( user != null){

            request.setAttribute("user",user);
            request.getRequestDispatcher("userInfo.jsp").forward(request,response);
//            pw.write("<h1>Login Success!</h1>");
//            pw.write("<h1>Welcome：" + username + "<h1>");

        }else {
            request.setAttribute("msg","username or password Error!");
            request.getRequestDispatcher( "/week5/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher( "WEB-INF/views/login.jsp").forward(request,response);
    }
}
