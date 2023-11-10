package com.gmy.controller;

import com.gmy.service.Subject_Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Subject_delete")
public class Subject_delete extends HttpServlet {
   private Subject_Service ss=new Subject_Service();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deleteSubjectid = request.getParameter("deleteSubjectid");
        System.out.println(deleteSubjectid);
        HttpSession session = request.getSession();
        String userid = (String)session.getAttribute("userid");
        boolean deletesubject = ss.deletesubject(deleteSubjectid, userid);
        if (deletesubject){
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
