package com.TaoYangyang.controller;

import com.TaoYangyang.Dao.IUserDao;
import com.TaoYangyang.Dao.Impl.IUserDaoImpl;
import com.TaoYangyang.Model.User;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "UpdateUserServlet",value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init(){
        con = (Connection) getServletContext().getAttribute("con");
    }

    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birth = request.getParameter("birth");
        User user = new User(id, username, password, email, gender, birth);

        IUserDao iUserDao = new IUserDaoImpl();
        int i = iUserDao.updateUser(con, user);
        if (i != 0){
            request.getSession().setAttribute("user",iUserDao.findById(con,id));
//            request.getRequestDispatcher( "WEB-INF/views/userInfo.jsp").forward(request,response);
            response.sendRedirect("accountDetails");
        }else {
            request.setAttribute("message","update Error!");
            request.getRequestDispatcher( "WEB-INF/views/userInfo.jsp").forward(request,response);
        }

    }

    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserDao iUserDao = new IUserDaoImpl();
        Integer id = Integer.valueOf(request.getParameter("id"));
        User userInfo = iUserDao.findById(con, id);
        request.setAttribute("userInfo",userInfo);
        request.getRequestDispatcher( "WEB-INF/views/updateUser.jsp").forward(request,response);
    }
}
