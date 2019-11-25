package cn.mh.sb.sbjdbc.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * 获取数据库连接池
 *
 * @author: mahao
 * @date: 2019/11/25
 */
@Component
public class JdbcConnection {

    @Autowired
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }
}
