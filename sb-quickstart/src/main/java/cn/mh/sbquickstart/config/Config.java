package cn.mh.sbquickstart.config;

import cn.mh.sbquickstart.common.MyDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author: mahao
 * @date: 2019/11/3
 */
@Configuration
public class Config {

    @Bean
    public DataSource dataSource() {
        return MyDataSource.createPool();
    }
}
