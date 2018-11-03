package com.elegantcollection.service.impl;

import com.elegantcollection.dao.CustomerDao;
import com.elegantcollection.entity.Customer;
import com.elegantcollection.entity.CustomerExample;
import com.elegantcollection.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    @Override
    public List<Customer> quaryCustomerByEmail(String email) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCustMailEqualTo(email);
        return customerDao.selectByExample(customerExample);
    }

    @Override
    public List<Customer> quaryCustomerByPhone(String phone) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCustPhoneEqualTo(phone);
        return customerDao.selectByExample(customerExample);
    }

    @Override
    public int addCustomer(Customer customer) {

        return  customerDao.insert(customer);
    }

    @Override
    public Long queryNumByCustName(String custName) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCustNameEqualTo(custName);
        return customerDao.countByExample(customerExample);
    }

    @Override
    public Customer quaryCustomerById(Integer custId) {
        return customerDao.selectByPrimaryKey(custId);
    }

    @Override
    public Customer quaryCustomerByCustName(String custName) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCustNameEqualTo(custName);
        return customerDao.selectByExample(customerExample).get(0);
    }

    @Override
    public List<Customer> queryCustomerByPhone(String phone) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCustPhoneEqualTo(phone);
        return  customerDao.selectByExample(customerExample);


    }


    @Override
    public int updataCustProfile(Customer customer) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCustIdEqualTo(customer.getCustId());

        return customerDao.updateByExampleSelective(customer,customerExample);

    }

    @Override
    public int updataCustNameAndCustGender(Customer customer) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCustIdEqualTo(customer.getCustId());
        return customerDao.updateByExampleSelective(customer,customerExample);


    }

    @Override
    public Customer queryByPhone(String custPhone) {
        return customerDao.selectByPhone(custPhone);
    }

    @Override
    public int alterByPhone(String custPhone, String custPassword) {
        Map<String ,Object> args = new HashMap<>();
        args.put("custPhone",custPhone);
        args.put("custPassword",custPassword);
        int t = customerDao.updateByPhone(args);
        return t;
    }

    @Override
    public List<Customer> queryAllCust() {
        CustomerExample customerExample = new CustomerExample();
        List<Customer> customerList = customerDao.selectByExample(customerExample);
        return customerList;
    }

    @Override
    public Integer updateCustomer(Customer customer) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCustIdEqualTo(customer.getCustId());
        return customerDao.updateByExample(customer,customerExample);
    }


}
