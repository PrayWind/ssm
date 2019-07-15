package com.xmut.serviceImpl;

import com.xmut.entity.Account;
import com.xmut.mapper.AccountMapper;
import com.xmut.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户Service层接口的实现类
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> findAll() {

        System.out.println("业务层：findAll()方法执行了。。。");
        return accountMapper.findAll();
    }

    @Override
    public void saveAccount(Account account) {

        System.out.println("业务层：saveAccount()方法执行了。。。");
        accountMapper.saveAccount(account);
    }
}
