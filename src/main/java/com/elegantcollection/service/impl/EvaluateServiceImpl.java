package com.elegantcollection.service.impl;

import com.elegantcollection.dao.EvaluateDao;
import com.elegantcollection.entity.Evaluate;
import com.elegantcollection.entity.EvaluateExample;
import com.elegantcollection.service.EvaluateService;
import com.elegantcollection.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Autowired
    private EvaluateDao evaluateDao;


    //    根据customerId 分页查询所有评论
    @Override
    public int countByCustomerId(Integer customerId) {
        EvaluateExample evaluateExample = new EvaluateExample();
        EvaluateExample.Criteria criteria = evaluateExample.createCriteria();
        criteria.andCustIdEqualTo(customerId);

        return (int) evaluateDao.countByExample(evaluateExample);
    }

    @Override
    public List<Evaluate> queryEvaluateByPage(PageModel pageModel, Integer customerId) {
        EvaluateExample evaluateExample = new EvaluateExample();
        EvaluateExample.Criteria criteria = evaluateExample.createCriteria();
        criteria.andCustIdEqualTo(customerId);
        evaluateExample.setLimit(pageModel.getPageSize());
        evaluateExample.setOffset((long) pageModel.getStartRecord());

        return evaluateDao.selectByExampleWithBLOBs(evaluateExample);
    }
}
