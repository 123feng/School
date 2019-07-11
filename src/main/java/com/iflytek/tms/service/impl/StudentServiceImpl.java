package com.iflytek.tms.service.impl;

import com.iflytek.tms.mapper.StudentDao;
import com.iflytek.tms.pojo.Student;
import com.iflytek.tms.pojo.StudentVo;
import com.iflytek.tms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author XiaoFeng
 * @date 2019/4/30 - 11:14
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public Integer getStudentTotalCount() {
        return studentDao.getStudentTotalCount();
    }

    @Override
    public List<Student> getStudentByMusicTypeId(Integer id) {
        return studentDao.getStudentByMusicTypeId(id);
    }

    @Override
    public List<StudentVo> getMusicTypeNameAndCount() {
        return studentDao.getMusicTypeNameAndCount();
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentDao.getStudentById(id);
    }

    @Override
   @Transactional
    public void updateStudent(Student student) {
      studentDao.updateStudent(student);
    }

    @Override
    @Transactional
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }
}
