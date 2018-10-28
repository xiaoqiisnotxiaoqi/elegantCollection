package com.elegantcollection.service;

import com.elegantcollection.entity.Evaluate;
import com.elegantcollection.util.PageModel;

import java.util.List;

public interface EvaluateService {
    //    根据用户ID分页查询出所有评价
    int countByCustomerId(Integer customerId);

    List<Evaluate> queryEvaluateByPage(PageModel pageModel, Integer customerId);
}
