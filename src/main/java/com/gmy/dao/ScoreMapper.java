package com.gmy.dao;

import com.gmy.pojo.Query1;
import com.gmy.pojo.Score;
import com.gmy.pojo.ScoreUpdate;
import com.gmy.pojo.Student_score_subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreMapper {
    /*表单提交查询成绩*/
    List<Student_score_subject> QueryScore(@Param("begin") int begin,@Param("size") int size,@Param("Query1") Query1 query1);
    int selectTotalCountbyCondition(Query1 query1);
    /*显示所有人的所有成绩*/
    List<Student_score_subject> selectall();
    /*成绩录入*/
    int addscore(Score s);

    /*下面是分页查询功能*/
    List<Student_score_subject> selectBypage(@Param("begin") int begin,@Param("size") int size);
    int selectTotalCount();
    /*下面是删除功能*/
    int deletedata(@Param("studentid") String studentid,@Param("subjectid") String subjectid);
    /*下面是修改功能 */
    int updateddata(ScoreUpdate s);
    /*学生端查询成绩*/
    List<Student_score_subject> selectBypagetostudent(@Param("begin") int begin,@Param("size") int size,@Param("studentid") String studentid);
    int selectTotalCounttostudent(@Param("studentid")String studentid);
}
