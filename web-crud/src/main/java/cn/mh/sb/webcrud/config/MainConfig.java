package cn.mh.sb.webcrud.config;

import cn.mh.sb.webcrud.compont.LoginInterceptor;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author: mahao
 * @date: 2019/11/22
 */
@Configuration
public class MainConfig {

    /**
     * 手动扩展配置springmvc，通过WebMvcConfigurer接口，在加载springmvc的配置文件时，会加载WebMvcConfigurer
     * 所有的类，可以通过实现这里面的方法，去注册ViewControllers。
     *
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        //使用的是适配器接口
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
        };
    }


    /**
     * 替换掉系统使用的LocalResolver，使用自定义的localResolver；
     * 根据请求中携带的信息，判断使用哪种国际化.
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new LocaleResolver() {
            //如果指定了使用哪一种国际化，则使用，没有的话，使用默认的；
            @Override
            public Locale resolveLocale(HttpServletRequest request) {

                String l = request.getParameter("l");
                System.out.println(l);
                if (!StringUtils.isEmpty(l)) {
                    String[] split = l.split("_");
                    return new Locale(split[0], split[1]);
                } else {
                    return Locale.getDefault();
                }
            }

            @Override
            public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

            }
        };
    }

    /**
     * 添加拦截器
     *
     * @return
     */
    @Bean
    public WebMvcConfigurer mvcConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor())
                        .excludePathPatterns("/index.html", "/", "/login");
            }
        };
    }


    /**
     * 代码扩展servlet容器配置
     */
    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
        //使用匿名内部类，创建一个实现类
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setPort(8888);
            }
        };
    }
}
