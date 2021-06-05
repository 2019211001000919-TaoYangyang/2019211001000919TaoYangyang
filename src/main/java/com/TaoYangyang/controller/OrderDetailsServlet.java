package com.TaoYangyang.controller;

import com.TaoYangyang.Dao.Impl.OrderDao;
import com.TaoYangyang.Model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;

/**
 * @author tyy
 * @version 1.0
 * @date 2021/6/2 16:07
 */
@Log4j
@WebServlet(name = "OrderDetailsServlet ",value = "/orderDetails")
public class OrderDetailsServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init(){
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    public void destroy() {
        super.destroy();
        log.info("destroy");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = request.getParameter("orderId") != null ? Integer.parseInt(request.getParameter("orderId")) : 0;
        Item item = new Item();
        OrderDao dao = new OrderDao();
        List<Item> items = dao.findItemsByOrderId(con, orderId);
        log.info(item.toString());
        request.setAttribute("itemList",items);
        String path = "orderDetails.jsp";
        log.info(path);
        request.getRequestDispatcher(path).forward(request,response);
    }
}
