package com.sams.controller;

import com.alibaba.fastjson.JSON;
import com.sams.pojo.Score;
import com.sams.service.Score_Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addscore")
public class Addscore extends HttpServlet {
   private Score_Service ss=new Score_Service();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*接收页面传来的成绩录入信息*/
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        /*将这个jason字符串转换*/
        Score score = JSON.parseObject(params, Score.class);
        System.out.println(score.toString());
        /*将这个要录入的成绩录入数据库*/
        boolean addscore = ss.addscore(score);
        if (addscore){
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
