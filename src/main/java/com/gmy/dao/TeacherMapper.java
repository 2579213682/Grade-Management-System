package com.gmy.dao;

import com.gmy.pojo.Teacher;
import com.gmy.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    /*登录查询*/
    Teacher Login(User u);
    /*修改密码*/
    int Changepassword(@Param("teacher_id")String id,@Param("teacher_password")String password);
    /*修改个人信息*/
    int Editinformation(Teacher t);
}
