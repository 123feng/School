package com.iflytek.tms.service;

import com.iflytek.tms.pojo.StudentCourse;

import java.util.List;
import java.util.Map;

/**
 * @author XiaoFeng
 * @date 2019/5/3 - 1:30
 */
public interface StudentCourseService {
    public List<StudentCourse> getPageAll(Map map);
    public int getAllStudentCourseCount();






    public int getStudentCourseByNameAndTimeCount(String sname, String starttime,String  endtime );
    public List<StudentCourse>getStudentCourseByNameAndTime(String sname, String starttime,String  endtime,Integer start,Integer end);

    public  void  addStudentCourse(StudentCourse studentCourse);
}
