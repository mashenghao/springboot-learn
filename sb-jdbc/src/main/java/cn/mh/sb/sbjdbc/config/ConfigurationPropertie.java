package cn.mh.sb.sbjdbc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 测试@ConfigurationProperties(prefix = "druidConfig")注解与参数绑定问题，
 * 放在类上和方法上的区别；
 *
 * @author: mahao
 * @date: 2019/11/25
 */
@Component
//注解用于类上，会将属性与配置文件匹配绑定
@ConfigurationProperties(prefix = "classConfig")
@Data
public class ConfigurationPropertie {

    private String username;

    private String pwd;



}
