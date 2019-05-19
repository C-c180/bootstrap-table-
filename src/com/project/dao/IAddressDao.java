package com.project.dao;

import com.project.entity.AddressEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface IAddressDao extends CrudRepository<AddressEntity,Integer> {
    public Page<AddressEntity> findAllByUsername(String username,Pageable pageable);
}
