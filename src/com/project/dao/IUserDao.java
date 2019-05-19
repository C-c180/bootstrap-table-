package com.project.dao;

import com.project.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<UserEntity,Integer> {
    public UserEntity findByUsernameAndPassword(String username, String password);
    public UserEntity findByUsername(String username);
}
