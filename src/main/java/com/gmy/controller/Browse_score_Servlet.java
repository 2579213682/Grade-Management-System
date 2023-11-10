package com.gmy.controller;

import com.alibaba.fastjson.JSON;
import com.gmy.pojo.Student_score_subject;
import com.gmy.service.Score_Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/Browse_score_Servlet")
public class
Browse_score_Servlet extends HttpServlet {
    private Score_Service ss;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*这个servlet负责的是查询数据库中的所有人的所有成绩*/
        ss=new Score_Service();
        List<Student_score_subject> selectall = ss.selectall();
        /*将查到的数据转换成json字符串响应给前端*/
        String jsonString = JSON.toJSONString(selectall);
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
