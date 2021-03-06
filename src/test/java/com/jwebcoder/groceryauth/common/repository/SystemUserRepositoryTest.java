package com.jwebcoder.groceryauth.common.repository;

import com.jwebcoder.groceryauth.common.entity.PersonalInfo;
import com.jwebcoder.groceryauth.common.entity.SystemUser;
import com.jwebcoder.groceryauth.common.utils.JacksonTools;
import com.jwebcoder.groceryauth.insideauth.service.InsideAuthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SystemUserRepositoryTest {

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Autowired
    private InsideAuthService insideAuthService;

    @Test
    public void test1() {
        SystemUser systemUser = systemUserRepository.findById("1").get();
        System.out.println(JacksonTools.writteObjectToValue(systemUser));
        PersonalInfo personalInfo = systemUser.getPersonalInfo();
        System.out.println(JacksonTools.writteObjectToValue(personalInfo));
    }

    @Test
    public void test2() {
        insideAuthService.registerAuthentication("test","test","123@qq.com");
    }

}