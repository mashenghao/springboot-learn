package cn.mh.sb.webcrud.compont;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * 自定义实现错误信息的封装，我们继承了DefaultErrorAttributes，
 * 在他的基础上实现我们的扩展信息。
 *
 * @author: mahao
 * @date: 2019/11/23
 */
@Component
public class ExtendErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        //取出旧的信息
        Map<String, Object> attributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
        //取出扩展的信息，这些扩展信息是springmvc的全局异常页面跳转时放进去的数据
        Object extendMsg = requestAttributes.getAttribute("extendMsg", RequestAttributes.SCOPE_REQUEST);
        attributes.put("ext", extendMsg);
        attributes.put("company", "mh");
        return attributes;
    }
}
