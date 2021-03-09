package com.huiahh.cartexam.generator.controller;

import com.huiahh.cartexam.generator.entity.Question;
import com.huiahh.cartexam.generator.entity.cart.Cart;
import com.huiahh.cartexam.generator.entity.cart.CartInfoEnum;
import com.huiahh.cartexam.generator.entity.cart.CartPage;
import com.huiahh.cartexam.generator.entity.cart.QuestionInfoEnum;
import com.huiahh.cartexam.generator.entity.dto.ResultBean;
import com.huiahh.cartexam.generator.service.CartQuestionService;
import com.huiahh.cartexam.generator.service.CategoryService;
import com.huiahh.cartexam.generator.service.QuestionService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/generator/api/v1/question")
@Api(tags = "对题目购物车的操作")
@Slf4j
public class CartQuestionController {

    //题目表的接口
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CartQuestionService cqS;
    @Resource
    private RedisTemplate<String, Question> redisTemplate;
    //购物车的前缀
    public static final String pre_fix = "cart:question:";

    /**
     * 新增题目
     * @return
     */
    @PostMapping(value = "/addQuestion")
    public ResultBean addQuestion (Long userId, int questionId) {
        String key = pre_fix + userId;
        Question question = questionService.getQuestionById(questionId);
        //如果题目不存在
        if (question == null) {
            return new ResultBean(QuestionInfoEnum.NOT_EXISTS.getMessage(), QuestionInfoEnum.NOT_EXISTS.getCode());
        }
        if (cqS.addCartQuestion(key, question) == 1) {
            return ResultBean.success();
        } else {
            return ResultBean.fail();
        }
    }

    /**
     * 部分更新题目
     * @param cart
     * @return
     */
    @PutMapping(value = "/updateQuestion")
    public ResultBean updateQuestion (Cart cart) {
        String key = pre_fix + cart.getUserId();
        Question question = cart.getQuestion();
        //判断题目是否存在
        if (questionService.getQuestionById(question.getQuestionId()) == null) {
            return new ResultBean(QuestionInfoEnum.NOT_EXISTS.getMessage(), QuestionInfoEnum.NOT_EXISTS.getCode());
        }
        //调用cqS接口进行部分更新
        if (cqS.updateCartQuestion(question, key) == 1) {
            return ResultBean.success();
        } else {
            return ResultBean.fail();
        }
    }

    /**
     * 删除购物车内的一个题目
     * @param
     * @return
     */
    @DeleteMapping(value = "/delCartQuestion")
    public ResultBean delCartQuestion(long userId, int questionId) {
        String key = pre_fix + userId;
        long size = this.redisTemplate.opsForHash().size(key);
        //判断购物车内是否为空
        if (size == 0) {
            return new ResultBean(CartInfoEnum.IS_EMPTY.getMessage(), CartInfoEnum.IS_EMPTY.getCode());
        }
        //判断要删除的题目是否存在
        if (questionService.getQuestionById(questionId) == null) {
            return new ResultBean(QuestionInfoEnum.NOT_EXISTS.getMessage(), QuestionInfoEnum.NOT_EXISTS.getCode());
        }
        //调用cqS接口进行删除
        if (cqS.delCartQuestion(key, questionId) == 1) {
            return ResultBean.success();
        } else {
            return ResultBean.fail();
        }
    }

    /**
     * 查看购物车内的所有记录
     * @return
     */
    @GetMapping(value = "/findAll")
    public ResultBean findAll(Long userId) {
        String key = pre_fix + userId;
        //判断购物车是否为空
        if (this.redisTemplate.opsForHash().size(key) == 0) {
            return new ResultBean(CartInfoEnum.IS_EMPTY.getMessage(), CartInfoEnum.IS_EMPTY.getCode());
        }
        CartPage cartPage = cqS.findAll(pre_fix, userId);
        if (cartPage != null) {
            ResultBean resultBean = new ResultBean();
            return resultBean.success(cartPage);
        } else {
            return ResultBean.fail();
        }
    }


}
