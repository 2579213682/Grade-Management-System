package com.sams.pojo;

public class CLASS {
    private String class_id;
    private String class_name;
    private String teacherid;
    private String classid;


    public CLASS() {
    }

    public CLASS(String class_id, String class_name, String teacherid, String classid) {
        this.class_id = class_id;
        this.class_name = class_name;
        this.teacherid = teacherid;
        this.classid = classid;
    }

    /**
     * 获取
     * @return class_id
     */
    public String getClass_id() {
        return class_id;
    }

    /**
     * 设置
     * @param class_id
     */
    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    /**
     * 获取
     * @return class_name
     */
    public String getClass_name() {
        return class_name;
    }

    /**
     * 设置
     * @param class_name
     */
    public void setClass_name(String class_name) {
        this.class_name = class_name;
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
        return "CLASS{class_id = " + class_id + ", class_name = " + class_name + ", teacherid = " + teacherid + ", classid = " + classid + "}";
    }
}
