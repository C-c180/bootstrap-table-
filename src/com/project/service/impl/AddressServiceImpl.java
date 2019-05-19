package com.project.service.impl;

import com.project.dao.IAddressDao;
import com.project.entity.AddressEntity;
import com.project.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private IAddressDao iAddressDao;
    @Override
    public Page<AddressEntity> findAll(String username,int page, int size) {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Page<AddressEntity> pages = iAddressDao.findAllByUsername(username,new PageRequest(page-1, size,new Sort(order)));
        List<AddressEntity> list = pages.getContent();
        return pages;
    }

    @Override
    public void addAddressEntity(AddressEntity addressEntity) {
        iAddressDao.save(addressEntity);
    }

    @Override
    public void deleteAddressEntity(int id) {
        iAddressDao.delete(id);
    }

    @Override
    public void updateAddressEntiry(AddressEntity addressEntity) {
        AddressEntity entity = iAddressDao.findOne(addressEntity.getId());
        entity.setName(addressEntity.getName());
        entity.setMobile(addressEntity.getMobile());
        entity.setPostcode(addressEntity.getPostcode());
        entity.setQq(addressEntity.getQq());
        entity.setSex(addressEntity.getSex());
        entity.setAddress(addressEntity.getAddress());
        entity.setCompany(addressEntity.getCompany());
        entity.setEmail(addressEntity.getEmail());
        iAddressDao.save(addressEntity);
    }

    @Override
    public AddressEntity findAddress(int id) {
        AddressEntity addressEntity = iAddressDao.findOne(id);
        return addressEntity;
    }
}
