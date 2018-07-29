package com.jwebcoder.groceryauth.insideauth.service;


import com.jwebcoder.groceryauth.common.dto.AuthInfoDTO;
import com.jwebcoder.groceryauth.common.dto.SystemUserDTO;


/**
 * Created by Jason on 11/10/2017.
 */
public interface InsideAuthService {
    SystemUserDTO loginAuthentication(String userName, String password);
    SystemUserDTO registerAuthentication(String userName, String password4Register, String activeEmail);
    AuthInfoDTO doAuthInfo(String object, String content);
}
