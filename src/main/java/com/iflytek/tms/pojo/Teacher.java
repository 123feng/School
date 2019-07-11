package com.iflytek.tms.pojo;
/**
 * @author XiaoFeng
 * @date 2019/4/29 - 18:53
 * 老师
 */
public class Teacher {
    private  Integer id;
    private  String name;
    private  String  note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
