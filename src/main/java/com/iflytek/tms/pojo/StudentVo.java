package com.iflytek.tms.pojo;

/**
 * @author XiaoFeng
 * @date 2019/4/30 - 14:22
 * 学生的封装类
 */
public class StudentVo {

private  String name;
private  Integer musicTypeCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMusicTypeCount() {
        return musicTypeCount;
    }

    public void setMusicTypeCount(Integer musicTypeCount) {
        this.musicTypeCount = musicTypeCount;
    }
}
