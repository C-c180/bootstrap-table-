package com.project.service;

import com.project.entity.UserEntity;

public interface IUserService {
    public UserEntity login(String username,String password);
    public void addUser(UserEntity userEntity);
    public UserEntity findUsername(String username);
}
