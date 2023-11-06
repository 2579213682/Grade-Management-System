import com.sams.dao.ScoreMapper;
import com.sams.dao.StudentMapper;
import com.sams.pojo.Query1;
import com.sams.pojo.Score;
import com.sams.pojo.Student;
import com.sams.pojo.Student_score_subject;
import com.sams.util.SqlSF_tools;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class Test {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @org.junit.Test
    public void test1() {
        sqlSessionFactory = SqlSF_tools.getSqlSessionFactory();
        sqlSession = sqlSessionFactory.openSession(true);
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);
        List<Student_score_subject> student_score_subjects = mapper.selectBypage(0, 5);
        for (int i = 0; i < student_score_subjects.size(); i++) {
            System.out.println(student_score_subjects.get(i).toString());
        }
        int i = mapper.selectTotalCount();
        System.out.println(i);
    }
}