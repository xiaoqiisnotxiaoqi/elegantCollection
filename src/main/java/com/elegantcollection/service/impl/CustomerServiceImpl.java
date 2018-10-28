package com.elegantcollection.service.impl;

import com.elegantcollection.dao.CustomerDao;
import com.elegantcollection.entity.Customer;
import com.elegantcollection.entity.CustomerExample;
import com.elegantcollection.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    @Override
    public List<Customer> quaryCustomerByEmail(String email, String pwd) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCustMailEqualTo(email).andCustPasswordEqualTo(pwd);
        return customerDao.selectByExample(customerExample);
    }

    @Override
    public List<Customer> quaryCustomerByPhone(String phone, String pwd) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCustPhoneEqualTo(phone).andCustPasswordEqualTo(pwd);
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


}
