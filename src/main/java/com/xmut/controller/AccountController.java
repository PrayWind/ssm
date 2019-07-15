package com.xmut.controller;

import com.xmut.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 账户Controller层
 */

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll() {

        System.out.println("表现层findAll()方法执行了。。。");
        accountService.findAll();
        return "list";
    }
}
