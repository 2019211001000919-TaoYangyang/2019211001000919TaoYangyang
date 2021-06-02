package com.TaoYangyang.controller;

import com.TaoYangyang.Dao.IUserDao;
import com.TaoYangyang.Dao.Impl.IUserDaoImpl;
import com.TaoYangyang.Dao.Impl.OrderDao;
import com.TaoYangyang.Model.Order;
import com.TaoYangyang.Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author tyy
 * @version 1.0
 * @date 2021/6/2 15:47
 */
@WebServlet(name = "AccountDetailsServlet",value = "/accountDetails")
public class AccountDetailsServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init(){
        con = (Connection) getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("user") != null){
            User user = (User)session.getAttribute("user");
            int id = user.getId();
            IUserDao dao = new IUserDaoImpl();
            try{
                user = dao.findById(con,id);
                request.setAttribute("user",user);
                OrderDao orderDao = new OrderDao();
                List<Order> orderList = orderDao.findByUserId(con, id);
                request.setAttribute("orderList",orderList);
                request.getRequestDispatcher("/WEB-INF/views/accountDetails.jsp").forward(request,response);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }else {
            response.sendRedirect("login");
        }
    }
}
