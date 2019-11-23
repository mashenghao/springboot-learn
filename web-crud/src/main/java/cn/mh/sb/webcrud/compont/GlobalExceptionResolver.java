package cn.mh.sb.webcrud.compont;

import cn.mh.sb.webcrud.common.ApiResult;
import cn.mh.sb.webcrud.common.ApiStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 全局异常处理类
 *
 * @author: mahao
 * @date: 2019/11/23
 */
@ControllerAdvice//标记注解，拦截所有的@Controller类
public class GlobalExceptionResolver {

    /**
     * 处理所有不可知异常
     *
     * @param e
     * @return
     */
    //@ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResult handleException(Exception e) {
        System.out.println(e.getMessage());
        return ApiResult.of(ApiStatus.UNKNOWN_ERROR);
    }

    /**
     * 处理自定义的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(SBException.class)
    @ResponseBody
    public ApiResult handleMyException(Exception e) {
        System.out.println(e.getMessage());
        return new ApiResult(ApiStatus.SUCCESS);
    }

    /**
     * 带自适应的异常处理机制，自定义实现数据封装组件，具体的看DefaultErrorAttributes的使用
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String handleExceptionbySb(Exception e, HttpServletRequest request) {
        //设定我们自定义异常的状态码，会根据这个状态码去寻找错误页面
        request.setAttribute("javax.servlet.error.status_code", 508);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg", e.getMessage());
        request.setAttribute("extendMsg",map);
        System.out.println("..................");
        return "forward:/error"; //转发到/error请求
    }
}
