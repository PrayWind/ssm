package com.xmut.test;

import com.xmut.entity.Account;
import com.xmut.mapper.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    /**
     * 测试findAll方法
     * @throws Exception
     */
    @Test
    public void run1() throws Exception {

        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        AccountMapper mapper = session.getMapper(AccountMapper.class);

        // 调用AccountMapper里的方法
        List<Account> list = mapper.findAll();
        for (Account temp : list) {
            System.out.println(temp);
        }

        // 关闭资源
        session.close();
        inputStream.close();
    }

    /**
     * 测试saveAccount方法
     * @throws Exception
     */
    @Test
    public void run2() throws Exception {

        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        AccountMapper mapper = session.getMapper(AccountMapper.class);

        // 调用AccountMapper里的方法
        Account account = new Account();
        account.setName("0");
        account.setMoney(0.0);
        mapper.saveAccount(account);

        // 提交事务
        session.commit();

        // 关闭资源
        session.close();
        inputStream.close();
    }
}
