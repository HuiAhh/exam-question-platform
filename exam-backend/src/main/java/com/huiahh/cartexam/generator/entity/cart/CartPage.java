package com.huiahh.cartexam.generator.entity.cart;


import lombok.Data;
import java.util.List;

@Data
public class CartPage<T> {

    private List<T> cartList;
    private int amount;

}
