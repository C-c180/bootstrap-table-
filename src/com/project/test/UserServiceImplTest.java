package com.project.test;

import com.project.entity.UserEntity;
import com.project.service.IUserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImplTest {
    private IUserService iUserService=null;

    @Before
    public void setUp() throws Exception {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        iUserService= (IUserService) applicationContext.getBean("userServiceImpl");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void login() {
        UserEntity userEntity = iUserService.login("admin", "admin");
        System.out.println(userEntity);
    }
}