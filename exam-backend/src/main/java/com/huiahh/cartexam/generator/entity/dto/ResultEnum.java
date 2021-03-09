package com.huiahh.cartexam.generator.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
/**
 * 操作结果状态
 */
public enum ResultEnum {

    FAIL(0, "失败"),
    SUCCESS(200, "成功"),
    PARAM_ERROR(300, "参数错误");

    private Integer code;
    private String message;



}
