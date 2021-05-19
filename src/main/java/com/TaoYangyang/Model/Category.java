package com.TaoYangyang.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author tyy
 * @version 1.0
 * @date 2021/5/12 21:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    private int categoryId;
    private String categoryName;
    private String description;
    private Boolean active;

    public static List<Category> findAllCategory(Connection con){
        QueryRunner qr = new QueryRunner();
        try {
            return qr.query(con,"select * from Category",new BeanListHandler<>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String findByCategoryId(Connection con,int categoryId){
        System.out.println("findName");
        QueryRunner qr = new QueryRunner();
        String categoryName = null;
        try {
            String sql = "select CategoryName from Category where CategoryID = " + categoryId;
            Category query = qr.query(con, sql, new BeanHandler<>(Category.class));
            categoryName = query.getCategoryName();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryName;
    }
}
