package com.gmy.pojo;

public class Teacher {
    private String teacher_id;
    private String teacher_name;
    private String teacher_password;

    public Teacher() {
    }

    public Teacher(String teacher_id, String teacher_name, String teacher_password) {
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.teacher_password = teacher_password;
    }

    /**
     * 获取
     * @return teacher_id
     */
    public String getTeacher_id() {
        return teacher_id;
    }

    /**
     * 设置
     * @param teacher_id
     */
    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    /**
     * 获取
     * @return teacher_name
     */
    public String getTeacher_name() {
        return teacher_name;
    }

    /**
     * 设置
     * @param teacher_name
     */
    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    /**
     * 获取
     * @return teacher_password
     */
    public String getTeacher_password() {
        return teacher_password;
    }

    /**
     * 设置
     * @param teacher_password
     */
    public void setTeacher_password(String teacher_password) {
        this.teacher_password = teacher_password;
    }

    public String toString() {
        return "Teacher{teacher_id = " + teacher_id + ", teacher_name = " + teacher_name + ", teacher_password = " + teacher_password + "}";
    }
}
