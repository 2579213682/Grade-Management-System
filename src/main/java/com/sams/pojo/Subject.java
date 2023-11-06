package com.sams.pojo;

public class Subject {
    private String subjectid;
    private String teacherid;
    private String subject_id;
    private String subject_name;


    public Subject() {
    }

    public Subject(String subjectid, String teacherid, String subject_id, String subject_name) {
        this.subjectid = subjectid;
        this.teacherid = teacherid;
        this.subject_id = subject_id;
        this.subject_name = subject_name;
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
     * @return teacherid
     */
    public String getTeacherid() {
        return teacherid;
    }

    /**
     * 设置
     * @param teacherid
     */
    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    /**
     * 获取
     * @return subject_id
     */
    public String getSubject_id() {
        return subject_id;
    }

    /**
     * 设置
     * @param subject_id
     */
    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    /**
     * 获取
     * @return subject_name
     */
    public String getSubject_name() {
        return subject_name;
    }

    /**
     * 设置
     * @param subject_name
     */
    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String toString() {
        return "Subject{subjectid = " + subjectid + ", teacherid = " + teacherid + ", subject_id = " + subject_id + ", subject_name = " + subject_name + "}";
    }
}
