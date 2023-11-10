package com.gmy.controller;

import com.alibaba.fastjson.JSON;
import com.gmy.pojo.Student;
import com.gmy.service.Student_Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/Student_update")
public class Student_update extends HttpServlet {
    private Student_Service ss=new Student_Service();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        Student student = JSON.parseObject(params, Student.class);
        boolean updatestudent = ss.updatestudent(student);
        if (updatestudent){
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
