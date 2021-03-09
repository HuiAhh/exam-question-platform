package com.huiahh.cartexam.generator.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @author: SheledonPeng
 * @Date: $
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultBean<T> implements Serializable {

    private String message;
    private Integer code;
    //数据
    private T data;

    public ResultBean(T data) {
        this.data = data;
    }

    /**
     * 操作成功但不返回数据
     * @param msg
     * @param code
     */
    public ResultBean(String msg, Integer code) {
        this.message = msg;
        this.code = code;
    }


    /**
     * 操作成功，返回数据
     * @param code
     * @param data
     */
    public ResultBean(Integer code, T data, String message){
        this.code = code;
        this.data = data;
        this.message = message;
    }

    /**
     * 操作成功 但不返回数据
     * @return
     */
    public static ResultBean success() {
        return new ResultBean(ResultEnum.SUCCESS.getMessage(), ResultEnum.SUCCESS.getCode());
    }

    /**
     * 操作成功并返回数据
     * @param data
     * @return
     */
    public ResultBean success(T data) {
        return new ResultBean(ResultEnum.SUCCESS.getMessage(), ResultEnum.SUCCESS.getCode(), data);
    }

    /**
     * 操作失败
     * @return
     */
    public static ResultBean fail() {
        return new ResultBean(ResultEnum.FAIL.getMessage(), ResultEnum.FAIL.getCode());
    }

}
