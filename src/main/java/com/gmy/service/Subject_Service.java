package com.gmy.service;

import com.gmy.dao.SubjectMapper;
import com.gmy.pojo.PageBean;
import com.gmy.pojo.Subject;
import com.gmy.util.SqlSF_tools;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class Subject_Service {
    private SqlSessionFactory sqlSessionFactory= SqlSF_tools.getSqlSessionFactory();;
    private SqlSession sqlSession;
    /*分页查询*/
    public PageBean<Subject> selectbyPage(int currentPage, int pageSize,String Username){
        sqlSession = sqlSessionFactory.openSession(true);
        SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
        /*计算*/
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        List<Subject> rows = mapper.selectBypage(begin, size, Username);
        int totalCount = mapper.selectTotalCount(Username);
        PageBean<Subject> pageBean=new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }
    /*老师为自己添加课程*/
    public boolean addsubject(Subject s){
        boolean back=false;
        sqlSession = sqlSessionFactory.openSession(true);
        SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
        List<Subject> selectall = mapper.selectall(s.getSubjectid());
        if (selectall!=null){
            int addsubject = mapper.Addsubject(s);
            if (addsubject!=0){
                sqlSession.close();
                back=true;
                return back;
            }else {
                sqlSession.close();
                back=false;
                return back;
            }
        } else if (selectall==null){
            int addunknowsubject = mapper.Addunknowsubject(s);
            if (addunknowsubject!=0){
                int addsubject = mapper.Addsubject(s);
                if (addsubject!=0){
                    sqlSession.close();
                    back= true;
                    return back;
                }
            }else {
                sqlSession.close();
                back= false;
                return back;
            }
        }

       return back;
    }
    /*老师为自己删除课程*/
    public boolean deletesubject(String subjectid,String teacherid){
        sqlSession = sqlSessionFactory.openSession(true);
        SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
        int deletesubject = mapper.deletesubject(subjectid, teacherid);
        if (deletesubject!=0){
            sqlSession.close();
            return true;
        }else {
            sqlSession.close();
            return false;
        }
    }
}
