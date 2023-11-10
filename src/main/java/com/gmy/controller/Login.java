package com.gmy.controller;

import com.gmy.pojo.User;
import com.gmy.service.Student_Service;
import com.gmy.service.Teacher_Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    private Student_Service ss;
    private Teacher_Service ts;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ss = new Student_Service();
        ts = new Teacher_Service();
        /*接收数据*/
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        User user=new User(id,password);
        boolean studentlogin = ss.studentlogin(user);
        boolean teacherlogin = ts.teacherlogin(user);
        System.out.println(studentlogin);
        System.out.println(teacherlogin);
        if (studentlogin == false && teacherlogin == true) {
            /*老师账号登录成功*/
            System.out.println("老师登陆成功");
            /*登录成功后添加session，用来解除过滤器过滤*/
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            session.setAttribute("userid",user.getId());
            response.sendRedirect("http://localhost:8080/Sams_homework_war/TeacherPage_Browse_score.html");


        } else if (teacherlogin == false && studentlogin == true) {
            /*学生账号登录成功*/
            System.out.println("学生登陆成功");
            /*登录成功后添加session，用来解除过滤器过滤*/
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            session.setAttribute("userid",user.getId());
            response.sendRedirect("http://localhost:8080/Sams_homework_war/StudentMainPage.html");

        } else {
            if (teacherlogin ==false && studentlogin ==false){
                request.setAttribute("tell","登录失败！账号或密码错误！");
            }
            request.getRequestDispatcher("Login.jsp").forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
