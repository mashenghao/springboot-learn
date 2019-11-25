package cn.mh.sb.sbjdbc.mybatis;

/**
 * @author: mahao
 * @date: 2019/11/25
 */

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;


/**
 * 注解版的配置类：
 */
@org.springframework.context.annotation.Configuration
public class MainConfig {

    @Bean
    public ConfigurationCustomizer configuration() {
        /**
         *添加配置类。
         */
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
                
            }
        };
    }

}
