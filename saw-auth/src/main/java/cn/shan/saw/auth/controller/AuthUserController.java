package cn.shan.saw.auth.controller;


import cn.shan.saw.auth.model.entity.AuthUser;
import cn.shan.saw.auth.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shanlehong
 * @since 2018-02-07
 */
@RestController
@RequestMapping("/authUser")
public class AuthUserController {
    @Autowired
    private AuthUserService authUserService;

    @GetMapping
    public AuthUser queryAuthUserInfo(){
        return authUserService.selectById("f05d949d-0c90-11e8-9705-507b9da3078b");
    }


}

