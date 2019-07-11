package com.iflytek.tms.pojo;
/**
 *
 CREATE TABLE `t_studentcourse` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `stuid` int(11) DEFAULT NULL,
 `teaid` int(11) DEFAULT NULL,
 `musictypeid` int(11) DEFAULT NULL,
 `type` varchar(10) DEFAULT NULL,
 `starttime` datetime DEFAULT NULL,
 `endtime` datetime DEFAULT NULL,
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8

 */

/**
 * @author XiaoFeng
 * @date 2019/4/29 - 18:57
 * 学生课程
 */

public class StudentCourse {
    private Integer id;
    private Student student;
    private Teacher teacher;
    private MusicType musicType;
    private String  type;
    private  String starttime;
    private  String endtime;

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public MusicType getMusicType() {
        return musicType;
    }

    public void setMusicType(MusicType musicType) {
        this.musicType = musicType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
