package com.huiahh.cartexam.generator.entity.cart;


import com.huiahh.cartexam.generator.entity.Question;
import lombok.Data;

@Data
/**
 * 购物车
 */
public class Cart {

    private Long userId;
    private Question question;

}
