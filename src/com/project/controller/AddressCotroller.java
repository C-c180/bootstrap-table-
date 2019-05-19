package com.project.controller;

import com.project.entity.AddressEntity;
import com.project.entity.UserEntity;
import com.project.service.IAddressService;
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
public class AddressCotroller {
    @Autowired
    private IAddressService iAddressService;
    @RequestMapping("/address/get")
    public ResopnseData getAddress(int page, int size, HttpSession session){
        System.out.println("ok");
        UserEntity userEntity = (UserEntity) session.getAttribute(session.getId());
        Page<AddressEntity> pages = iAddressService.findAll(userEntity.getUsername(), page, size);
        ResopnseData resopnseData=new ResopnseData();
        resopnseData.setCode(200);
        resopnseData.getData().put("address", pages);
        return resopnseData;
    }

    @RequestMapping("/address/add")
    public ResopnseData addAddess(@Valid AddressEntity addressEntity, BindingResult bindingResult, HttpSession session){
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
        addressEntity.setUsername(userEntity.getUsername());
        iAddressService.addAddressEntity(addressEntity);
        return ResopnseData.ok();
    }

    @RequestMapping("/address/update")
    public ResopnseData updateAddress(@Valid AddressEntity addressEntity,BindingResult bindingResult){
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
        iAddressService.updateAddressEntiry(addressEntity);
        return ResopnseData.ok();
    }

    @RequestMapping("/address/getAddress")
    public ResopnseData findAddress(int id){
        AddressEntity addressEntity = iAddressService.findAddress(id);
        ResopnseData resopnseData=new ResopnseData();
        resopnseData.setCode(200);
        resopnseData.getData().put("address", addressEntity);
        return resopnseData;
    }
}
