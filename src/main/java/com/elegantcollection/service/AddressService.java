package com.elegantcollection.service;

import com.elegantcollection.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> queryByCustId(Integer custId);

    Address queryByAddressId(Integer addressId);

    /**
     * 根据页面传来数据添加一条地址记录
     * @param address  接收到一个地址对象
     * @return 返回受影响行数
     */

    int insertAddress(Address address);

    /**
     * 根据用户名id查询所有地址
     * @param custId 用户id
     * @return 返回一个地址对象
     */
    List<Address> queryByAddress(int custId);

    /**
     * 根据地址的id删除地址记录
     * @param address 地址的Id
     * @return 返回受影响行数
     */
    int deteleaddress(Address address);

    /**
     *跟局主键查询单个地址对象
     * @param addressId
     * @return 返回一个对象
     */
    Address queryByAdd(Integer addressId);

    /**
     * 修改地址
     * @param address 地址对象
     * @return 返回受影响行数
     */
    int updateadd(Address address);


}
