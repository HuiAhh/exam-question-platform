package com.huiahh.cartexam.generator.entity.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
/**
 * 购物车状态信息
 */
public enum CartInfoEnum {

    IS_EMPTY(250, "购物车空空如也"),
    IS_CHECKED(1, "选中购物车"),
    NOT_CHECKD(0, "没有选中购物车");

    private Integer code;
    private String message;

}

