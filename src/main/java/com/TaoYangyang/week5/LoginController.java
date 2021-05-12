package com.TaoYangyang.week5;

import com.TaoYangyang.Dao.IUserDao;
import com.TaoYangyang.Dao.Impl.IUserDaoImpl;
import com.TaoYangyang.Model.User;
import com.TaoYangyang.Utils.jdbcUtil;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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

            if (request.getParameter("remember") != null && request.getParameter("remember").equals("1")){
                Cookie cUsername = new Cookie("cUsername", user.getUsername());
                Cookie cPassword = new Cookie("cPassword", user.getPassword());
                Cookie cRemmberMeVal = new Cookie("cRememberMe", request.getParameter("remember"));

                cUsername.setMaxAge(15*24*60*60);
                cPassword.setMaxAge(15*24*60*60);
                cRemmberMeVal.setMaxAge(15*24*60*60);

                response.addCookie(cUsername);
                response.addCookie(cPassword);
                response.addCookie(cRemmberMeVal);
            }

            request.setAttribute("user",user);
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(7*24*60*60);
            session.setAttribute("user",user);

//            Cookie cookie = new Cookie("sessionId","" + user.getId());
//            cookie.setMaxAge(7*24*60*60);
//            response.addCookie(cookie);
//            request.setAttribute("user",user);

            request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
//            pw.write("<h1>Login Success!</h1>");
//            pw.write("<h1>Welcome：" + username + "<h1>");

        }else {
            request.setAttribute("message","username or password Error!");
            request.getRequestDispatcher( "WEB-INF/views/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher( "WEB-INF/views/login.jsp").forward(request,response);
    }
}
