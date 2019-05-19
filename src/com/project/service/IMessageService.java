package com.project.service;

import com.project.entity.MessageEntity;
import org.springframework.data.domain.Page;

public interface IMessageService {
    public Page<MessageEntity> findAll(String username,int page,int size);
    public void addMessage(MessageEntity messageEntity);
    public void updateMessage(int id);
    public void deleteMessage(int id);
}
