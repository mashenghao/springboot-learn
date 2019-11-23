package cn.mh.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * 通过实现WebMvcConfigurer接口，可以作为springmvc的配置类，
 * adapter是WebMvcConfigurer的适配类，是空实现。
 * 原理是：
 * 在WebMvcAutoConfigurationAdapter被使用时，含有注解@Import(EnableWebMvcConfiguration.class)，
 * 导入了类EnableWebMvcConfiguration类，这个类中有一个方法是获取所有的WebMvcConfigurer组件。
 *
 * @author: mahao
 * @date: 2019/11/22
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor());
    }

    private static class LogInterceptor implements HandlerInterceptor {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            System.out.println("前置拦截：" + request.getParameterMap());
            return true;
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
            System.out.println("后置拦截：" + response.getStatus());
        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        }
    }
}
