package com.iflytek.tms.mapper;

import com.iflytek.tms.pojo.StudentCourse;

import java.util.List;
import java.util.Map;

/**
 * @author XiaoFeng
 * @date 2019/5/2 - 22:13
 */
public interface StudentCourseDao {
    public List<StudentCourse> getPageAll(Map map);
    public int getAllStudentCourseCount();
    public int getStudentCourseByNameAndTimeCount(Map map);
    public List<StudentCourse>getStudentCourseByNameAndTime(Map map);
    public  void  addStudentCourse(StudentCourse studentCourse);


}
