package com.gmy.dao;

import com.gmy.pojo.Query1;
import com.gmy.pojo.Student;
import com.gmy.pojo.Student_score_subject;
import com.gmy.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    /*登录查询*/
    Student Login(User u);
    /*注册*/
    int Register(Student s);
    /*修改密码*/
    int Changepassword(@Param("student_id") String id, @Param("student_password") String p);
    /*学生编辑个人信息*/
    int Editinformation(Student s);
    /*学生浏览*/
    List<Student> Selectall();
    /*老师添加学生信息*/
    int Addstudent(Student s);
   /*老师删除学生信息*/
    int deletestudent(@Param("student_id") String student_id);
    /*分页查询*/
    List<Student> selectBypage(@Param("begin") int begin, @Param("size") int size);
    int selectTotalCount();
    /*条件查询*/
    List<Student_score_subject>QueryStudent(int begin, int size, Query1 query1);
    int selectTotalCountbyCondition(Query1 query1);
}
