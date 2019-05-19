package com.project.controller;

import com.project.entity.MessageEntity;
import com.project.entity.UserEntity;
import com.project.service.IMessageService;
import com.project.util.ResopnseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private IMessageService iMessageService;
    @RequestMapping("/message/get")
    public ResopnseData getMesssage(int page, int size, HttpSession session){
        UserEntity userEntity = (UserEntity) session.getAttribute(session.getId());
        Page<MessageEntity> pages = iMessageService.findAll(userEntity.getUsername(), page, size);
        ResopnseData resopnseData=new ResopnseData();
        resopnseData.setCode(200);
        resopnseData.getData().put("message", pages);
        return resopnseData;
    }

    @RequestMapping("/message/add")
    public ResopnseData addMessage(@Valid MessageEntity messageEntity, BindingResult bindingResult, HttpSession session){
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            for (ObjectError objectError : list) {
                System.out.println(objectError.getDefaultMessage());
            }
            ResopnseData resopnseData=new ResopnseData();
            resopnseData.setCode(404);
            resopnseData.getData().put("errors", list);
            return resopnseData;
        }
        UserEntity userEntity = (UserEntity) session.getAttribute(session.getId());
        messageEntity.setSender(userEntity.getUsername());
        iMessageService.addMessage(messageEntity);
        return ResopnseData.ok();
    }
    @RequestMapping("/message/update")
    public ResopnseData updateMessage(int id){
        iMessageService.updateMessage(id);
        return ResopnseData.ok();
    }
    @RequestMapping("/message/delete")
    public ResopnseData deleteMessage(int id){
        iMessageService.deleteMessage(id);
        return ResopnseData.ok();
    }
}
