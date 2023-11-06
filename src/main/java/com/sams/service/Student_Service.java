package com.sams.service;

import com.sams.dao.ScoreMapper;
import com.sams.dao.StudentMapper;
import com.sams.pojo.*;
import com.sams.util.SqlSF_tools;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class Student_Service {
    private SqlSessionFactory sqlSessionFactory= SqlSF_tools.getSqlSessionFactory();;
    private SqlSession sqlSession;

    /*登录*/
    public boolean studentlogin(User u){
        sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student login = mapper.Login(u);
        if (login !=null){
            sqlSession.close();
            return true;
        }else {
            sqlSession.close();
            return false;
        }
    }
    /*注册*/
    public boolean studentregister(Student s){
        sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int register = mapper.Register(s);
        if (register !=0){
            sqlSession.close();
            return true;
        }else {
            sqlSession.close();
            return false;
        }
    }
    /*老师添加学生功能*/
    public boolean addstudnet(Student s){
        sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int addstudent = mapper.Addstudent(s);
        if (addstudent!=0){
            sqlSession.close();
            return true;
        }else {
            sqlSession.close();
            return false;
        }
    }
    /*老师修改学生信息*/
    public boolean updatestudent(Student s){
        sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int editinformation = mapper.Editinformation(s);
        if (editinformation!=0){
            sqlSession.close();
            return true;
        }else {
            sqlSession.close();
            return false;
        }
    }
    /*老师删除学生信息*/
    public boolean deletestudnet(String studentid){
        sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int deletestudent = mapper.deletestudent(studentid);
        if (deletestudent!=0){
            sqlSession.close();
            return true;
        }else {
            sqlSession.close();
            return false;
        }
    }
    /*分页查询*/
    public PageBean<Student> selectbyPage(int currentPage, int pageSize){
        sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        /*计算*/
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        List<Student> rows = mapper.selectBypage(begin, size);
        int totalCount =mapper.selectTotalCount();
        PageBean<Student> pageBean=new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }
    /*条件查询*/
    public PageBean<Student_score_subject> selectbyPageAndCondition(int currentPage, int pageSize, Query1 query1){
        sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        /*计算*/
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        List<Student_score_subject> rows= mapper.QueryStudent(begin, size, query1);
        int totalCount = mapper.selectTotalCountbyCondition(query1);
        /*封装成pagebean对象*/
        PageBean<Student_score_subject> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;


    }

}
