package com.iflytek.tms.pojo;
/**
 *CREATE TABLE `t_student` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `name` varchar(20) DEFAULT NULL,
 *   `age` int(11) DEFAULT NULL,
 *   `sex` bit(1) DEFAULT NULL,
 *   `telephone` varchar(20) DEFAULT NULL,
 *   `classlevel` varchar(20) DEFAULT NULL,
 *   `address` varchar(20) DEFAULT NULL,
 *   `musictypeid` int(11) DEFAULT NULL,
 *   `isrent` bit(1) DEFAULT NULL,
 *   `isbuy` bit(1) DEFAULT NULL,
 *   `wantbuy` bit(1) DEFAULT NULL,
 *   `isfinish` bit(1) DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8
 */

/**
 * @author XiaoFeng
 * @date 2019/4/29 - 18:56
 * 学生
 */
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private Integer  sex;
    private String telephone;
    private String  grade;
    private String classlevel;
    private String address;
    private  MusicType musicType;
    private Integer  isrent;
    private Integer  isbuy;
    private Integer  wantbuy;
    private Integer  isfinish;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getClasslevel() {
        return classlevel;
    }

    public void setClasslevel(String classlevel) {
        this.classlevel = classlevel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public MusicType getMusicType() {
        return musicType;
    }

    public void setMusicType(MusicType musicType) {
        this.musicType = musicType;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getIsrent() {
        return isrent;
    }

    public void setIsrent(Integer isrent) {
        this.isrent = isrent;
    }

    public Integer getIsbuy() {
        return isbuy;
    }

    public void setIsbuy(Integer isbuy) {
        this.isbuy = isbuy;
    }

    public Integer getWantbuy() {
        return wantbuy;
    }

    public void setWantbuy(Integer wantbuy) {
        this.wantbuy = wantbuy;
    }

    public Integer getIsfinish() {
        return isfinish;
    }

    public void setIsfinish(Integer isfinish) {
        this.isfinish = isfinish;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", telephone='" + telephone + '\'' +
                ", classlevel='" + classlevel + '\'' +
                ", address='" + address + '\'' +
                ", musicType=" + musicType +
                ", isrent='" + isrent + '\'' +
                ", isbuy='" + isbuy + '\'' +
                ", wantbuy='" + wantbuy + '\'' +
                ", isfinish='" + isfinish + '\'' +
                '}';
    }
}
