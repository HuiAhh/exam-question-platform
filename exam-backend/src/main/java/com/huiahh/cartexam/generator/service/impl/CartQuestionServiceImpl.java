package com.huiahh.cartexam.generator.service.impl;

import com.huiahh.cartexam.generator.entity.Question;
import com.huiahh.cartexam.generator.entity.cart.Cart;
import com.huiahh.cartexam.generator.entity.cart.CartPage;
import com.huiahh.cartexam.generator.mapper.QuestionMapper;
import com.huiahh.cartexam.generator.service.CartQuestionService;
import com.huiahh.cartexam.generator.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service("questionService")
public class CartQuestionServiceImpl implements CartQuestionService {

    @Resource
    private RedisTemplate<String, Question> redisTemplate;

    @Autowired
    private QuestionService questionService;

    /**
     * 向购物车内新增一个题目
     * @param question
     * @param key
     * @return
     */
    @Override
    public int addCartQuestion(String key, Question question) {
        Boolean hasKey = redisTemplate.opsForHash().getOperations().hasKey(key);
        this.redisTemplate.opsForHash().put(key, question.getQuestionId() + "", question);
        if (!hasKey) {
            this.redisTemplate.expire(key, 90, TimeUnit.DAYS);
        }
        return 1;
    }

    /**
     * 实现部分更新题目
     * @param question 新数据
     * @param key 标识用户
     * @return
     */
    @Override
    public int updateCartQuestion(Question question, String key) {
        //step1 读取旧数据
        Question preQuestion = (Question) this.redisTemplate.opsForHash().get(key, question.getQuestionId().toString());
        //step2 实现部分更新
        if (preQuestion != null) {
            if (question.getName() != null) {
                preQuestion.setName(question.getName());
            }
            if (question.getOptiona() != null) {
                preQuestion.setOptiona(question.getOptiona());
            }
            if (question.getOptionb() != null) {
                preQuestion.setOptionb(question.getOptionb());
            }
            if (question.getOptionc() != null) {
                preQuestion.setOptionc(question.getOptionc());
            }
            if (question.getOptiond() != null) {
                preQuestion.setOptiond(question.getOptiond());
            }
            if (question.getType() != null) {
                preQuestion.setType(question.getType());
            }
            if (question.getKnowledgeId() != null) {
                preQuestion.setKnowledgeId(question.getKnowledgeId());
            }
            if (question.getAnswer() != null) {
                preQuestion.setAnswer(question.getAnswer());
            }
            if (question.getAnswerDetail() != null) {
                preQuestion.setAnswerDetail(question.getAnswerDetail());
            }
            if (question.getUserAnswer() != null) {
                preQuestion.setUserAnswer(question.getUserAnswer());
            }
            if (question.getCourseId() != null) {
                preQuestion.setCourseId(question.getCourseId());
            }
            if (question.getDifficulty() != null) {
                preQuestion.setDifficulty(question.getDifficulty());
            }
            // step3
            this.redisTemplate.opsForHash().put(key, preQuestion.getQuestionId() + "", preQuestion);
            return 1;
        }
        return 0;
    }

    /**
     * 删除购物车内的一条记录
     * @param key
     * @param questionId
     * @return
     */
    @Override
    public int delCartQuestion(String key, int questionId) {
        this.redisTemplate.opsForHash().delete(key, questionId + "");
        return 1;
    }

    /**
     * 查看购物车内的全部记录
     * @param
     * @return
     */
    @Override
    public CartPage findAll(String prefix, Long userId) {
        String key = prefix + userId;
        CartPage cartPage = new CartPage();
        //获取购物车内的题目总和
        long size = this.redisTemplate.opsForHash().size(key);
        cartPage.setAmount((int) size);
        //获取购物车内所有题目的key和value
        Map<Object, Object> map = this.redisTemplate.opsForHash().entries(key);
        List<Cart> cartList = new ArrayList<>();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " : " + entry.getValue().toString());
            //将每个cart封装到cartList中
            Cart cart = new Cart();
            cart.setUserId(userId);
            Question question = (Question) entry.getValue();
            cart.setQuestion(question);
            cartList.add(cart);
        }
        cartPage.setCartList(cartList);
        return cartPage;
    }


}
