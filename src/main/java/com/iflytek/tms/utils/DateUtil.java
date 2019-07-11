package com.iflytek.tms.utils;



import com.iflytek.tms.pojo.Week;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author XiaoFeng
 * @date 2019/5/4 - 9:20
 */
public  class DateUtil {

   public  static List<Date> dateToWeek(Date mdate){
      int b=mdate.getDay();
      if (b==0){
          b=7;
      }
      Date fdate;
      List<Date> list=new ArrayList<Date>();
      Long fTime=mdate.getTime()-b * 24 * 3600000;
       for (int a = 1; a <=7 ; a++) {
         fdate=new Date();
         fdate.setTime(fTime+(a * 24 * 3600000));
         list.add(a-1,fdate);
       }
       return list;
   }

   public  static  List<Week> getOneWeekDate(){
    List<Date> dataWeek=dateToWeek(new Date());

    List<Week> result=new ArrayList<Week>();

    SimpleDateFormat sdf=new SimpleDateFormat("EEE");

       for (Date date : dataWeek) {
           Calendar c=Calendar.getInstance();
           c.setTime(date);

           String xingqi=sdf.format(date.getTime());
           int  year=c.get(Calendar.YEAR);
           int month=c.get(Calendar.MARCH)+1;
           int day=c.get(Calendar.DAY_OF_MONTH);
           Week w=new Week();
             w.setXingqi(xingqi);
             w.setYear(year);
            w.setMonth(month);
            w.setDay(day);
           result.add(w);
       }
         return  result;


   }


    public static void main(String[] args) {
        System.out.println(getOneWeekDate().toString());
    }

    }





