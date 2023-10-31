package com.jade.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.jade.pojo.Result;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        String url = request.getRequestURI();
        log.info("Request URL:{}", url);
        if (url.contains("/login")) {
            return true;
        }

        String jwt = request.getHeader("token");
        if (!StringUtils.hasLength(jwt)) {
            Result error = Result.error("Please login first");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }
        try {
            Jwts.parserBuilder().build().parse(jwt);
        }catch (Exception e){
            Result error = Result.error("Please login first");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;

        }
        log.info("token leagal");
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
