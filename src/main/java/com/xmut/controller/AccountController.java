package com.xmut.controller;

import com.xmut.entity.Account;
import com.xmut.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 账户Controller层
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {

        System.out.println("表现层findAll()方法执行了。。。");

        ModelAndView modelAndView = new ModelAndView();
        List<Account> list = accountService.findAll();
        modelAndView.addObject("list", list);
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Account account) {

        System.out.println("表现层save()方法执行了。。。");

        accountService.saveAccount(account);
        return "success";
    }
}
