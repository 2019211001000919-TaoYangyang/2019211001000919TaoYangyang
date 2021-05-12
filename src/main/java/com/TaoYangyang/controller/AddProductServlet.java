package com.TaoYangyang.controller;

import com.TaoYangyang.Dao.Impl.ProductDao;
import com.TaoYangyang.Model.Category;
import com.TaoYangyang.Model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author tyy
 * @version 1.0
 * @date 2021/5/12 21:34
 */
@WebServlet(name = "AddProductServlet",value = "/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215)
public class AddProductServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init(){
        con = (Connection) getServletContext().getAttribute("con");
    }


    @Override
    public void destroy() {
        super.destroy();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        Double price =  request.getParameter("price")!= null?Double.parseDouble(request.getParameter("price")):0.0;
        int categoryId = request.getParameter("categoryId")!=null?Integer.parseInt(request.getParameter("categoryId")):0;
        String productDescription = request.getParameter("productDescription");

        InputStream inputStream = null;
        Part picture = request.getPart("picture");

        if (picture != null){
            System.out.println("file name :" + picture.getName() + "size" + picture.getSize() + "file type" + picture.getContentType());
            inputStream = picture.getInputStream();
        }

        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setProductDescription(productDescription);
        product.setPicture(inputStream);
        product.setCategoryId(categoryId);

        ProductDao dao = new ProductDao();
        int i = 0;
        try{
            i = dao.save(product,con);
        }catch (SQLException e){
            e.printStackTrace();
        }

        if (i>0){
            request.getRequestDispatcher("/WEB-INF/views/admin/productList.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category = new Category();
        List<Category> categoryList = category.findAllCategory(con);
        request.setAttribute("categoryList",categoryList);
        request.getRequestDispatcher("/WEB-INF/views/admin/addProduct.jsp").forward(request,response);
    }
}
