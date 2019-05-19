package com.project.controller;

import com.project.entity.UserEntity;
import com.project.service.IUserService;
import com.project.util.ResopnseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UserControlleer {
    @Autowired
    private IUserService iUserService;

    @RequestMapping("/userLogin")
    public ResopnseData login(UserEntity userEntity, HttpSession session){
        UserEntity entity = iUserService.login(userEntity.getUsername(), userEntity.getPassword());
        if (entity != null) {
            entity.setPassword("");
            session.setAttribute(session.getId(), entity);
            ResopnseData resopnseData=new ResopnseData();
            resopnseData.setCode(200);
            resopnseData.getData().put("user", userEntity);
            return resopnseData;
        }
        return ResopnseData.notFound();
    }
    @RequestMapping("/userReginter")
    public ResopnseData register(@Valid UserEntity userEntity, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            UserEntity username = iUserService.findUsername(userEntity.getUsername());
            ResopnseData resopnseData=new ResopnseData();
            resopnseData.setCode(404);
            if (username != null) {
                resopnseData.getData().put("username", "用户名已存在");
            }
            resopnseData.getData().put("errors", list);
            return resopnseData;
        }
        iUserService.addUser(userEntity);
        return ResopnseData.ok();
    }

    @RequestMapping("/exit")
    public ResopnseData exit(HttpSession session){
        session.invalidate();
        return ResopnseData.ok();
    }
}
