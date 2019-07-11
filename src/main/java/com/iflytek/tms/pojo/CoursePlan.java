package com.iflytek.tms.pojo;
/**
 *
 Create Table

 CREATE TABLE `t_courseplan` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `stuid` int(11) DEFAULT NULL,
 `musictypeid` int(11) DEFAULT NULL,
 `starttime` datetime DEFAULT NULL,
 `endtime` datetime DEFAULT NULL,
 `teaid` int(11) DEFAULT NULL,
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8

 */

/**
 * @author XiaoFeng
 * @date 2019/4/29 - 18:58
 * 学生排课
 */
public class CoursePlan {
    private  Integer id;
    private  Student student;
    private  MusicType musicType;
    private  String starttime;
    private  String endtime;
    private  Teacher teacher;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public MusicType getMusicType() {
        return musicType;
    }

    public void setMusicType(MusicType musicType) {
        this.musicType = musicType;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


}
