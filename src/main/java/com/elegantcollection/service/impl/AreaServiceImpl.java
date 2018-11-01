package com.elegantcollection.service.impl;

import com.elegantcollection.dao.AreaDao;
import com.elegantcollection.entity.Area;
import com.elegantcollection.entity.AreaExample;
import com.elegantcollection.service.Areaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AreaServiceImpl implements Areaservice {

    private AreaDao areaDao;
    @Autowired
    public void setAreaDao(AreaDao areaDao) {
        this.areaDao = areaDao;
    }

    /**
     * 实现插入到数据库里面
     *
     * @param area 传入的是Area对象
     * @return 返回受影响行数
     */
    @Override
    public int insertArea(Area area) {
        AreaExample example = new AreaExample();
        example.createCriteria();
        area.setName(area.getName());
        area.setParentId(area.getParentId());
        return areaDao.insert(area);

    }

    /**
     * 查询所有上级的id
     * @param parentId 上级id
     * @return 返回一个list
     */
    @Override
    public List<Area> queryAreaByParentId(int parentId) {
        // select * from area where parent_id =
        AreaExample example = new AreaExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        return areaDao.selectByExample(example);
    }

    @Override
    public Area queryByName(int id) {
        AreaExample example = new AreaExample();
        example.createCriteria().andIdEqualTo(id);
        return areaDao.selectByExample(example).get(0);
    }

}
