package com.sams.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class Loginfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*设置一个过滤器用来实现只有登录了才能访问系统页面*/
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        /*与登录和注册有关的资源过滤器需要放行，用个数组来存放行的资源，其他的页面全部需要经过过滤器*/
        String[] urls= {"/css/","/js/","/img/","Login.jsp","Register.jsp","/Login","/Register"};
        String url = request.getRequestURL().toString();
        /*遍历urls数组，看一下访问的资源是否在这个放行数组中*/
        for (String u : urls) {
            if (url.contains(u)){
                /*当前访问页面是放行数组里的，就直接放行*/
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        /*遍历完后没有return的就要检查一下是否登录过，登录了就会有session*/
        HttpSession session = request.getSession();
        Object now_user = session.getAttribute("user");
        if (now_user != null) {
            /*有session，则放行*/
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            /*若没有session，则跳转到登录页面*/
            request.getRequestDispatcher("Login.jsp").forward(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
