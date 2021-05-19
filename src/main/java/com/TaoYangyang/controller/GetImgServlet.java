package com.TaoYangyang.controller;

import com.TaoYangyang.Dao.Impl.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author tyy
 * @version 1.0
 * @date 2021/5/19 13:58
 */
@WebServlet(name = "GetImgServlet",value = "/getImg")
public class GetImgServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init(){
        con = (Connection) getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("img");
        response.setContentType("text/html");
        ProductDao productDao = new ProductDao();
        int id = 0;
        if (request.getParameter("id") != null){
            id = Integer.parseInt(request.getParameter("id"));
        }
        try {
            byte[] imgByte = new byte[0];
            imgByte = productDao.getPictureById(id,con);
            if (imgByte != null){
                response.setContentType("image/gif");
                OutputStream os = response.getOutputStream();
                os.write(imgByte);
                os.flush();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
