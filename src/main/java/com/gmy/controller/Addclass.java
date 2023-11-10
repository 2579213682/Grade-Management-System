package com.gmy.controller;

import com.alibaba.fastjson.JSON;
import com.gmy.pojo.CLASS;
import com.gmy.service.Class_Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/Addclass")
public class Addclass extends HttpServlet {
    private Class_Service cs=new Class_Service();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*接收页面传来的成绩录入信息*/
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        /*将这个jason字符串转换*/
        CLASS aClass = JSON.parseObject(params, CLASS.class);
        System.out.println(aClass.toString());
        /*先判断一下添加的老师是否是为自己添加的任课班级*/
        HttpSession session = request.getSession();
        String userid = (String)session.getAttribute("userid");
        boolean equals = aClass.getTeacherid().equals(userid);
        if (equals){
            boolean addclass = cs.addclass(aClass);
            if (addclass){
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
