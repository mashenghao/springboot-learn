package cn.mh.sb.sbjdbc.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @program: springboot-learn
 * @Date: 2019/11/25 18:38
 * @Author: mahao
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigurationPropertiesTest {


    @Autowired
    ConfigurationPropertie configurationPropertie;
    @Autowired
    Dog dog;


    @Test
    public void testClass() {
        System.out.println(configurationPropertie);
    }

    @Test
    public void testMethod() {

        System.out.println(dog);
    }
}