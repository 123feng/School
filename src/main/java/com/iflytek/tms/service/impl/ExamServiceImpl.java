package com.iflytek.tms.service.impl;

import com.iflytek.tms.mapper.ExamDao;
import com.iflytek.tms.pojo.Exam;
import com.iflytek.tms.pojo.StudentVo;
import com.iflytek.tms.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author XiaoFeng
 * @date 2019/5/3 - 2:49
 */
@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamDao   examDao;
    @Override
    public List<Exam> getExamByMtid(Integer id) {
        return examDao.getExamByMtid(id);
    }

    @Override
    public Integer getExamTotalCount() {
        return examDao.getExamTotalCount();
    }

    @Override
    public List<StudentVo> getExamNameAndCount() {
        return examDao.getExamNameAndCount();
    }

    @Override
    @Transactional
    public void deleteExam(Integer id) {
        examDao.deleteExam(id);
    }

    @Override
    @Transactional
    public void addExam(Exam exam) {
        examDao.addExam(exam);
    }
}
