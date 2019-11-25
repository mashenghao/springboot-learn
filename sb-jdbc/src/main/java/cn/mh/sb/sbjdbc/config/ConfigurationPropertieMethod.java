package cn.mh.sb.sbjdbc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * * 将注解用于方法上，查看是如何绑定的;
 * * 这个的原理是使用后置处理bean，当把bean初始化完成后，返回时会
 * * 进行参数赋值；
 *
 * @author: mahao
 * @date: 2019/11/25
 */
@Configuration
public class ConfigurationPropertieMethod {

    /**
     * 将注解用于方法上，查看是如何绑定的;
     * 这个的原理是使用后置处理bean，当把bean初始化完成后，返回时会
     * 进行参数赋值；
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "methodConfig")
    public Dog dog() {
        Dog dog = new Dog();
        System.out.println("构造方法");
        dog.setAge(100);
        return dog;
    }
}
