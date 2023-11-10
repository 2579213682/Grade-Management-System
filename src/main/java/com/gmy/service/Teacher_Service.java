package com.gmy.service;

import com.gmy.dao.TeacherMapper;
import com.gmy.pojo.Teacher;
import com.gmy.pojo.User;
import com.gmy.util.SqlSF_tools;
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
