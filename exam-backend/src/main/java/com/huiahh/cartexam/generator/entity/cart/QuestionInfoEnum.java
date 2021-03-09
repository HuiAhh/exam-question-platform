package com.huiahh.cartexam.generator.entity.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QuestionInfoEnum {

    NOT_EXISTS(100, "题目不存在");

    private Integer code;
    private String message;
}
