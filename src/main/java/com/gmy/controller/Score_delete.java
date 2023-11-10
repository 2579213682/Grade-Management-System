package com.gmy.controller;

import com.gmy.service.Score_Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Score_delete")
public class Score_delete extends HttpServlet {
    private Score_Service ss = new Score_Service();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deleteStudentid = request.getParameter("deleteStudentid");
        String deleteSubjectid = request.getParameter("deleteSubjectid");
        System.out.println("选中的要删除的studentid为"+deleteStudentid);
        System.out.println("选中的要删除的subjectid为"+deleteSubjectid);
        boolean deletedata = ss.deletedata(deleteStudentid, deleteSubjectid);
        System.out.println(deletedata);
        if (deletedata){
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
