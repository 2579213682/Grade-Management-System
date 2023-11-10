package com.gmy.dao;

import com.gmy.pojo.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubjectMapper {
    /*分页查询*/
    List<Subject> selectBypage(@Param("begin") int begin, @Param("size") int size, @Param("teacherid") String teacherid);
    int selectTotalCount(@Param("teacherid") String teacherid);
    /*添加老师课程*/
    int Addsubject(Subject s);
    /*向数据库添加未存在的课程*/
    int Addunknowsubject(Subject s);
    /*查询添加是否存在课程*/
    List<Subject> selectall(@Param("subject_id") String subject_id);
    /*老师删除自己的课程*/
    int deletesubject(@Param("subjectid") String subjectid,@Param("teacherid") String teacherid);

}
