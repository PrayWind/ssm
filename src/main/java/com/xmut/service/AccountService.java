package com.xmut.service;

import com.xmut.entity.Account;
import java.util.List;

/**
 * 账户Service接口
 */
public interface AccountService {

    public List<Account> findAll(); // 查询所有账户信息

    public void saveAccount(Account account);  // 保存账户信息
}
