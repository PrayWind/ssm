package com.xmut.mapper;

import com.xmut.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户mapper接口
 */
@Repository
public interface AccountMapper {

    @Select("select * from account")
    public List<Account> findAll(); // 查询所有账户信息

    @Insert("insert into account (name, money) values (#{name}, #{money})")
    public void saveAccount(Account account);  // 保存账户信息
}
