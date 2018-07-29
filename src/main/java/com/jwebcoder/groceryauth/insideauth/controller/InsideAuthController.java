package com.jwebcoder.groceryauth.insideauth.controller;

import com.jwebcoder.groceryauth.common.dto.SystemUserDTO;
import com.jwebcoder.groceryauth.common.dto.AuthInfoDTO;
import com.jwebcoder.groceryauth.insideauth.service.InsideAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insideAuth")
public class InsideAuthController {

    @Autowired
    private InsideAuthService insideAuthService;

    @PostMapping("/login")
    SystemUserDTO loginAuthentication(String userName, String password) {
        return insideAuthService.loginAuthentication(userName, password);
    }

    @PostMapping("/register")
    SystemUserDTO registerAuthentication(String userName, String password4Register, String activeEmail) {
        return insideAuthService.registerAuthentication(userName, password4Register, activeEmail);
    }

    @GetMapping("/registerCheck")
    AuthInfoDTO doAuthInfo(@RequestParam String object, @RequestParam String content) {
        return insideAuthService.doAuthInfo(object, content);
    }

}
