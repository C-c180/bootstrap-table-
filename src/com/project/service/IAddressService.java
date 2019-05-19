package com.project.service;

import com.project.entity.AddressEntity;
import org.springframework.data.domain.Page;

public interface IAddressService {
    public Page<AddressEntity> findAll(String username,int page,int size);
    public void addAddressEntity(AddressEntity addressEntity);
    public void deleteAddressEntity(int id);
    public void updateAddressEntiry(AddressEntity addressEntity);
    public AddressEntity findAddress(int id);
}
