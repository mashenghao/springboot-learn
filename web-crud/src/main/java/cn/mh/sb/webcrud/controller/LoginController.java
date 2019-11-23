package cn.mh.sb.webcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: mahao
 * @date: 2019/11/22
 */
@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request) {
        if ("zs".equalsIgnoreCase(name) && "123456".equalsIgnoreCase(pwd)) {
            request.getSession().setAttribute("user", "zs");
            return "redirect:main.html";
        } else {
            return "index";
        }
    }
}
