package com.sams.service;

import com.sams.dao.ClassMapper;
import com.sams.dao.SubjectMapper;
import com.sams.pojo.CLASS;
import com.sams.pojo.PageBean;
import com.sams.util.SqlSF_tools;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class Class_Service {
    private SqlSessionFactory sqlSessionFactory= SqlSF_tools.getSqlSessionFactory();;
    private SqlSession sqlSession;
    /*分页查询*/
    public PageBean<CLASS> selectbyPage(int currentPage, int pageSize,String Username){
        sqlSession = sqlSessionFactory.openSession(true);
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        /*计算*/
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        List<CLASS> rows = mapper.selectBypage(begin, size, Username);
        int totalCount = mapper.selectTotalCount(Username);
        PageBean<CLASS> pageBean=new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;


    }
    /*老师为自己添加任课班级*/
    public boolean addclass(CLASS c){
        sqlSession = sqlSessionFactory.openSession(true);
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        int addclass = mapper.Addclass(c);
        if (addclass!=0){
            sqlSession.close();
            return true;
        }else {
            sqlSession.close();
            return false;
        }

    }
    /*老师删除自己的任课班级*/
    public boolean deleteclass(String classid,String teacherid){
        sqlSession = sqlSessionFactory.openSession(true);
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        int deleteclass = mapper.deleteclass(classid, teacherid);
        if (deleteclass!=0){
            sqlSession.close();
            return true;
        }else {
            sqlSession.close();
            return false;
        }
    }
}
