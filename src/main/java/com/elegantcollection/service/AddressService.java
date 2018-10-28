package com.elegantcollection.service;

import com.elegantcollection.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> queryAll(Integer addressId);

    List<Address> queryByAddressId(Integer addressId);
}
