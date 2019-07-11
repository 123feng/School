package com.iflytek.tms.service.impl;

import com.iflytek.tms.mapper.StudentCourseDao;
import com.iflytek.tms.pojo.StudentCourse;
import com.iflytek.tms.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XiaoFeng
 * @date 2019/5/3 - 1:30
 */
@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    @Autowired
    private StudentCourseDao studentCourseDao;

    @Override
    public List<StudentCourse> getPageAll(Map map) {
        return studentCourseDao.getPageAll(map);
    }

    @Override
    public int getAllStudentCourseCount() {
        return studentCourseDao.getAllStudentCourseCount();
    }



    public Map  getparam(String sname, String starttime, String endtime){
        Map map=new HashMap();
        map.put("sname",sname);
        if (starttime != null && !starttime.equals("")) {
            map.put("starttime",starttime+" 00:00:00");
        }
        if (endtime != null && !endtime.equals("")) {
            map.put("endtime",endtime+" 23:59:59");
        }

        return map;
    }





    @Override
    public int getStudentCourseByNameAndTimeCount(String sname, String starttime, String endtime) {

        return studentCourseDao.getStudentCourseByNameAndTimeCount(getparam(sname,starttime,endtime));
    }

    @Override
    public List<StudentCourse> getStudentCourseByNameAndTime(String sname, String starttime, String endtime, Integer start, Integer end) {
        Map map=getparam(sname,starttime,endtime);
        map.put("start",start);
        map.put("end",end);
        return studentCourseDao.getStudentCourseByNameAndTime(map);
    }

   /* @Override
    public int getStudentCourseByNameAndTimeCount(Map map) {
        return studentCourseDao.getStudentCourseByNameAndTimeCount(map);
    }

    @Override
    public List<StudentCourse> getStudentCourseByNameAndTime(Map map) {
        return studentCourseDao.getStudentCourseByNameAndTime(map);
    }*/





    @Override
    @Transactional
    public void addStudentCourse(StudentCourse studentCourse) {
        studentCourseDao.addStudentCourse(studentCourse);
    }


}
