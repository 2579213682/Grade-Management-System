package com.sams.controller;

import com.alibaba.fastjson.JSON;
import com.sams.pojo.ScoreUpdate;
import com.sams.service.Score_Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/Score_update")
public class Score_update extends HttpServlet {
    private Score_Service ss=new Score_Service();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*接收页面传来的成绩录入信息*/
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        ScoreUpdate scoreUpdate = JSON.parseObject(params, ScoreUpdate.class);
        System.out.println(scoreUpdate.toString());
        boolean updatedata = ss.updatedata(scoreUpdate);
        if (updatedata){
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
