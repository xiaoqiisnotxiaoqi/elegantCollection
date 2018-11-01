package com.elegantcollection.service.impl;

import com.elegantcollection.dao.AddressDao;
import com.elegantcollection.entity.Address;
import com.elegantcollection.entity.AddressExample;
import com.elegantcollection.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImp implements AddressService {
    private final AddressDao addressDao;


    @Autowired
    public AddressServiceImp(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public List<Address> queryByCustId(Integer custId) {
        AddressExample addressExample=new AddressExample();
        addressExample.createCriteria().andCustIdEqualTo(custId);
        return addressDao.selectByExample(addressExample);
    }

    @Override
    public Address queryByAddressId(Integer addressId) {
        return addressDao.selectByPrimaryKey(addressId);
    }

    @Override
    public int insertAddress(Address address) {
        AddressExample example = new AddressExample();
        example.createCriteria();
        return addressDao.insert(address);
    }

    @Override
    public List<Address> queryByAddress(int custId) {
        AddressExample example = new AddressExample();
        example.createCriteria().andCustIdEqualTo(custId).andAddressStatusEqualTo(0);
        return addressDao.selectByExample(example);
    }

    @Override
    public int deteleaddress(Address address) {
        AddressExample example = new AddressExample();
        example.createCriteria().andAddressIdEqualTo(address.getAddressId());
        return addressDao.updateByExampleSelective(address, example);
    }

    @Override
    public Address queryByAdd(Integer addressId) {
        AddressExample example = new AddressExample();
        example.createCriteria();
        return addressDao.selectByPrimaryKey(addressId);
    }

    @Override
    public int updateadd(Address address) {
        AddressExample example = new AddressExample();
        example.createCriteria().andAddressIdEqualTo(address.getAddressId());
        return addressDao.updateByExampleSelective(address,example);
    }
}
