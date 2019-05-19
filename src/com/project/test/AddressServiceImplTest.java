package com.project.test;

import com.project.entity.AddressEntity;
import com.project.service.IAddressService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;

public class AddressServiceImplTest {
    IAddressService iAddressService=null;
    @Before
    public void setUp() throws Exception {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        iAddressService = (IAddressService) applicationContext.getBean("addressServiceImpl");

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findAllAddress() {
        Page<AddressEntity> page = iAddressService.findAll("admin",1, 18);
        System.out.println(page);
    }
    @Test
    public void insertAddressEntity(){
        AddressEntity addressEntity=new AddressEntity();
        addressEntity.setUsername("111");
        addressEntity.setName("111");
        addressEntity.setSex("1111");
        addressEntity.setAddress("111");
        addressEntity.setEmail("111");
        addressEntity.setQq("111");
        addressEntity.setCompany("111");
        addressEntity.setMobile("111");
        addressEntity.setPostcode("111");
        iAddressService.addAddressEntity(addressEntity);
    }
    @Test
    public void deleteAddress(){
        iAddressService.deleteAddressEntity(77);
    }
}