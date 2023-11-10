package com.gmy.pojo;

public class Score {
    private String studentid;
    private String score;
    private String subjectid;

    public Score() {
    }

    public Score(String studentid, String score, String subjectid) {
        this.studentid = studentid;
        this.score = score;
        this.subjectid = subjectid;
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

    public String toString() {
        return "Score{studentid = " + studentid + ", score = " + score + ", subjectid = " + subjectid + "}";
    }
}
