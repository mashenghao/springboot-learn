package cn.mh.sb.sbjdbc.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;



/**
 * 测试连接池的获取
 *
 * @program: springboot-learn
 * @Date: 2019/11/25 17:37
 * @Author: mahao
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcConnectionTest {

    @Autowired
    JdbcConnection jdbcConnection;

    @Test
    public void getDataSource() {
        DataSource dataSource = jdbcConnection.getDataSource();
        System.out.println(dataSource);
    }
}