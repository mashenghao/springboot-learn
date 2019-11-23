package cn.mh.config.yml;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: mahao
 * @date: 2019/11/13
 */
@PropertySource("classpath:person.properties") //去指定文件下，加载配置文件信息，只能是properties格式
@Component//与配置文件绑定，必须是spring的组件
@ConfigurationProperties(prefix = "person")//指定配置文件的前缀
@Data
public class Person {

   // @Value("${person.last-name}") .会先于ConfigurationProperties赋值。
    private String lastName;
  //  @Value("#{18*2}")
    private Integer age;
    private Boolean boss;
    private Date birth;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;


}
