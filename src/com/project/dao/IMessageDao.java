package com.project.dao;

import com.project.entity.MessageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface IMessageDao extends CrudRepository<MessageEntity,Integer> {
    public Page<MessageEntity> findAllByUsername(String username, Pageable pageable);
}
