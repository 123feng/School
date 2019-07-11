package com.iflytek.tms.service.impl;

import com.iflytek.tms.mapper.TeacherDao;
import com.iflytek.tms.pojo.Teacher;
import com.iflytek.tms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XiaoFeng
 * @date 2019/5/2 - 22:31
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;
    @Override
    public List<Teacher> getAllTeacher() {
        return teacherDao.getAllTeacher();
    }
}
