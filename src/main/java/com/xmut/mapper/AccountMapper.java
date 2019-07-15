package com.xmut.mapper;

import com.xmut.entity.Account;
import java.util.List;

/**
 * 账户mapper接口
 */
public interface AccountMapper {

    public List<Account> findAll(); // 查询所有账户信息

    public void saveAccount(Account account);  // 保存账户信息
}
