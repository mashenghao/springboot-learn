package cn.mh.sb.webcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 将项目的欢迎页转发到自己的页面上，springboot默认的欢迎页是index.html,当请求是项目/或者项目/index.html，
 * 都是在访问欢迎页。我们将这两个请求，转发到我们自己的页面。
 *
 * @author: mahao
 * @date: 2019/11/22
 */
@Controller
public class IndexController {

    //@RequestMapping({"/", "index.html"})
    public String index() {
        return "index";
    }
}
