package com.project.service.impl;

import com.project.dao.IUserDao;
import com.project.entity.UserEntity;
import com.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao iUserDao;
    @Override
    public UserEntity login(String username, String password) {
        return iUserDao.findByUsernameAndPassword(username, password);
    }

    @Override
    public void addUser(UserEntity userEntity) {
        iUserDao.save(userEntity);
    }

    @Override
    public UserEntity findUsername(String username) {
        UserEntity userEntity = iUserDao.findByUsername(username);
        return userEntity;
    }
}
