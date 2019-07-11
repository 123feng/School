package com.iflytek.tms.pojo;
/**
 *
 Create Table

 CREATE TABLE `t_studentprice` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `stuid` int(11) DEFAULT NULL,
 `teaid` int(11) DEFAULT NULL,
 `musictypeid` int(11) DEFAULT NULL,
 `level` varchar(10) DEFAULT NULL,
 `price` double DEFAULT NULL,
 `totalprice` double DEFAULT NULL,
 `time` date DEFAULT NULL,
 `totalclass` int(11) DEFAULT NULL,
 `leftclass` int(11) DEFAULT NULL,
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8

 */

/**
 * @author XiaoFeng
 * @date 2019/4/29 - 18:55
 * 学生缴费
 */
public class StudentPrice {
    private  Integer id;
    private Student student;
    private Teacher teacher;
    private MusicType musicType;
    private String level;
    private  Double  price;
    private  Double totalprice;
    private String time;
    private  Integer totalclass;
    private  Integer leftclass;

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

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getTotalclass() {
        return totalclass;
    }

    public void setTotalclass(Integer totalclass) {
        this.totalclass = totalclass;
    }

    public Integer getLeftclass() {
        return leftclass;
    }

    public void setLeftclass(Integer leftclass) {
        this.leftclass = leftclass;
    }
}
