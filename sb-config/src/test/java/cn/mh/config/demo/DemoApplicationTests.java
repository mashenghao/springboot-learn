package cn.mh.config.demo;

import cn.mh.config.yml.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//验证属性是否注入成功

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    Person person;


    @Test
    public void contextLoads() {
        System.out.println(person);
    }

}
