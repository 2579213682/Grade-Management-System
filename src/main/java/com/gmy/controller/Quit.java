package com.gmy.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Quit")
public class Quit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*用来实现退出系统*/
        String s = request.getParameter("quit1");
        System.out.println(s);
        if(s.equals("yes")){
            /*直接把登录完成后的session给销毁掉*/
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("http://localhost:8080/Sams_homework_war/Login.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
