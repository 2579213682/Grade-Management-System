package com.sams.controller;

import com.alibaba.fastjson.JSON;
import com.sams.pojo.Score;
import com.sams.pojo.Student;
import com.sams.service.Student_Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/Addstudent")
public class Addstudent extends HttpServlet {
    private Student_Service ss=new Student_Service();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*接收页面传来的成绩录入信息*/
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        /*将这个jason字符串转换*/
        Student student = JSON.parseObject(params, Student.class);
        System.out.println(student.toString());
        boolean addstudnet = ss.addstudnet(student);
        if (addstudnet){
            response.getWriter().write("success");
        }else {
            response.getWriter().write("no");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
