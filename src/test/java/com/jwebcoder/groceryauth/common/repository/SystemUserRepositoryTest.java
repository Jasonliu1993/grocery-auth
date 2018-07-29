package com.jwebcoder.groceryauth.common.repository;

import com.jwebcoder.groceryauth.common.entity.PersonalInfo;
import com.jwebcoder.groceryauth.common.entity.SystemUser;
import com.jwebcoder.groceryauth.utils.JacksonTools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SystemUserRepositoryTest {

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Test
    public void test1() {
        SystemUser systemUser = systemUserRepository.findById("1").get();
        System.out.println(JacksonTools.writteObjectToValue(systemUser));
        PersonalInfo personalInfo = systemUser.getPersonalInfo();
        System.out.println(JacksonTools.writteObjectToValue(personalInfo));
    }

}