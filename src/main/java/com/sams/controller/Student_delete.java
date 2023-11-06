package com.sams.controller;

import com.sams.service.Student_Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Student_delete")
public class Student_delete extends HttpServlet {
    private Student_Service ss=new Student_Service();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deleteStudentid = request.getParameter("deleteStudentid");
        System.out.println("选中的要删除的studentid为"+deleteStudentid);
        boolean deletestudnet = ss.deletestudnet(deleteStudentid);
        System.out.println(deletestudnet);
        if (deletestudnet){
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
