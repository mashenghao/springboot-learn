package cn.mh.sb.sbjdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author: mahao
 * @date: 2019/11/25
 */
@Configuration
public class DruidConfig {


    /**
     * 通过ConfigurationPropertieMethod和ConfigurationPropertie两个类的实验，我们可以进行扩展赋值；
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid() {
        /**
         * 会在方法返回的时候，获取spring.data对应的参数，进行数据绑定；
         */
        return new DruidDataSource();
    }

}
