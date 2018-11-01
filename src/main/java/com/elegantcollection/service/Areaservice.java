package com.elegantcollection.service;

import com.elegantcollection.entity.Area;

import java.util.List;

public interface Areaservice {

    /**
     * 向Area表插入省市区
     * @param area  传入的是Area对象
     * @return  返回受影响函数
     */
    int insertArea(Area area);

    /**
     *根据 parentId 得到相应的省市区
     * @param parentId 上级id
     * @return 返回一个集合
     */
    List<Area> queryAreaByParentId(int parentId);

    /**
     *根据id查询 地址name的
     * @param id 传入的id
     * @return 返回对象Area对象
     */
    Area queryByName(int id);
}
