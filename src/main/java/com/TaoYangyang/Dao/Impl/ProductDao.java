package com.TaoYangyang.Dao.Impl;

import com.TaoYangyang.Dao.IProductDao;
import com.TaoYangyang.Model.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductDao implements IProductDao {

    QueryRunner qr =  new QueryRunner();

    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,Price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
//            pt.setBinaryStream(3, product.getPicture());
            //for mysql
               pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        String sql = "delete from product where ProductId = ?";
        return qr.update(con,sql,new Object[]{productId});
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        String sql = "update product set ProductName = ?,ProductDescription = ?,Price = ?,CategoryID = ? where ProductId = ?";
        return qr.update(con,sql,new Object[]{instance.getProductName(),instance.getProductDescription(),instance.getPrice(),instance.getCategoryId(),instance.getProductId()});
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String sql = "select * from product where ProductId="+productId;
        return qr.query(con,sql,new BeanHandler<>(Product.class));

    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        String sql = "select * from product where CategoryId="+categoryId;
        return qr.query(con,sql,new BeanListHandler<>(Product.class));

    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        String sql = "select * from product where Price between "+minPrice+" and "+maxPrice;
        return qr.query(con,sql,new BeanListHandler<>(Product.class));
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        String sql = "select * from product";
        return qr.query(con,sql,new BeanListHandler<>(Product.class));

    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        String sql = "select * from product where ProductName="+productName;
        return qr.query(con,sql,new BeanListHandler<>(Product.class));
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        String sql = "select ProductId,Picture from product where ProductName = " + productId;
        return qr.query(con,sql,new BeanListHandler<>(Product.class));
    }
}
