package com.sams.pojo;

public class ScoreUpdate {
    private String studentid;
    private String student_name;
    private String classid;
    private String subjectid;
    private String score;

    public ScoreUpdate() {
    }

    public ScoreUpdate(String studentid, String student_name, String classid, String subjectid, String score) {
        this.studentid = studentid;
        this.student_name = student_name;
        this.classid = classid;
        this.subjectid = subjectid;
        this.score = score;
    }

    /**
     * 获取
     * @return studentid
     */
    public String getStudentid() {
        return studentid;
    }

    /**
     * 设置
     * @param studentid
     */
    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    /**
     * 获取
     * @return student_name
     */
    public String getStudent_name() {
        return student_name;
    }

    /**
     * 设置
     * @param student_name
     */
    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    /**
     * 获取
     * @return classid
     */
    public String getClassid() {
        return classid;
    }

    /**
     * 设置
     * @param classid
     */
    public void setClassid(String classid) {
        this.classid = classid;
    }

    /**
     * 获取
     * @return subjectid
     */
    public String getSubjectid() {
        return subjectid;
    }

    /**
     * 设置
     * @param subjectid
     */
    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    /**
     * 获取
     * @return score
     */
    public String getScore() {
        return score;
    }

    /**
     * 设置
     * @param score
     */
    public void setScore(String score) {
        this.score = score;
    }

    public String toString() {
        return "ScoreBack{studentid = " + studentid + ", student_name = " + student_name + ", classid = " + classid + ", subjectid = " + subjectid + ", score = " + score + "}";
    }
}
