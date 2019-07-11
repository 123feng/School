package com.iflytek.tms.service;

import com.iflytek.tms.pojo.Exam;
import com.iflytek.tms.pojo.StudentVo;

import java.util.List;

/**
 * @author XiaoFeng
 * @date 2019/5/3 - 2:49
 */
public interface ExamService {
    public List<Exam> getExamByMtid(Integer id);

    Integer getExamTotalCount();

    List<StudentVo> getExamNameAndCount();

    void deleteExam(Integer id);

    void  addExam(Exam exam);
}
