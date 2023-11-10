package com.gmy.pojo;

public class Student {
    private String student_id;
    private String student_name;
    private String student_password;
    private String classid;

    public Student() {
    }

    public Student(String student_id, String student_name, String student_password, String classid) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_password = student_password;
        this.classid = classid;
    }

    /**
     * 获取
     * @return student_id
     */
    public String getStudent_id() {
        return student_id;
    }

    /**
     * 设置
     * @param student_id
     */
    public void setStudent_id(String student_id) {
        this.student_id = student_id;
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
     * @return student_password
     */
    public String getStudent_password() {
        return student_password;
    }

    /**
     * 设置
     * @param student_password
     */
    public void setStudent_password(String student_password) {
        this.student_password = student_password;
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

    public String toString() {
        return "Student{student_id = " + student_id + ", student_name = " + student_name + ", student_password = " + student_password + ", classid = " + classid + "}";
    }
}
