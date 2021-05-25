package com.TaoYangyang.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author tyy
 * @version 1.0
 * @date 2021/5/25 20:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {
    private Product product;
    private int quantity;
}
