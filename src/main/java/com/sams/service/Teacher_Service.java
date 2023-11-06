package com.sams.service;

import com.sams.dao.TeacherMapper;
import com.sams.pojo.Teacher;
import com.sams.pojo.User;
import com.sams.util.SqlSF_tools;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class Teacher_Service {
    private SqlSessionFactory sqlSessionFactory= SqlSF_tools.getSqlSessionFactory();
    private SqlSession sqlSession;
    /*登录*/
    public boolean teacherlogin(User u){
        sqlSession = sqlSessionFactory.openSession(true);
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher login = mapper.Login(u);
        if (login !=null){
            sqlSession.close();
            return true;
        }else {
            sqlSession.close();
            return false;
        }
    }
}
