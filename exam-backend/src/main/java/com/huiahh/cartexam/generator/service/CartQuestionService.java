package com.huiahh.cartexam.generator.service;

import com.huiahh.cartexam.generator.entity.Question;
import com.huiahh.cartexam.generator.entity.cart.CartPage;

/**
 * 题目购物车接口
 */
public interface CartQuestionService {

    /**
     * 向购物车新增一个题目
     * @param question
     * @param key
     * @return
     */
    int addCartQuestion (String key, Question question);

    /**
     * 部分更新购物车内的题目
     * @param question
     * @param key
     * @return
     */
    int updateCartQuestion (Question question, String key);

    /**
     * 删除购物车内的题目
     * @param key
     * @param questionId
     * @return
     */
    int delCartQuestion (String key, int questionId);

    /**
     * 查看购物车内的全部记录
     * @param
     * @return
     */
    CartPage findAll(String prefix, Long userId);
}
