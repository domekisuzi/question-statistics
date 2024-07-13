package cn.xdc.interceptor;

/**
 * made by @domekisuzi at
 * 2024/7/11:4:27
 */


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

//用于调试的拦截器
@Component
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Request URL: " + request.getRequestURL());
        System.out.println("Request Method: " + request.getMethod());

//       TODO ("不读取请求体，防止发生多次读取错误")
//        System.out.println("Request Body: " + request.getReader().lines());
        return true;
    }
}