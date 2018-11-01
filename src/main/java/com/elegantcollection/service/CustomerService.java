package com.elegantcollection.service;

import com.elegantcollection.entity.Customer;

import java.util.List;


public interface CustomerService {

    /**
     * 根据用户邮箱,密码查找用户
     * @param email 用户邮箱
     * @param pwd 用户登录密码
     * @return 该用户对象
     */
    List<Customer> quaryCustomerByEmail(String email,String pwd);

    /**
     * 根据用户手机号和密码查找用户
     * @param phone 用户手机号
     * @param pwd 用户密码
     * @return 该用户对象
     */
    List<Customer> quaryCustomerByPhone(String phone,String pwd);

    /**
     * 添加用户
     * @param customer 用户对象
     * @return 数据库受影响行数
     */
    int addCustomer(Customer customer);

    /**
     * 根据用户名 查询数据库中是否有该用户
     * @param custName
     * @return
     */
    Long queryNumByCustName(String custName);

    /**
     * 根据用户id查询出 该用户的
     * @param custId 用户id
     * @return 用户详情(用户对象)
     */
    Customer quaryCustomerById(Integer custId);

    /**
     * 根据用户id 查找用户
     * @param custName 用户id
     * @return 用户对象
     */
    Customer quaryCustomerByCustName(String custName);

    /**
     * 根据用户绑定的手机号查找用户信息
     * @param phone 用户的手机号
     * @return 用户对象
     */
    List<Customer> queryCustomerByPhone(String phone);

    /**
     * 更改用户名
     * @param customer
     * @return
     */
    /**
     *根据customer对象跟新头像
     * @param customer 传进来是对象值
     * @return 返回受影响的函数
     */
    int  updataCustProfile(Customer customer);

    /**
     * 根据对象跟新用户名和性别
     * @param customer  传进来一个对象
     * @return  返回受影响函数
     */
    int  updataCustNameAndCustGender(Customer customer);


    /**
     * 根据电话号查找用户
     * @param custPhone 电话号
     * @return 用户对象
     */
    Customer queryByPhone(String custPhone);

    /**
     * 根据电话号码修改密码
     * @param custPassword 密码
     * @return
     */
    int alterByPhone(String custPhone,String custPassword);




}
