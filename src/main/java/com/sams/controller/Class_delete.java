package com.sams.controller;

import com.sams.service.Class_Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Class_delete")
public class Class_delete extends HttpServlet {
   private Class_Service cs=new Class_Service();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deleteClassid = request.getParameter("deleteClassid");
        System.out.println(deleteClassid);
        HttpSession session = request.getSession();
        String userid = (String)session.getAttribute("userid");
        boolean deleteclass = cs.deleteclass(deleteClassid, userid);
        if (deleteclass){
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
