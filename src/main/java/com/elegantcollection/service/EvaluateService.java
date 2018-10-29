package com.elegantcollection.service;

import com.elegantcollection.entity.Evaluate;
import com.elegantcollection.util.PageModel;

import java.util.List;

public interface EvaluateService {
    /**
     * 根据用户ID查询出该用户所有评价
     *
     * @param customerId 用户ID
     * @return 数量
     */
    int countByCustomerId(Integer customerId);


    /**
     * 根据用户ID查询出该用户所有评价
     *
     * @param pageModel  pagemodel
     * @param customerId 用户ID
     * @return 评价集合
     */
    List<Evaluate> queryEvaluateByPage(PageModel pageModel, Integer customerId);
}
