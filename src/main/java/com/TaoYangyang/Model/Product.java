package com.TaoYangyang.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

/**
 * @author tyy
 * @version 1.0
 * @date 2021/5/12 20:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer productId;
    private Integer categoryId;
    private String productName;
    private String productDescription;
    private InputStream picture;
    private Double price;
}
