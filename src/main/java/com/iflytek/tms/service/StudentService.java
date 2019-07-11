package com.iflytek.tms.service;

import com.iflytek.tms.pojo.Student;
import com.iflytek.tms.pojo.StudentVo;

import java.util.List;

/**
 * @author XiaoFeng
 * @date 2019/4/30 - 11:13
 */
public interface StudentService {
    public Integer getStudentTotalCount();
    public List<Student> getStudentByMusicTypeId(Integer id);
    public List<StudentVo> getMusicTypeNameAndCount();
    public Student getStudentById(Integer id);
    public  void  updateStudent(Student student);
    public  void  addStudent(Student student);
    public List<Student> getAllStudent();
}
