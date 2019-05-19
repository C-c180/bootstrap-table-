package com.project.test;

import com.project.entity.MessageEntity;
import com.project.service.IMessageService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;

public class MessageServiceImplTest {
    IMessageService iMessageService=null;
    @Before
    public void setUp() throws Exception {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        iMessageService = (IMessageService) applicationContext.getBean("messageServiceImpl");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findAll() {
        Page<MessageEntity> page = iMessageService.findAll("admin", 1, 6);
        System.out.println(page);
    }

    @Test
    public void addMessage() {
        MessageEntity messageEntity=new MessageEntity();
        messageEntity.setMessage("111");
        messageEntity.setSender("admin");
        messageEntity.setSendtime("2019-5-13");
        messageEntity.setUsername("admin");
        iMessageService.addMessage(messageEntity);
    }

    @Test
    public void updateMessage() {
        iMessageService.updateMessage(20);
    }
}