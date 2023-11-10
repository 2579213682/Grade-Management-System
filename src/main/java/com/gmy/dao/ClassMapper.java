package com.gmy.dao;

import com.gmy.pojo.CLASS;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassMapper {
    /*分页查询*/
    List<CLASS> selectBypage(@Param("begin") int begin, @Param("size") int size, @Param("teacherid") String teacherid);

    int selectTotalCount(@Param("teacherid") String teacherid);
    /*添加任课班级*/
    int Addclass(CLASS c);
    /*删除任课班级*/
    int deleteclass(@Param("classid")String classid,@Param("teacherid") String teacherid);


}
