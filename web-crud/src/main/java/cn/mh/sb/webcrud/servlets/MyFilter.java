package cn.mh.sb.webcrud.servlets;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义filter
 *
 * @author: mahao
 * @date: 2019/11/24
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter....");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
