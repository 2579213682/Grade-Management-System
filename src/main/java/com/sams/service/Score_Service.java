package com.sams.service;

import com.sams.dao.ScoreMapper;
import com.sams.pojo.*;
import com.sams.util.SqlSF_tools;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class Score_Service {
    SqlSessionFactory sqlSessionFactory = SqlSF_tools.getSqlSessionFactory();
    SqlSession sqlSession;

    /*成绩浏览功能*/
    public List<Student_score_subject> selectall() {
        sqlSession = sqlSessionFactory.openSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);
        List<Student_score_subject> selectall = mapper.selectall();
        sqlSession.close();
        return selectall;

    }

    /*成绩录入功能*/
    public boolean addscore(Score s) {
        sqlSession = sqlSessionFactory.openSession(true);
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);
        int addscore = mapper.addscore(s);
        if (addscore != 0 && s != null) {
            sqlSession.close();
            return true;
        } else {
            sqlSession.close();
            return false;
        }
    }

    /*分页查询*/
    public PageBean<Student_score_subject> selectbyPage(int currentPage, int pageSize) {
        sqlSession = sqlSessionFactory.openSession(true);
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);
        /*计算*/
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        List<Student_score_subject> rows = mapper.selectBypage(begin, size);
        int totalCount = mapper.selectTotalCount();
        /*封装成pagebean对象*/
        PageBean<Student_score_subject> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }

    /*表单条件查询*/
    public PageBean<Student_score_subject> selectbyPageAndCondition(int currentPage, int pageSize, Query1 query1) {
        sqlSession = sqlSessionFactory.openSession(true);
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);
        /*计算*/
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        List<Student_score_subject> rows = mapper.QueryScore(begin, size, query1);
        int totalCount = mapper.selectTotalCountbyCondition(query1);
        /*封装成pagebean对象*/
        PageBean<Student_score_subject> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }

    /*删除功能*/
    public boolean deletedata(String studentid, String subjectid) {
        sqlSession = sqlSessionFactory.openSession(true);
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);
        int deletedata = mapper.deletedata(studentid, subjectid);
        if (deletedata != 0) {
            sqlSession.close();
            return true;
        } else {
            sqlSession.close();
            return false;
        }
    }

    /*修改功能*/
    public boolean updatedata(ScoreUpdate s) {
        sqlSession = sqlSessionFactory.openSession(true);
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);
        int updateddata = mapper.updateddata(s);
        if (updateddata != 0) {
            sqlSession.close();
            return true;
        } else {
            sqlSession.close();
            return false;
        }
    }
    /*学生端查询成绩*/
    public PageBean<Student_score_subject> selectbyPagetostudent(int currentPage, int pageSize ,String studentid) {
        sqlSession = sqlSessionFactory.openSession(true);
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);
        /*计算*/
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        List<Student_score_subject> rows = mapper.selectBypagetostudent(begin, size, studentid);
        int totalCount = mapper.selectTotalCounttostudent(studentid);
        /*封装成pagebean对象*/
        PageBean<Student_score_subject> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }

}
