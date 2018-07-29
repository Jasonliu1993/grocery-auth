package com.jwebcoder.groceryauth.insideauth.service.impl;

import com.jwebcoder.groceryauth.common.dto.AuthInfoDTO;
import com.jwebcoder.groceryauth.common.dto.SystemUserDTO;
import com.jwebcoder.groceryauth.common.entity.PersonalInfo;
import com.jwebcoder.groceryauth.common.entity.SystemUser;
import com.jwebcoder.groceryauth.common.repository.PersonalInfoRepository;
import com.jwebcoder.groceryauth.common.repository.SystemUserRepository;
import com.jwebcoder.groceryauth.common.utils.DateUtility;
import com.jwebcoder.groceryauth.common.utils.EncryptionUtility;
import com.jwebcoder.groceryauth.common.utils.JacksonTools;
import com.jwebcoder.groceryauth.common.utils.TokenUtility;
import com.jwebcoder.groceryauth.insideauth.service.InsideAuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jason on 11/10/2017.
 */

@Service
public class InsideAuthServiceImpl implements InsideAuthService {

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Autowired
    private PersonalInfoRepository personalInfoRepository;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 登录认证
     *
     * @param userNameOrEmail 用户名或者邮箱
     * @param password        密码
     * @return
     */
    @Override
    @Transactional
    public SystemUserDTO loginAuthentication(String userNameOrEmail, String password) {
        SystemUser systemUser = null;
        if ((systemUser = systemUserRepository.getSystemUserByUserNameOrEmailAndPassword(userNameOrEmail, userNameOrEmail, password)) != null) {
            SystemUserDTO systemUserDTO = new SystemUserDTO();
            systemUser.setLastLoginDatetime(DateUtility.getCurrentDate());
            systemUserRepository.save(systemUser);
            BeanUtils.copyProperties(systemUser, systemUserDTO);//忽略属性拷贝
            setTokenToRedis(systemUserDTO);
            return systemUserDTO;
        }
        return null;
    }

    /**
     * 注册用户
     *
     * @param userName          用户名
     * @param password4Register 密码
     * @param activeEmail       邮箱
     * @return
     */
    @Override
    @Transactional
    public SystemUserDTO registerAuthentication(String userName, String password4Register, String activeEmail) {
        SystemUser systemUser = new SystemUser();
        PersonalInfo personalInfo = new PersonalInfo();
        SystemUserDTO systemUserDTO = new SystemUserDTO();

        systemUser.setUserName(userName);
        systemUser.setPassword(password4Register);
        systemUser.setType("custom");
        systemUser.setEmail(activeEmail);
        systemUser.setCreateDatetime(DateUtility.getCurrentDate());
        systemUser.setLastLoginDatetime(DateUtility.getCurrentDate());
        systemUserRepository.save(systemUser);

        personalInfo.setVersion(1);
        personalInfo.setUserId(systemUser.getId());
        personalInfo.setAvator("1");

        personalInfoRepository.save(personalInfo);
        systemUser.setPersonalInfo(personalInfo);
        BeanUtils.copyProperties(systemUser, systemUserDTO);//忽略属性拷贝
        setTokenToRedis(systemUserDTO);
        return systemUserDTO;
    }

    /**
     * 检查是否存在注册信息，如果存在就不住让注册，避免重复注册
     *
     * @param object  注册类型
     * @param content 检查内容
     * @return
     */
    @Override
    public AuthInfoDTO doAuthInfo(String object, String content) {

        AuthInfoDTO authInfo = new AuthInfoDTO();

        switch (object) {
            case "UserName":
                if (systemUserRepository.checkUserName(content) > 0) {
                    authInfo.setObject("UserName");
                    authInfo.setErrorFlag("N");
                    authInfo.setErrorMessage("用户名已存在");
                } else {
                    authInfo.setObject("UserName");
                    authInfo.setErrorFlag("Y");
                }
                break;
            case "Email":
                if (systemUserRepository.checkEmail(content) > 0) {
                    authInfo.setObject("Email");
                    authInfo.setErrorFlag("N");
                    authInfo.setErrorMessage("邮箱已存在");
                } else {
                    authInfo.setObject("Email");
                    authInfo.setErrorFlag("Y");
                }
                break;
            case "Password":
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                HttpSession session = request.getSession();
                SystemUser systemUser = (SystemUser) session.getAttribute("User");
                if (!EncryptionUtility.encrypt4MD5(content).equals(systemUser.getPassword())) {
                    authInfo.setObject("Password");
                    authInfo.setErrorFlag("N");
                    authInfo.setErrorMessage("密码不正确");
                } else {
                    authInfo.setObject("Password");
                    authInfo.setErrorFlag("Y");
                }
                break;
            default:
                authInfo.setObject("Unkonw");
                authInfo.setErrorFlag("N");
                authInfo.setErrorMessage("未知错误");
        }

        return authInfo;
    }

    private void setTokenToRedis(SystemUserDTO systemUserDTO) {
        String token = TokenUtility.newToken();
        redisTemplate.opsForValue().set(token, JacksonTools.writteObjectToValue(systemUserDTO), 1L, TimeUnit.HOURS);
    }

}
