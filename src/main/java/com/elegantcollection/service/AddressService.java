package com.elegantcollection.service;

import com.elegantcollection.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> queryByCustId(Integer custId);

    Address queryByAddressId(Integer addressId);
}
