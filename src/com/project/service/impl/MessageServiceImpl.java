package com.project.service.impl;

import com.project.dao.IMessageDao;
import com.project.entity.MessageEntity;
import com.project.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageServiceImpl implements IMessageService {
    @Autowired
    private IMessageDao iMessageDao;
    @Override
    public Page<MessageEntity> findAll(String username,int page,int size) {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Page<MessageEntity> pages = iMessageDao.findAllByUsername(username, new PageRequest(page - 1, size,new Sort(order)));
        return pages;
    }

    @Override
    public void addMessage(MessageEntity messageEntity) {
        iMessageDao.save(messageEntity);
    }

    @Override
    public void updateMessage(int id) {
        MessageEntity messageEntity = iMessageDao.findOne(id);
        messageEntity.setIsRead("已读");
    }

    @Override
    public void deleteMessage(int id) {
        iMessageDao.delete(id);
    }
}
