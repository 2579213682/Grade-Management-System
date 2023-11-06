package com.sams.controller;

import com.alibaba.fastjson.JSON;
import com.sams.pojo.PageBean;
import com.sams.pojo.Query1;
import com.sams.pojo.Student_score_subject;
import com.sams.service.Score_Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/Score_condition_select")
public class Score_condition_select extends HttpServlet {
    private Score_Service ss = new Score_Service();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*接收前端传来的当前页面和每页可以展示的数据条数*/
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        /*接收到的是String类型的页码信息，我们要转成int才能给方法传参*/
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        /*获取相应的表单查询条件对象*/
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        /*将查询条件转成Query1对象
         * */
        Query1 query1 = JSON.parseObject(params, Query1.class);
        System.out.println("这里是"+query1.getStudent_name()+"测试");

        PageBean<Student_score_subject> pageBean = ss.selectbyPageAndCondition(currentPage,pageSize,query1);

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
