package com.iflytek.tms.pojo;

/**
 * @author XiaoFeng
 * @date 2019/5/6 - 21:18
 * 一周的信息
 */
public class Week {
    private  String xingqi;
    private  Integer year;
    private  Integer month;
    private  Integer day;

    public Week() {
    }
    public Week(String xingqi, int year, int month, int day) {
    }

    public String getXingqi() {
        return xingqi;
    }

    public void setXingqi(String xingqi) {
        this.xingqi = xingqi;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Week{" +
                "xingqi='" + xingqi + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
