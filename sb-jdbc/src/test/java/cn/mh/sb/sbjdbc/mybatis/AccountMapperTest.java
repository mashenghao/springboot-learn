package cn.mh.sb.sbjdbc.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @program: springboot-learn
 * @Date: 2019/11/25 20:25
 * @Author: mahao
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountMapperTest {

    @Autowired
    AccountMapper accountMapper;

    @Test
    public void testget() {
        Account account = accountMapper.selectById(1);
        System.out.println(account);
    }

    @Test
    public void testall() {
        List<Account> accounts = accountMapper.selectAll();

        System.out.println(accounts);
    }
}