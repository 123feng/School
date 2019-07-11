package com.iflytek.tms.mapper;

import com.iflytek.tms.pojo.Student;
import com.iflytek.tms.pojo.StudentVo;
import com.iflytek.tms.pojo.User;

import java.util.List;

/**
 * @author XiaoFeng
 * @date 2019/4/30 - 11:02
 */
public interface StudentDao {
    public Integer getStudentTotalCount();
    public List<Student> getStudentByMusicTypeId(Integer id);
    public List<StudentVo> getMusicTypeNameAndCount();
    public Student getStudentById(Integer id);
    public  void  updateStudent(Student student);
    public  void  addStudent(Student student);
    public List<Student> getAllStudent();
}
