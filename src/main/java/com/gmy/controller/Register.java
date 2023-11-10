package com.gmy.controller;

import com.gmy.pojo.Student;
import com.gmy.service.Student_Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Register")
public class Register extends HttpServlet {
    private Student_Service ss;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ss = new Student_Service();
        /*接收数据*/
        String regid = request.getParameter("regid");
        String checkpassword = request.getParameter("checkpassword");
        Student student=new Student();
        student.setStudent_id(regid);
        student.setStudent_password(checkpassword);
        boolean studentregister = ss.studentregister(student);
        if (studentregister){
            response.sendRedirect("http://localhost:8080/Sams_homework_war/Login");
        }else {
            request.setAttribute("tell1","注册失败，请重新尝试！");
            request.getRequestDispatcher("Register.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
