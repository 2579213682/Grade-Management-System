package com.gmy.controller;

import com.alibaba.fastjson.JSON;
import com.gmy.pojo.PageBean;
import com.gmy.pojo.Student;
import com.gmy.service.Student_Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Servletbypage_student")
public class Servletbypage_student extends HttpServlet {
    private Student_Service ss=new Student_Service();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*接收前端传来的当前页面和每页可以展示的数据条数*/
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        /*接收到的是String类型的页码信息，我们要转成int才能给方法传参*/
        int currentPage= Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<Student> pageBean = ss.selectbyPage(currentPage, pageSize);
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
