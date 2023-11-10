package com.gmy.controller;

import com.alibaba.fastjson.JSON;
import com.gmy.pojo.Subject;
import com.gmy.service.Subject_Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/Addsubject")
public class Addsubject extends HttpServlet {
    private Subject_Service ss=new Subject_Service();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*接收页面传来的成绩录入信息*/
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        /*将这个jason字符串转换*/
        Subject subject = JSON.parseObject(params, Subject.class);
        System.out.println(subject.toString());
        /*先判断一下添加的老师是否是为自己添加的课程*/
        HttpSession session = request.getSession();
        String userid = (String)session.getAttribute("userid");
        boolean equals = subject.getTeacherid().equals(userid);
        /*再判断老师添加的课程在数据库是否存在，存在了直接添加，不存在则先把课程添加到数据库中*/
        if (equals){
            boolean addsubject = ss.addsubject(subject);
            if (addsubject){
                response.getWriter().write("success");
            }
        }else {
            response.getWriter().write("no");
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
