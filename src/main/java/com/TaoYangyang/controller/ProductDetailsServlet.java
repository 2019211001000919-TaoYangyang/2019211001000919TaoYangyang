package com.TaoYangyang.controller;

import com.TaoYangyang.Dao.Impl.ProductDao;
import com.TaoYangyang.Model.Category;
import com.TaoYangyang.Model.Product;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 * @author tyy
 * @version 1.0
 * @date 2021/5/19 15:29
 */
@WebServlet(name = "ProductDetailsServlet",value = "/productDetails")
public class ProductDetailsServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init(){
        con = (Connection) getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")):0;
        ProductDao productDao = new ProductDao();

        if (id == 0){
            return;
        }

        List<Category> categoryList = Category.findAllCategory(con);
        request.setAttribute("categoryList",categoryList);

        Product product = productDao.findById(id, con);
        request.setAttribute("p",product);
        request.getRequestDispatcher("/WEB-INF/views/productDetails.jsp").forward(request,response);
    }
}
