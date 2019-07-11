package com.iflytek.tms.pojo;
/**
 *
 Create Table

 CREATE TABLE `t_exam` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `stuid` int(11) DEFAULT NULL,
 `musictypeid` int(11) DEFAULT NULL,
 `level` varchar(10) DEFAULT NULL,
 `price` double DEFAULT NULL,
 `time` date DEFAULT NULL,
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8

 */

/**
 * @author XiaoFeng
 * @date 2019/4/29 - 18:58
 * 等级考试
 */
public class Exam {
    private  Integer id;
    private  Student student;
    private  MusicType musicType;
    private  String level;
    private Double price;
    private String time;


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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
