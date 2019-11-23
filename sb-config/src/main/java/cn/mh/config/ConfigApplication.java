package cn.mh.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 讲解springboot的配置：
 * 1.配置文件，yml语法
 * 2.代码中获取信息，配置文件值注入
 * 3.Profile
 * 4.自动配置原理
 */
@SpringBootApplication
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }

}
