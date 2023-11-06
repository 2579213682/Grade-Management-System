package com.sams.controller;

import com.alibaba.fastjson.JSON;
import com.sams.pojo.CLASS;
import com.sams.pojo.PageBean;
import com.sams.service.Class_Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Selectbypage_class")
public class Selectbypage_class extends HttpServlet {
    private Class_Service cs=new Class_Service();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        String username = request.getParameter("Username");
        /*接收到的是String类型的页码信息，我们要转成int才能给方法传参*/
        int currentPage= Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<CLASS> pageBean = cs.selectbyPage(currentPage, pageSize, username);
        System.out.println(pageBean.toString());
        /*把pagebean集合转换为json对象*/
        String jsonString = JSON.toJSONString(pageBean);
        /*用resp响应给前端，并处理中文乱码问题*/
        System.out.println(jsonString);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
