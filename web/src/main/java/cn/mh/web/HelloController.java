package cn.mh.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author: mahao
 * @date: 2019/11/22
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Map model) {
        model.put("hello", "你好，我来自后台");
        return "hello";
    }
}
